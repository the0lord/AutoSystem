package com.example.autosystem.service.impl;

import com.example.autosystem.io.PersonRepository;
import com.example.autosystem.io.entity.Person;
import com.example.autosystem.service.PersonService;
import com.example.autosystem.shared.dto.PersonDto;
import com.example.autosystem.shared.dto.TrainerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Override
    public PersonDto createPerson(PersonDto personDto) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Person> storedPerson = personRepository.findById(personDto.getId());
        if (storedPerson.isPresent()) {
            throw new RuntimeException("Person already exists");
        }
        Person person = modelMapper.map(personDto, Person.class);
        Person savedPerson = personRepository.save(person);
        PersonDto returnValue = modelMapper.map(savedPerson, PersonDto.class);
        return returnValue;
    }

    @Override
    public PersonDto getPersonById(Long personId) {
        return null;
    }

    @Override
    public PersonDto updatePersonAllInfo(Long personId, PersonDto personDto) {
        return null;
    }

    @Override
    public PersonDto updatePersonGroup(Long personId, PersonDto personDto) {
        return null;
    }

    @Override
    public PersonDto getAllPersons(String name, Long id) {
        return null;
    }

    @Override
    public PersonDto getPersonsByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName) {
        return null;
    }

    @Override
    public PersonDto deletePerson(Long personId) {
        return null;
    }

    @Override
    public PersonDto updatePersonStatus(Long personId, PersonDto personDto) {
        return null;
    }

    @Override
    public PersonDto deleteAllPersons() {
        return null;
    }

    @Override
    public PersonDto getPersonByTrainerId(TrainerDto trainerId) {
        return null;
    }

    @Override
    public PersonDto getPersonsByStatus() {
        return null;
    }
}
