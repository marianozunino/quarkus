package org.acme.service;

import java.util.List;
import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceException;
import javax.ws.rs.WebApplicationException;
import org.acme.common.dto.todo.TodoMapper;
import org.acme.common.dto.todo.request.CreateTodoDto;
import org.acme.common.dto.todo.response.ReadTodoDto;
import org.acme.repository.TodoRepository;

@RequestScoped
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;
  private final TodoMapper todoMapper;

  public TodoServiceImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
    this.todoRepository = todoRepository;
    this.todoMapper = todoMapper;
  }

  @Override
  public void deleteTodo(UUID uuid) {
    todoRepository.softDelete(uuid);
  }

  @Override
  public List<ReadTodoDto> getTodos() {
    var todos = todoRepository.listAll();
    return todoMapper.toList(todos);
  }

  @Override
  public ReadTodoDto createTodo(CreateTodoDto createTodoDto) {
    try {
      var todo = todoMapper.toModel(createTodoDto);
      todoRepository.persistAndFlush(todo);
      return todoMapper.toResource(todo);
    } catch (PersistenceException p) {
      throw new WebApplicationException("Some Error", 409);
    }
  }

  @Override
  public ReadTodoDto findTodo(UUID uuid) {
    var todo = todoRepository.findByUUID(uuid);
    if (todo == null) {
      throw new WebApplicationException("Todo Not found", 404);
    }
    return todoMapper.toResource(todo);
  }
}
