package org.acme.common.dto.todo.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CreateTodoDto {

    @NotBlank(message="Title may not be blank")
    public String title;

    @NotBlank(message="Url may not be blank")
    public String url;

    @Min(message="Order must be positive", value=0)
    public int order;

}
