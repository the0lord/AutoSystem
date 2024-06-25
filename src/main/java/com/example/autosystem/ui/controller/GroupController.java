package com.example.autosystem.ui.controller;

import com.example.autosystem.io.entity.Group;
import com.example.autosystem.service.GroupService;
import com.example.autosystem.shared.dto.GroupDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class GroupController {
    @Autowired
    GroupService groupService;
    @GetMapping("/groups")
    public List<GroupDto> getAllGroups() {
        return groupService.getAllGroups();
    }
    @GetMapping("/group/{id}")
    public GroupDto getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }
    @PutMapping("/group/trainer/{id}")
    public GroupDto updateGroupTrainer(@PathVariable Long id, @RequestBody Group group) {
        GroupDto groupDto;
        ModelMapper modelMapper = new ModelMapper();
        groupDto = modelMapper.map(group, GroupDto.class);
        return groupService.updateGroupTrainer(id, groupDto);
    }
    @PutMapping("/group/name{id}")
    public GroupDto updateGroupName(@PathVariable Long id, @RequestBody Group group) {
        GroupDto groupDto;
        ModelMapper modelMapper = new ModelMapper();
        groupDto = modelMapper.map(group, GroupDto.class);
        return groupService.updateGroupName(id, groupDto);
    }
    @PostMapping("/group")
    public GroupDto createGroup(@RequestBody GroupDto groupDto) {
        if (groupDto.getName() != null) {

            return groupService.createGroup(groupDto);
        } else {
            return null;
        }
    }
    @PutMapping("/group/person/{id}")
    public GroupDto updateGroupPerson(@PathVariable Long id, @RequestBody Group group) {
        GroupDto groupDto;
        ModelMapper modelMapper = new ModelMapper();
        groupDto = modelMapper.map(group, GroupDto.class);
        return groupService.updateGroupPerson(id, groupDto);
    }
    @DeleteMapping("/group/{id}")
    public GroupDto deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return null;
    }


}
