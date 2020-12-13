package org.acme.common.dto.todo;

import java.util.List;
import org.acme.common.dto.todo.request.CreateTodoDto;
import org.acme.common.dto.todo.response.ReadTodoDto;
import org.acme.model.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface TodoMapper {
  ReadTodoDto toResource(Todo todo);
  List<ReadTodoDto> toList(List<Todo> todos);

  @Mapping(target = "completed", constant = "false")
  Todo toModel(CreateTodoDto createTodoDto);
}
