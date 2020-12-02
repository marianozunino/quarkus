package org.acme.common.dto.todo;

import org.acme.model.Todo;
import org.acme.common.dto.todo.response.TodoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface TodoMapper {
    TodoDto toResource(Todo todo);
    List<TodoDto> toList(List<Todo> todos);
}
