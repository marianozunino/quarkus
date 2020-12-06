package org.acme.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import org.acme.common.dto.todo.request.CreateTodoDto;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class TodoServiceTest {

  @Inject
  TodoService todoService;

  EasyRandom easyRandom = new EasyRandom();

  @Test
  public void test() {
    var createTodoDto = easyRandom.nextObject(CreateTodoDto.class);
    createTodoDto.title = createTodoDto.title.substring(0, 19);
    createTodoDto.url = createTodoDto.url.substring(0, 19);

    var result = todoService.createTodo(createTodoDto);

    assertEquals(createTodoDto.title, result.getTitle());
  }
}
