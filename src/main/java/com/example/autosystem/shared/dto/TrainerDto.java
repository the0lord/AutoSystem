package com.example.autosystem.shared.dto;

import com.example.autosystem.io.entity.Group;
import com.example.autosystem.io.entity.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrainerDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3114901492903644372L;
    private Long id;
    private String login;
    private String password;
    private List<PersonDto> personList = new ArrayList<>();

    private List<GroupDto> groupList = new ArrayList<>();

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

    public List<PersonDto> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonDto> personList) {
        this.personList = personList;
    }

    public List<GroupDto> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupDto> groupList) {
        this.groupList = groupList;
    }
}
