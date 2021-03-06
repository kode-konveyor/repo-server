package com.kodekonveyor.authentication;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.kodekonveyor.annotations.ExcludeFromCodeCoverage;
import com.kodekonveyor.annotations.InterfaceClass;
import com.kodekonveyor.logging.LogSeverityEnum;
import com.kodekonveyor.logging.LoggerService;

@InterfaceClass
@ExcludeFromCodeCoverage("interface to underlying framework")
@Service
public class RemoteAuthenticationFilter extends GenericFilterBean
    implements Filter {

  @Autowired
  private LoggerService loggerService;

  @Autowired
  private SlfMDCWrapper mdc;

  @Autowired
  private UserEntityRepository userEntityRepository;

  private UserEntity createNewUserWithCredential(final String login) {
    final UserEntity newUser = new UserEntity();
    newUser.setLogin(login);
    userEntityRepository.save(newUser);
    return newUser;
  }

  @Override
  public void doFilter(
      final ServletRequest req, final ServletResponse res,
      final FilterChain filterChain
  ) throws IOException, ServletException {
    if (loggerService == null) {
      final ServletContext servletContext = req.getServletContext();
      final WebApplicationContext webApplicationContext =
          WebApplicationContextUtils.getWebApplicationContext(servletContext);
      loggerService = webApplicationContext.getBean(LoggerService.class);
      userEntityRepository =
          webApplicationContext.getBean(UserEntityRepository.class);
      mdc =
          webApplicationContext.getBean(SlfMDCWrapper.class);
    }
    loggerService.call(
        AuthenticationConstants.AUTHENTICATING, LogSeverityEnum.DEBUG,
        AuthenticationConstants.EMPTY_MESSAGE
    );
    final HttpServletRequest httpRequest = (HttpServletRequest) req;
    final SecurityContext context = SecurityContextHolder.getContext();
    final Enumeration<String> names = httpRequest.getHeaderNames();
    loggerService
        .call(
            AuthenticationConstants.HEADERS, LogSeverityEnum.DEBUG,
            ((Boolean) names.hasMoreElements()).toString()
        );
    while (names.hasMoreElements()) {
      final String name = names.nextElement();
      loggerService.call(
          AuthenticationConstants.HEADER, LogSeverityEnum.DEBUG,
          name + AuthenticationConstants.COLON + httpRequest.getHeader(name)
      );
    }
    final String login =
        httpRequest.getHeader(AuthenticationConstants.NICKNAME_HEADER);
    mdc.put(AuthenticationConstants.AUTH_USER, login);
    mdc.put(AuthenticationConstants.AUTH_SESSION, UUID.randomUUID().toString());
    loggerService
        .call(AuthenticationConstants.LOGIN, LogSeverityEnum.INFO, login);
    final List<UserEntity> users =
        userEntityRepository.findByLogin(login);
    UserEntity user;
    if (users.isEmpty()) {
      user = createNewUserWithCredential(login);
      userEntityRepository.save(user);
    } else
      user = users.get(0);
    final Authentication auth = new RemoteAuthentication(user);
    SecurityContextHolder.getContext().setAuthentication(auth);
    filterChain.doFilter(req, res);
    context.setAuthentication(null);
    mdc.clear();

  }

}
