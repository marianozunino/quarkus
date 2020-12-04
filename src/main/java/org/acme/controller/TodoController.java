package org.acme.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.acme.common.dto.todo.request.CreateTodoDto;
import org.acme.common.dto.todo.response.ReadTodoDto;
import org.acme.service.TodoService;

@Path("/quarks")
@ApplicationScoped
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @POST
    @Transactional
    public ReadTodoDto createTodo(@Valid CreateTodoDto createTodoDto) {
        return todoService.createTodo(createTodoDto);
    }
}
