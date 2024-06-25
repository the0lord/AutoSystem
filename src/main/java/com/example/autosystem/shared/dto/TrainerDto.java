package com.example.autosystem.shared.dto;

import com.example.autosystem.io.entity.Group;
import com.example.autosystem.io.entity.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
public class TrainerDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3114901492903644372L;
    private Long id;
    private String login;
    private String password;

    private List<GroupDto> groupList = new ArrayList<>();


}
