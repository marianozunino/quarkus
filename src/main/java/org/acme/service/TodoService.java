package org.acme.service;

import org.acme.common.dto.todo.response.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto> getTodos();
}
