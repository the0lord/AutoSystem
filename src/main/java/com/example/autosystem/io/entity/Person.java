package com.example.autosystem.io.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

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
    @Column(name = "group_name",nullable=false)
    private String groupName;
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public Person(Long id, String firstName, String lastName, String middleName, String groupName, Integer payment, String firstNameP, String lastNameP, String middleNameP, Date birthday, Integer number, Integer numberP, Date registered, String infoChannel, String school, String address, Integer height, Integer weight, Boolean status, Trainer trainer) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.groupName = groupName;
        this.payment = payment;
        this.firstNameP = firstNameP;
        this.lastNameP = lastNameP;
        this.middleNameP = middleNameP;
        this.birthday = birthday;
        this.number = number;
        this.numberP = numberP;
        this.registered = registered;
        this.infoChannel = infoChannel;
        this.school = school;
        this.address = address;
        this.height = height;
        this.weight = weight;
        this.status = status;
        this.trainer = trainer;
    }

    public Person(String firstName, String lastName, String middleName, String groupName, Integer payment, String firstNameP, String lastNameP, String middleNameP, Date birthday, Integer number, Integer numberP, Date registered, String infoChannel, String school, String address, Integer height, Integer weight, Boolean status, Trainer trainer) {
    }
    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getFirstNameP() {
        return firstNameP;
    }

    public void setFirstNameP(String firstNameP) {
        this.firstNameP = firstNameP;
    }

    public String getLastNameP() {
        return lastNameP;
    }

    public void setLastNameP(String lastNameP) {
        this.lastNameP = lastNameP;
    }

    public String getMiddleNameP() {
        return middleNameP;
    }

    public void setMiddleNameP(String middleNameP) {
        this.middleNameP = middleNameP;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumberP() {
        return numberP;
    }

    public void setNumberP(Integer numberP) {
        this.numberP = numberP;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getInfoChannel() {
        return infoChannel;
    }

    public void setInfoChannel(String infoChannel) {
        this.infoChannel = infoChannel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
