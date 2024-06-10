package com.example.autosystem.ui.controller;

import com.example.autosystem.io.GroupRepository;
import com.example.autosystem.io.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;
    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getAllGroups() {
        try {
            List<Group> groups = new ArrayList<Group>();
            groupRepository.findAll().forEach(groups::add);
            if (groups.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(groups, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/group/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        try {
            Group group = groupRepository.findById(id).get();
            return new ResponseEntity<>(group, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/group/{id}")
    public ResponseEntity<Group> updateGroupTrainer(@PathVariable Long id, @RequestBody Group group) {
        Group _group = groupRepository.findById(id).get();
        if (_group != null) {
            _group.setTrainer(group.getTrainer());
            return new ResponseEntity<>(groupRepository.save(_group), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/group/{groupName}")
    public ResponseEntity<Group> getGroupByGroupName(@PathVariable String groupName) {
        try {
            Group group = groupRepository.findByName(groupName);
            return new ResponseEntity<>(group, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
