package com.todo.api.response;

import lombok.Data;

@Data
public class TodoResponse {

    private String message;

    private Object data;

    public TodoResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
