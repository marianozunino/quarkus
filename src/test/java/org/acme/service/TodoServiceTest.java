package org.acme.service;

import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class TodoServiceTest {

  @Inject
  TodoService todoService;

  EasyRandom easyRandom = new EasyRandom();

  @Test
  public void test() {}
}
