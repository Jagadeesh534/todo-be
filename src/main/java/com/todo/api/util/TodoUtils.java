package com.todo.api.util;

import com.todo.api.entity.Profile;
import com.todo.api.entity.Tasks;
import com.todo.api.request.ProfileRequest;
import com.todo.api.request.TasksRequest;
import com.todo.api.response.ProfileResponse;
import com.todo.api.response.TasksResponse;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TodoUtils {

    public static Profile convertToProfile(ProfileRequest profileRequest) {
        Profile profile = new Profile();
        profile.setEmail(profileRequest.getEmail());
        profile.setName(profileRequest.getName());
        profile.setTasks(new ArrayList<>());
        return profile;
    }

    public static Tasks convertToTask(TasksRequest tasksRequest, Profile profile) {
        Tasks task = new Tasks();
        task.setTask(tasksRequest.getTask());
        task.setId(tasksRequest.getId());
        task.setDone(tasksRequest.isDone());
        task.setUpdated(LocalDateTime.now());
        task.setCreated(LocalDateTime.now());
        task.setProfile(profile);
        return task;
    }

    public static TasksResponse convertToTaskResponse(Tasks task) {
        TasksResponse tasksResponse = new TasksResponse();
        tasksResponse.setCreated(task.getCreated());
        tasksResponse.setUpdated(task.getUpdated());
        tasksResponse.setDone(task.isDone());
        tasksResponse.setTask(task.getTask());
        tasksResponse.setId(task.getId());
        tasksResponse.setProfileId(task.getProfile().getId());
        return tasksResponse;
    }

    public static ProfileResponse convertToProfileResponse(Profile profile) {
        ProfileResponse profileResponse = new ProfileResponse();
        profileResponse.setEmail(profile.getEmail());
        profileResponse.setId(profile.getId());
        profileResponse.setEmail(profile.getEmail());
        return profileResponse;
    }

}
