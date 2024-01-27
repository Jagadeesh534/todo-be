package com.todo.api.repo;

import com.todo.api.entity.Profile;
import com.todo.api.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Tasks,Long> {

    List<Tasks> findByProfile(Profile profile);
}
