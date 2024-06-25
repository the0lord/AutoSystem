package com.example.autosystem.ui.controller;

import com.example.autosystem.service.GroupService;
import com.example.autosystem.service.PersonService;
import com.example.autosystem.shared.dto.GroupDto;
import com.example.autosystem.shared.dto.PersonDto;
import com.example.autosystem.shared.dto.TrainerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        if (personDto.getFirstName() != null && personDto.getLastName() != null && personDto.getMiddleName() != null) {
            return personService.createPerson(personDto);
        } else {
            return null;
        }

    }
    @PutMapping("/person/{id}")
    public PersonDto updatePersonAllInfo(@RequestBody PersonDto personDto, @PathVariable Long id) {
        return personService.updatePersonAllInfo(id, personDto);
    }
    @PutMapping("/person/{id}/group")
    public PersonDto updatePersonGroup(@RequestParam @PathVariable Long id, @RequestParam PersonDto personDto) {
        return personService.updatePersonGroup(id, personDto);

    }
    @DeleteMapping("/person/{id}")
    public PersonDto deletePerson(@RequestParam @PathVariable Long id) {
        personService.deletePerson(id);
        return null;
    }
    @PutMapping("/persons/{id}/status")
    public PersonDto updatePersonStatus(@RequestParam @PathVariable Long id, @RequestParam PersonDto personDto) {
        return personService.updatePersonStatus(id, personDto);
    }
    @DeleteMapping("/persons")
    public PersonDto deleteAllPersons() {
        personService.deleteAllPersons();
        return null;
    }
    @GetMapping("/persons/trainer")
    public List<PersonDto> getPersonsByTrainerId(TrainerDto trainerDto) {
        return personService.getPersonByTrainerId(trainerDto);
    }
    @GetMapping("/persons/status")
    public List<PersonDto> getPersonsByStatus() {
        return personService.getPersonsByStatus();
    }

}
