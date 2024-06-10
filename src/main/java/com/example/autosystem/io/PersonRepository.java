package com.example.autosystem.io;

import com.example.autosystem.io.entity.Group;
import com.example.autosystem.io.entity.Person;
import com.example.autosystem.io.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName);
    List<Person> findByGroupId(Group group);
    List<Person> findByTrainer (Trainer trainerId);
    List<Person> findByStatus (Boolean status);




}
