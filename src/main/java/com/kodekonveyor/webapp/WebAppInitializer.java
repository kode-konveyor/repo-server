package com.kodekonveyor.webapp;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.kodekonveyor.annotations.ExcludeFromCodeCoverage;
import com.kodekonveyor.annotations.InterfaceClass;

@InterfaceClass
@ExcludeFromCodeCoverage("interface to underlaying framework")
@Component
public class WebAppInitializer implements WebApplicationInitializer {

  public static XmlWebApplicationContext context;

  public XmlWebApplicationContext getContext() {
    context = new XmlWebApplicationContext();
    context.setConfigLocations(WebappConstants.WEB_INF_APPLICATION_CONTEXT_XML);
    return context;
  }

  @Override
  public void onStartup(final ServletContext servletContext) {

    final WebApplicationContext context = getContext();
    servletContext.addListener(new ContextLoaderListener(context));

    final CharacterEncodingFilter characterEncodingFilter =
        new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding(WebappConstants.UTF_8);
    characterEncodingFilter.setForceEncoding(true);
    servletContext.addFilter(
        WebappConstants.CHARACTER_ENCODING_FILTER, characterEncodingFilter
    )
        .addMappingForUrlPatterns(null, false, WebappConstants.SLASH_STAR);
  }

}
