package com.example.autosystem.service.impl;

import com.example.autosystem.io.GroupRepository;
import com.example.autosystem.io.PersonRepository;
import com.example.autosystem.io.TrainerRepository;
import com.example.autosystem.io.entity.Group;
import com.example.autosystem.io.entity.Person;
import com.example.autosystem.io.entity.Trainer;
import com.example.autosystem.service.GroupService;
import com.example.autosystem.shared.dto.GroupDto;
import com.example.autosystem.shared.dto.TrainerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<GroupDto> getAllGroups() {
        ModelMapper modelMapper = new ModelMapper();
        List<GroupDto> returnValue = new ArrayList<>();
        List<Group> groups = groupRepository.findAll();
        for (Group group : groups) {
            returnValue.add(modelMapper.map(group, GroupDto.class));
        }
        return returnValue;


    }

    @Override
    public GroupDto getGroupById(Long groupId) {
        GroupDto returnValue = new GroupDto();
        Optional<Group> group = groupRepository.findById(groupId);
        if (group.isEmpty()) {
            throw new RuntimeException("Group doesn't exists");
        }
        new ModelMapper().map(group.get(), GroupDto.class);
        return returnValue;
    }

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        ModelMapper modelMapper = new ModelMapper();
        Group storedGroup = groupRepository.findByName(groupDto.getName());
        if (storedGroup != null) {
            throw new RuntimeException("Group already exists");
        }
        Group group = modelMapper.map(groupDto, Group.class);
        Group savedGroup = groupRepository.save(group);
        GroupDto returnValue = modelMapper.map(savedGroup, GroupDto.class);
        return returnValue;
    }

    @Override
    public GroupDto updateGroupTrainer(Long groupId, GroupDto groupDto, TrainerDto trainerId) {
        GroupDto returnValue = new GroupDto();
        Optional<Group> group = groupRepository.findById(groupId);
        Optional<Trainer> trainer = trainerRepository.findById(trainerId.getId());
        if (group.isEmpty()) {
            throw new RuntimeException("Group doesn't exists");
        }
        group.get().setTrainer(trainer.get());
        Group updatedGroup = groupRepository.save(group.get());
        new ModelMapper().map(updatedGroup, GroupDto.class);
        BeanUtils.copyProperties(updatedGroup, returnValue);
        return returnValue;
    }

    @Override
    public GroupDto updateGroupName(Long groupId, GroupDto groupDto) {
        GroupDto returnValue = new GroupDto();
        Optional<Group> group = groupRepository.findById(groupId);
        if (group.isEmpty()) {
            throw new RuntimeException("Group doesn't exists");
        }
        group.get().setName(groupDto.getName());
        Group updatedGroup = groupRepository.save(group.get());
        new ModelMapper().map(updatedGroup, GroupDto.class);
        BeanUtils.copyProperties(updatedGroup, returnValue);
        return null;
    }

    @Override
    public void deleteGroup(Long groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        if (group.isEmpty()) {
            throw new RuntimeException("Group doesn't exists");
        }
        groupRepository.delete(group.get());
    }

    @Override
    public GroupDto updateGroupPerson(Group groupId, GroupDto groupDto) {
        GroupDto returnValue = new GroupDto();
        Optional<Group> group = groupRepository.findById(groupId.getId());
        List<Person> person = personRepository.findByGroupId(groupId);
        if (group.isEmpty()) {
            throw new RuntimeException("Group doesn't exists");
        }
        group.get().setPerson((Person) person);
        Group updatedGroup = groupRepository.save(group.get());
        new ModelMapper().map(updatedGroup, GroupDto.class);
        BeanUtils.copyProperties(updatedGroup, returnValue);
        return returnValue;
    }
}
