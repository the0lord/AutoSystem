package com.example.autosystem.shared.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Data
public class PersonDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3114901492903644372L;
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Long groupId;
    private Integer payment;
    private String firstNameP;
    private String lastNameP;
    private String middleNameP;
    private Date birthday;
    private Integer number;
    private Integer numberP;
    private Date registered;
    private String infoChannel;
    private String school;
    private String address;
    private Integer height;
    private Integer weight;
    private Boolean status;


}
