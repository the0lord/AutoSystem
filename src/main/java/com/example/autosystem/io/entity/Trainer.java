package com.example.autosystem.io.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="trainer")
public class Trainer implements Serializable {
    @Serial
    private static final long serialVersionUID = 3114901492903644372L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "login",nullable=false)
    private String login;
    @Column(name = "password",nullable=false)
    private String password;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Group> groupList = new ArrayList<>();










}
