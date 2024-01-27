package com.todo.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 2000)
    private  String task;

    private LocalDateTime created;

    private LocalDateTime updated;

    private  boolean done;
    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;
}
