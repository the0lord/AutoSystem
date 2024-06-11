package com.example.autosystem.ui.controller;

import com.example.autosystem.io.TrainerRepository;
import com.example.autosystem.io.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class TrainerController {
    @Autowired
    TrainerRepository trainerRepository;
    @PostMapping("/trainers")
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
        try {
            Trainer _trainer = trainerRepository
                    .save(new Trainer(trainer.getLogin(), trainer.getPassword()));
            return new ResponseEntity<>(_trainer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/trainers/{id}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
        try {
            Trainer trainer = trainerRepository.findById(id).get();
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/trainers/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable Long id, @RequestBody Trainer trainer) {
        Optional<Trainer> trainerData = trainerRepository.findById(id);
        if (trainerData.isPresent()) {
            Trainer _trainer = trainerData.get();
            _trainer.setLogin(trainer.getLogin());
            _trainer.setPassword(trainer.getPassword());
            _trainer.setPersonList(trainer.getPersonList());
            return new ResponseEntity<>(trainerRepository.save(_trainer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/trainers/{id}")
    public ResponseEntity<HttpStatus> deleteTrainer(@PathVariable Long id) {
        try {
            trainerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/trainers/{login}")
    public ResponseEntity<Trainer> getTrainerByLogin(@PathVariable String login) {
        try {
            Trainer trainer = trainerRepository.findByLogin(login);
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
