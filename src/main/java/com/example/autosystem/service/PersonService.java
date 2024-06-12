package com.example.autosystem.service;

import com.example.autosystem.shared.dto.GroupDto;
import com.example.autosystem.shared.dto.PersonDto;
import com.example.autosystem.shared.dto.TrainerDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PersonService {
    PersonDto createPerson(PersonDto personDto);
    PersonDto getPersonById(Long personId);
    PersonDto updatePersonAllInfo(Long personId, PersonDto personDto);
    PersonDto updatePersonGroup(Long personId, PersonDto personDto);
    List<PersonDto> getAllPersons(@RequestParam(required = false) GroupDto name, Long id);
    PersonDto getPersonsByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName);
    void deletePerson(Long personId);
    PersonDto updatePersonStatus(Long personId, PersonDto personDto);
    void deleteAllPersons();
    PersonDto getPersonByTrainerId(TrainerDto trainerId);
    PersonDto getPersonsByStatus();


}
