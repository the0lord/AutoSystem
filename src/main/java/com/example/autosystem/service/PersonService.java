package com.example.autosystem.service;

import com.example.autosystem.shared.dto.PersonDto;
import com.example.autosystem.shared.dto.TrainerDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface PersonService {
    PersonDto createPerson(PersonDto personDto);
    PersonDto getPersonById(Long personId);
    PersonDto updatePersonAllInfo(Long personId, PersonDto personDto);
    PersonDto updatePersonGroup(Long personId, PersonDto personDto);
    PersonDto getAllPersons(@RequestParam(required = false) String name, Long id);
    PersonDto getPersonsByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName);
    PersonDto deletePerson(Long personId);
    PersonDto updatePersonStatus(Long personId, PersonDto personDto);
    PersonDto deleteAllPersons();
    PersonDto getPersonByTrainerId(TrainerDto trainerId);
    PersonDto getPersonsByStatus();


}
