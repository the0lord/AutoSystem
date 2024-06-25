package com.example.autosystem.service.impl;

import com.example.autosystem.io.repository.GroupRepository;
import com.example.autosystem.io.repository.PersonRepository;
import com.example.autosystem.io.repository.TrainerRepository;
import com.example.autosystem.io.entity.Group;
import com.example.autosystem.io.entity.Person;
import com.example.autosystem.io.entity.Trainer;
import com.example.autosystem.service.PersonService;
import com.example.autosystem.shared.dto.GroupDto;
import com.example.autosystem.shared.dto.PersonDto;
import com.example.autosystem.shared.dto.TrainerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Override
    public PersonDto createPerson(PersonDto personDto) {
        ModelMapper modelMapper = new ModelMapper();
        List<Person> storedPerson = personRepository.findByFirstNameAndLastNameAndMiddleName(personDto.getFirstName(), personDto.getLastName(), personDto.getMiddleName());
        if (storedPerson == null) {
            throw new RuntimeException("Person already exists");
        }
        Optional<Group> group = groupRepository.findById(personDto.getGroupId());
        Person person = modelMapper.map(personDto, Person.class);
        person.setGroupId(group.get());
        Person savedPerson = personRepository.save(person);
        PersonDto returnValue = modelMapper.map(savedPerson, PersonDto.class);
        return returnValue;
    }

    @Override
    public PersonDto getPersonById(Long personId) {
        PersonDto returnValue = new PersonDto();
        Optional<Person> person = personRepository.findById(personId);
        if (person.isEmpty()) {
            throw new RuntimeException("Person doesn't exists");
        }
        new ModelMapper().map(person.get(), PersonDto.class);
        BeanUtils.copyProperties(person.get(), returnValue);
        return returnValue;
    }

    @Override
    public PersonDto updatePersonAllInfo(Long personId, PersonDto personDto) {
        PersonDto returnValue = new PersonDto();
        Optional<Person> person = personRepository.findById(personId);
        Optional<Group> group =groupRepository.findById(personDto.getGroupId());
        if (person.isEmpty()) {
            throw new RuntimeException("Person doesn't exists");
        }
        person.get().setFirstName(personDto.getFirstName());
        person.get().setLastName(personDto.getLastName());
        person.get().setMiddleName(personDto.getMiddleName());
        person.get().setBirthday(personDto.getBirthday());
        person.get().setGroupId(group.get());
        person.get().setNumber(personDto.getNumber());
        person.get().setNumberP(personDto.getNumber());
        person.get().setInfoChannel(personDto.getInfoChannel());
        person.get().setSchool(personDto.getSchool());
        person.get().setAddress(personDto.getAddress());
        person.get().setHeight(personDto.getHeight());
        person.get().setWeight(personDto.getWeight());
        person.get().setStatus(personDto.getStatus());
        Person updatedPerson = personRepository.save(person.get());
        new ModelMapper().map(updatedPerson, PersonDto.class);
        BeanUtils.copyProperties(updatedPerson, returnValue);
        return returnValue;
    }

    @Override
    public PersonDto updatePersonGroup(Long personId, PersonDto personDto) {
        PersonDto returnValue = new PersonDto();
        Optional<Person> person = personRepository.findById(personId);
        Optional<Group> group =groupRepository.findById(personDto.getGroupId());
        if (person.isEmpty()) {
            throw new RuntimeException("Person doesn't exists");
        }
        person.get().setGroupId(group.get());
        Person updatedPerson = personRepository.save(person.get());
        new ModelMapper().map(updatedPerson, PersonDto.class);
        BeanUtils.copyProperties(updatedPerson, returnValue);
        return returnValue;
    }

    @Override
    public List<PersonDto> getAllPersons(@RequestParam(required = false) GroupDto name, Long id) {
        ModelMapper modelMapper = new ModelMapper();
        List<PersonDto> returnValue = new ArrayList<>();
        List<Person> persons;
        try {
            if (name == null) {
                persons = personRepository.findAll();
                for (Person person : persons) {
                    PersonDto personDto = modelMapper.map(person, PersonDto.class);
                    returnValue.add(personDto);
                }
            } else {
                persons = personRepository.findByGroupId(groupRepository.findById(id).get());
                for (Person person : persons) {
                    PersonDto personDto = modelMapper.map(person, PersonDto.class);
                    returnValue.add(personDto);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("No persons found");
        }

        return returnValue;
    }

    @Override
    public PersonDto getPersonsByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName) {
        PersonDto returnValue = new PersonDto();
        List<Person> person = personRepository.findByFirstNameAndLastNameAndMiddleName(firstName, lastName, middleName);
        if (person.isEmpty()) {
            throw new RuntimeException("Person doesn't exists");
        }
        new ModelMapper().map(person, PersonDto.class);
        BeanUtils.copyProperties(person, returnValue);
        return returnValue;
    }

    @Override
    public void deletePerson(Long personId) {
        Optional<Person> person = personRepository.findById(personId);
        if (person.isEmpty()) {
            throw new RuntimeException("Person doesn't exists");
        }
        personRepository.delete(person.get());

    }

    @Override
    public PersonDto updatePersonStatus(Long personId, PersonDto personDto) {
        PersonDto returnValue = new PersonDto();
        Optional<Person> person = personRepository.findById(personId);
        if (person.isEmpty()) {
            throw new RuntimeException("Person doesn't exists");
        }
        person.get().setStatus(personDto.getStatus());
        Person updatedPerson = personRepository.save(person.get());
        new ModelMapper().map(updatedPerson, PersonDto.class);
        BeanUtils.copyProperties(updatedPerson, returnValue);
        return returnValue;
    }

    @Override
    public void deleteAllPersons() {
        personRepository.deleteAll();
    }

    @Override
    public List<PersonDto> getPersonByTrainerId(TrainerDto trainerId) {
        List<PersonDto> returnValue = new ArrayList<>();
        Optional<Trainer> trainer = trainerRepository.findById(trainerId.getId());
        List<Person> person = personRepository.findByGroupId(groupRepository.findByTrainerId(trainer.get().getId()));
        if (person.isEmpty()) {
            throw new RuntimeException("Person doesn't exists");
        }
        new ModelMapper().map(person, PersonDto.class);
        BeanUtils.copyProperties(person, returnValue);
        return returnValue;

    }

    @Override
    public List<PersonDto> getPersonsByStatus() {
        List<PersonDto> returnValue = new ArrayList<>();
        List<Person> person = personRepository.findByStatus(true);
        if (person.isEmpty()) {
            throw new RuntimeException("Person doesn't exists");
        }
        new ModelMapper().map(person, PersonDto.class);
        BeanUtils.copyProperties(person, returnValue);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return null;
    }
}
