package com.example.autosystem.io.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<Person> personList = new ArrayList<>();
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Group> groupList = new ArrayList<>();



    public Trainer(String login, String password, List<Person> personList) {
        this.login = login;
        this.password = password;
        this.personList = personList;
    }


    public Trainer() {
    }

    public Trainer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
