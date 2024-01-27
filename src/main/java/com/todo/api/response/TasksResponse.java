package com.todo.api.response;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TasksResponse {

    private  Long id;

    private String task;

    private boolean done;

    private Long profileId;

    private LocalDateTime created;

    private LocalDateTime updated;
}
