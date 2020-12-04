package org.acme.service;

import org.acme.common.dto.todo.request.CreateTodoDto;
import org.acme.common.dto.todo.response.ReadTodoDto;
import org.acme.common.dto.todo.TodoMapper;
import org.acme.repository.TodoRepository;

import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceException;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@RequestScoped
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoServiceImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    @Override
    public List<ReadTodoDto> getTodos() {
        var todos = todoRepository.listAll();
        return todoMapper.toList(todos);
    }

    @Override
    public ReadTodoDto createTodo(CreateTodoDto createTodoDto) {
        try {
            var todo = todoMapper.toSource(createTodoDto);
            todoRepository.persistAndFlush(todo);
            return todoMapper.toResource(todo);
        } catch (PersistenceException p) {
            throw new WebApplicationException("Some Error", 409);
        }
    }
}
