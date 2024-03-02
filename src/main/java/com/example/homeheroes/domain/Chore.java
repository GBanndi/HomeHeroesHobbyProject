package com.example.homeheroes.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "chore")
@Data
@NoArgsConstructor
public class Chore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chore_id")
    private Long choreId;

    @Column(name = "main_category", unique = true)
    private String mainCategory;

    @Column(name = "sub_category")
    private String subCategory;

    @Column(name = "timeOfCompletion")
    private LocalDateTime timeOfCompletion;

    @Column(name = "timeOfCreation")
    private LocalDateTime timeOfCreation;

    @ManyToMany
    @JoinTable(
            name = "chore_table",
            joinColumns = @JoinColumn(name = "chore_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userList;

}
