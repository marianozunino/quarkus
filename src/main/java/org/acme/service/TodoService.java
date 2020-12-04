package org.acme.service;

import org.acme.common.dto.todo.request.CreateTodoDto;
import org.acme.common.dto.todo.response.ReadTodoDto;

import java.util.List;

public interface TodoService {
    List<ReadTodoDto> getTodos();
    ReadTodoDto createTodo(CreateTodoDto createTodoDto);
}
