package org.acme.service;

import org.acme.common.dto.todo.response.TodoDto;
import org.acme.common.dto.todo.TodoMapper;
import org.acme.repository.TodoRepository;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoServiceImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    @Override
    public List<TodoDto> getTodos() {
        var todos = todoRepository.listAll();
        return todoMapper.toList(todos);
    }
}
