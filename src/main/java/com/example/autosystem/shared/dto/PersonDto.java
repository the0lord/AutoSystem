package com.example.autosystem.shared.dto;

import com.example.autosystem.io.entity.Group;
import com.example.autosystem.io.entity.Trainer;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class PersonDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3114901492903644372L;
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private GroupDto groupId;
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
    private Trainer trainer;

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

    public GroupDto getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupDto groupId) {
        this.groupId = groupId;
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
