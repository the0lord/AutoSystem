package com.example.autosystem.io;

import com.example.autosystem.io.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByGroupName(String groupName);
    Group findByGroupId(Long id);
}
