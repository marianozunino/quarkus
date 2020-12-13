package org.acme.service;

import java.util.List;
import java.util.UUID;
import org.acme.common.dto.todo.request.CreateTodoDto;
import org.acme.common.dto.todo.response.ReadTodoDto;

public interface TodoService {
  List<ReadTodoDto> getTodos();
  ReadTodoDto createTodo(CreateTodoDto createTodoDto);
  void deleteTodo(UUID uuid);
  ReadTodoDto findTodo(UUID uuid);
}
