package com.example.autosystem.ui.controller;

import com.example.autosystem.io.PersonRepository;
import com.example.autosystem.io.entity.Group;
import com.example.autosystem.io.entity.Person;
import com.example.autosystem.io.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(required = false) String groupName) {
        try {
            List<Person> persons = new ArrayList<Person>();
            if (groupName == null)
                personRepository.findAll().forEach(persons::add);
            else
                personRepository.findByGroupName(groupName).forEach(persons::add);
            if (persons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);

            } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping("/personn")
    public ResponseEntity<List<Person>> getPersonsByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName) {
        try {
            List<Person> persons = personRepository.findByFirstNameAndLastNameAndMiddleName(firstName, lastName, middleName);
            if (persons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@RequestParam @PathVariable Long id) {
        try {
            Person person = personRepository.findById(id).get();
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            Person _person = personRepository
                    .save(new Person(person.getFirstName(),
                            person.getLastName(),
                            person.getMiddleName(),
                            person.getGroupId(),
                            person.getPayment(),
                            person.getFirstNameP(),
                            person.getLastNameP(),
                            person.getMiddleNameP(),
                            person.getBirthday(),
                            person.getNumber(),
                            person.getNumberP(),
                            person.getRegistered(),
                            person.getInfoChannel(),
                            person.getSchool(),
                            person.getAddress(),
                            person.getHeight(),
                            person.getWeight(),
                            person.getStatus(),
                            person.getTrainer()));
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePersonAllInfo(@RequestBody Person person, @PathVariable Long id) {
        Optional<Person> personData = personRepository.findById(id);
        if (personData.isPresent()) {
            Person _person = personData.get();
            _person.setFirstName(person.getFirstName());
            _person.setLastName(person.getLastName());
            _person.setMiddleName(person.getMiddleName());
            _person.setGroupId(person.getGroupId());
            _person.setPayment(person.getPayment());
            _person.setFirstNameP(person.getFirstNameP());
            _person.setLastNameP(person.getLastNameP());
            _person.setMiddleNameP(person.getMiddleNameP());
            _person.setBirthday(person.getBirthday());
            _person.setNumber(person.getNumber());
            _person.setNumberP(person.getNumberP());
            _person.setRegistered(person.getRegistered());
            _person.setInfoChannel(person.getInfoChannel());
            _person.setSchool(person.getSchool());
            _person.setAddress(person.getAddress());
            _person.setHeight(person.getHeight());
            _person.setWeight(person.getWeight());
            _person.setStatus(person.getStatus());
            _person.setTrainer(person.getTrainer());
            return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/person/{id}/group")
    public ResponseEntity<Person> updatePersonGroup(@RequestParam @PathVariable Long id, @RequestParam Group groupId) {
        Optional<Person> personData = personRepository.findById(id);
        if (personData.isPresent()) {
            Person _person = personData.get();
            _person.setGroupId(groupId);
            return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/person/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@RequestParam @PathVariable Long id) {
        try {
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/persons/{id}/status")
    public ResponseEntity<Person> updatePersonStatus(@RequestParam @PathVariable Long id, @RequestParam Boolean status) {
        Optional<Person> personData = personRepository.findById(id);
        if (personData.isPresent()) {
            Person _person = personData.get();
            _person.setStatus(status);
            return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/persons")
    public ResponseEntity<HttpStatus> deleteAllPersons() {
        try {
            personRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/persons/trainer")
    public ResponseEntity<List<Person>> getPersonsByTrainer(Trainer trainer_id) {
        try {
            List<Person> persons = personRepository.findByTrainer(trainer_id);
            if (persons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/persons/status")
    public ResponseEntity<List<Person>> getPersonsByStatus() {
        try {
            List<Person> persons = personRepository.findByStatus(true);
            if (persons.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
