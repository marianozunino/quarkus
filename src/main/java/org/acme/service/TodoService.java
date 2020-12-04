package org.acme.service;

import java.util.List;
import org.acme.common.dto.todo.request.CreateTodoDto;
import org.acme.common.dto.todo.response.ReadTodoDto;

public interface TodoService {
  List<ReadTodoDto> getTodos();
  ReadTodoDto createTodo(CreateTodoDto createTodoDto);
}
