package org.acme.controller;

import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.acme.common.dto.todo.request.CreateTodoDto;
import org.acme.common.dto.todo.response.ReadTodoDto;
import org.acme.service.TodoService;

@Path("/quarks")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @Transactional
  @DELETE
  @Path("{uuid}")
  public void deleteTodo(@PathParam(value = "uuid") UUID uuid) {
    todoService.deleteTodo(uuid);
  }

  @Transactional
  @GET
  @Path("{uuid}")
  public ReadTodoDto findTodo(@PathParam(value = "uuid") UUID uuid) {
    return todoService.findTodo(uuid);
  }

  @POST
  @Transactional
  public ReadTodoDto createTodo(@Valid CreateTodoDto createTodoDto) {
    return todoService.createTodo(createTodoDto);
  }
}
