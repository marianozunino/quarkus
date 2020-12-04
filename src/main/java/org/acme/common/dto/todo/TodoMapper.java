package org.acme.common.dto.todo;

import org.acme.common.dto.todo.request.CreateTodoDto;
import org.acme.common.dto.todo.response.ReadTodoDto;
import org.acme.model.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface TodoMapper {
    ReadTodoDto toResource(Todo todo);
    List<ReadTodoDto> toList(List<Todo> todos);
    Todo toSource(CreateTodoDto createTodoDto);
}
