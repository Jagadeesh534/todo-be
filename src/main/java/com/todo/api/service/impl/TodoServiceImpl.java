package com.todo.api.service.impl;

import com.todo.api.entity.Profile;
import com.todo.api.entity.Tasks;
import com.todo.api.repo.ProfileRepo;
import com.todo.api.repo.TaskRepo;
import com.todo.api.request.ProfileRequest;
import com.todo.api.request.SearchTaskObj;
import com.todo.api.request.TasksRequest;
import com.todo.api.response.ProfileResponse;
import com.todo.api.response.TasksResponse;
import com.todo.api.service.TodoService;
import com.todo.api.util.TodoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public ProfileResponse saveProfile(ProfileRequest profile) {
        Profile profileToSave = TodoUtils.convertToProfile(profile);
        Optional<Profile> optionalProfile = profileRepo.findByNameAndEmail(profile.getName(), profile.getEmail());
        if(optionalProfile.isEmpty()) {
            profileRepo.save(profileToSave);
        } else {
            profileToSave.setId(optionalProfile.get().getId());
        }
        return TodoUtils.convertToProfileResponse(profileToSave);
    }

    @Override
    public TasksResponse saveTask(TasksRequest task) {
        Optional<Profile> optionalProfile = profileRepo.findById(task.getProfileId());
        Profile profile = optionalProfile.get();
        Tasks taskToSave = TodoUtils.convertToTask(task, optionalProfile.get());
        taskRepo.save(taskToSave);
        return TodoUtils.convertToTaskResponse(taskToSave);
    }

    @Override
    public List<TasksResponse> getAll(SearchTaskObj profileTask) {
        Optional<Profile> optionalProfile = profileRepo.findByNameAndEmail(profileTask.getName(),profileTask.getEmail());
        List<Tasks> tasks = taskRepo.findByProfile(optionalProfile.get());
        List<TasksResponse> tasksResponses = new ArrayList<>();
        tasks.stream().forEach((task)-> {
            tasksResponses.add(TodoUtils.convertToTaskResponse(task));
        });
        Collections.sort(tasks, new Comparator<Tasks>() {
            @Override
            public int compare(Tasks o1, Tasks o2) {
                return Boolean.compare(o1.isDone(),o1.isDone());
            }
        });
        return tasksResponses;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
