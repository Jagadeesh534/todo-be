package com.todo.api.repo;

import com.todo.api.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile,Long> {

    Optional<Profile> findByNameAndEmail(String name, String email);

    Optional<Profile> findById(Long id);


}
