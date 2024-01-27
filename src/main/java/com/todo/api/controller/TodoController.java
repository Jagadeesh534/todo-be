package com.todo.api.controller;

import com.todo.api.request.ProfileRequest;
import com.todo.api.request.SearchTaskObj;
import com.todo.api.request.TasksRequest;
import com.todo.api.response.GoogleResponse;
import com.todo.api.response.ProfileResponse;
import com.todo.api.response.TasksResponse;
import com.todo.api.response.TodoResponse;
import com.todo.api.service.TodoService;
import com.todo.api.util.GoogleOAuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private GoogleOAuthUtil googleOAuthUtil;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hi there");
    }

    @PostMapping("/save-profile")
    public ResponseEntity<TodoResponse> saveProfile(@RequestBody ProfileRequest profileRequest) {
        ProfileResponse response = todoService.saveProfile(profileRequest);
        TodoResponse todoResponse = new TodoResponse("success", response);
        return ResponseEntity.ok(todoResponse);
    }

    @PostMapping("/save-task")
    public ResponseEntity<TodoResponse> saveTask(@RequestBody TasksRequest tasksRequest) {
        TasksResponse response = todoService.saveTask(tasksRequest);
        TodoResponse todoResponse = new TodoResponse("success", response);
        return ResponseEntity.ok(todoResponse);
    }

    @PostMapping("/get-all")
    public ResponseEntity<TodoResponse> getAllTasks(@RequestBody SearchTaskObj searchTaskObj) {
        List<TasksResponse> response = todoService.getAll(searchTaskObj);
        TodoResponse todoResponse = new TodoResponse("success", response);
        return ResponseEntity.ok(todoResponse);
    }

    @GetMapping("/get-user-data")
    public ResponseEntity<TodoResponse> googleResponse(@RequestParam String token) {
        GoogleResponse response = googleOAuthUtil.googleResponse(token);
        ProfileRequest profileRequest = new ProfileRequest();
        profileRequest.setEmail(response.getEmail());
        profileRequest.setName(response.getName());
        ProfileResponse profileResponse = todoService.saveProfile(profileRequest);
        response.setProfileId(profileResponse.getId());
        TodoResponse todoResponse = new TodoResponse("success", response);
        return ResponseEntity.ok(todoResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TodoResponse> deleteTask(@PathVariable Long id) {
        todoService.deleteTask(id);
        TodoResponse todoResponse = new TodoResponse("success", "Deleted");
        return ResponseEntity.ok(todoResponse);
    }
}
