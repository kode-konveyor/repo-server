package com.kodekonveyor.repo.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("constraint checking")
@TestedService("ConsistencyCheckService")
class ConsistencyCheckerServiceTest {

  @Mock
  ExampleConsistencyCheckService exampleService;

  @Spy
  List<ConsistencyChecker> mockList = new ArrayList<ConsistencyChecker>();

  @Mock
  ConsistencyChecker otherService;

  @InjectMocks
  ConsistencyCheckService underTest;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    mockList.add(exampleService);
    mockList.add(otherService);

  }

  @Test
  void test() {
    underTest.call(null, null);
    Mockito.verify(exampleService).call(Mockito.any(), Mockito.any());
    Mockito.verify(otherService).call(Mockito.any(), Mockito.any());
  }

}
