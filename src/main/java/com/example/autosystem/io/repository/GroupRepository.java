package com.example.autosystem.io.repository;

import com.example.autosystem.io.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String groupName);
    Group findByTrainerId(Long trainerId);

}
