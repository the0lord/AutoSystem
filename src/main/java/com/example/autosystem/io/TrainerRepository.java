package com.example.autosystem.io;

import com.example.autosystem.io.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    Trainer findByLoginAndPassword(String login, String password);
    Trainer findByTrainerId(Long id);

}
