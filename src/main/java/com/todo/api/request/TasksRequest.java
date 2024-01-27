package com.todo.api.request;

import lombok.Data;

@Data
public class TasksRequest {

    private Long id;
    private  String task;
    private  boolean done;
    private Long profileId;

}
