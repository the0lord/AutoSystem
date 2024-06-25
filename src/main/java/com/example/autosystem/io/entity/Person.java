package com.example.autosystem.io.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="person")
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 3114901492903644372L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name",nullable=false)
    private String firstName;
    @Column(name = "last_name",nullable=false)
    private String lastName;
    @Column(name = "middle_name",nullable=false)
    private String middleName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id",nullable=false)
    private Group groupId;
    @Column(name = "payment",nullable=false)
    private Integer payment;
    @Column(name = "first_name_p")
    private String firstNameP;
    @Column(name = "last_name_p")
    private String lastNameP;
    @Column(name = "middle_name_p")
    private String middleNameP;
    @Column(name = "birthday",nullable=false)
    private Date birthday;
    @Column(name = "number",nullable=false)
    private Integer number;
    @Column(name = "number_p")
    private Integer numberP;
    @Column(name = "registered",nullable=false)
    private Date registered;
    @Column(name = "info_channel",nullable=false)
    private String infoChannel;
    @Column(name = "school")
    private String school;
    @Column(name = "address")
    private String address;
    @Column(name = "height",nullable=false)
    private Integer height;
    @Column(name = "weight",nullable=false)
    private Integer weight;
    @Column(name = "status")
    private Boolean status;





}
