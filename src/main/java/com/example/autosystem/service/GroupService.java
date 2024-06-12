package com.example.autosystem.service;

import com.example.autosystem.io.entity.Group;
import com.example.autosystem.shared.dto.GroupDto;
import com.example.autosystem.shared.dto.TrainerDto;

import java.util.List;

public interface GroupService {
    List<GroupDto> getAllGroups();
    GroupDto getGroupById(Long groupId);
    GroupDto createGroup(GroupDto groupDto);
    GroupDto updateGroupTrainer(Long groupId, GroupDto groupDto);
    GroupDto updateGroupName(Long groupId, GroupDto groupDto);
    void deleteGroup(Long groupId);
    GroupDto updateGroupPerson(Long groupId, GroupDto groupDto);
}
