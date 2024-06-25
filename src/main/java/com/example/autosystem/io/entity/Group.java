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
@Entity(name = "_group")
public class Group implements Serializable {
    @Serial
    private static final long serialVersionUID = 3114901492903644372L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "groupId", cascade = CascadeType.ALL)
    private List<Person> personList  = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id",nullable = false)
    private Trainer trainer;




}
