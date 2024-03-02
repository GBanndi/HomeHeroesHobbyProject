package com.example.homeheroes.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", unique = true, nullable = false)
    private String userName;

    @Column(name = "picture_url")
    private String pictureUrl;

    @ManyToMany(mappedBy = "userList")
    private List<Chore> choreList;
}
