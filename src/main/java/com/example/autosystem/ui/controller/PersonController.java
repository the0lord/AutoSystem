package com.example.autosystem.ui.controller;

import com.example.autosystem.io.GroupRepository;
import com.example.autosystem.io.PersonRepository;
import com.example.autosystem.io.entity.Group;
import com.example.autosystem.io.entity.Person;
import com.example.autosystem.io.entity.Trainer;
import com.example.autosystem.service.GroupService;
import com.example.autosystem.service.PersonService;
import com.example.autosystem.shared.dto.GroupDto;
import com.example.autosystem.shared.dto.PersonDto;
import com.example.autosystem.shared.dto.TrainerDto;
import org.modelmapper.ModelMapper;
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
    PersonService personService;
    @Autowired
    GroupService groupService;

    @GetMapping("/persons")
    public List<PersonDto> getAllPersons(@RequestParam(required = false) GroupDto name, Long id) {
        return personService.getAllPersons(name, id);
    }
    @GetMapping("/person/full_name")
    public PersonDto getPersonsByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName) {
        return personService.getPersonsByFirstNameAndLastNameAndMiddleName(firstName, lastName, middleName);

    }
    @GetMapping("/person/{id}")
    public PersonDto getPersonById(@RequestParam @PathVariable Long id) {
        return personService.getPersonById(id);
    }
    @PostMapping("/persons")
    public PersonDto createPerson(@RequestBody Person person) {
        PersonDto personDto;
        if (person.getFirstName() != null && person.getLastName() != null && person.getMiddleName() != null) {
            ModelMapper modelMapper = new ModelMapper();
            personDto = modelMapper.map(person, PersonDto.class);
            return personService.createPerson(personDto);
        } else {
            return null;
        }

    }
    @PutMapping("/person/{id}")
    public PersonDto updatePersonAllInfo(@RequestBody Person person, @PathVariable Long id) {
        PersonDto personDto;
        ModelMapper modelMapper = new ModelMapper();
        personDto = modelMapper.map(person, PersonDto.class);
        return personService.updatePersonAllInfo(id, personDto);
    }
    @PutMapping("/person/{id}/group")
    public PersonDto updatePersonGroup(@RequestParam @PathVariable Long id, @RequestParam Group groupId) {
        PersonDto personDto;
        ModelMapper modelMapper = new ModelMapper();
        personDto = modelMapper.map(groupId, PersonDto.class);
        return personService.updatePersonGroup(id, personDto);

    }
    @DeleteMapping("/person/{id}")
    public PersonDto deletePerson(@RequestParam @PathVariable Long id) {
        personService.deletePerson(id);
        return null;
    }
    @PutMapping("/persons/{id}/status")
    public PersonDto updatePersonStatus(@RequestParam @PathVariable Long id, @RequestParam Boolean status) {
        PersonDto personDto;
        ModelMapper modelMapper = new ModelMapper();
        personDto = modelMapper.map(status, PersonDto.class);
        return personService.updatePersonStatus(id, personDto);
    }
    @DeleteMapping("/persons")
    public PersonDto deleteAllPersons() {
        personService.deleteAllPersons();
        return null;
    }
    @GetMapping("/persons/trainer")
    public List<PersonDto> getPersonsByTrainerId(Trainer trainerId) {
        TrainerDto trainerDto;
        ModelMapper modelMapper = new ModelMapper();
        trainerDto = modelMapper.map(trainerId, TrainerDto.class);
        return personService.getPersonByTrainerId(trainerDto);
    }
    @GetMapping("/persons/status")
    public List<PersonDto> getPersonsByStatus() {
        return personService.getPersonsByStatus();
    }

}
