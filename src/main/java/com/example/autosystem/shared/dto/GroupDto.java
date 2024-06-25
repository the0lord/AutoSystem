package com.example.autosystem.shared.dto;

import com.example.autosystem.io.entity.Trainer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
public class GroupDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3114901492903644372L;
    private Long id;
    private String name;

    private Long trainerId;



}
