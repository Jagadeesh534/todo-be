package com.todo.api.service;

import com.todo.api.request.ProfileRequest;
import com.todo.api.request.SearchTaskObj;
import com.todo.api.request.TasksRequest;
import com.todo.api.response.ProfileResponse;
import com.todo.api.response.TasksResponse;

import java.util.List;

public interface TodoService {

    public ProfileResponse saveProfile(ProfileRequest profile);

    public TasksResponse saveTask(TasksRequest task);

    public List<TasksResponse> getAll(SearchTaskObj profileTask);

    public void deleteTask(Long id);
}
