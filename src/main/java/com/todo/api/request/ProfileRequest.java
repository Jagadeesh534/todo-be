package com.todo.api.request;

import lombok.Data;

@Data
public class ProfileRequest {

    private Long id;

    private  String name;

    private String email;

}
