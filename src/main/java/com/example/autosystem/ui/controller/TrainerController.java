package com.example.autosystem.ui.controller;

import com.example.autosystem.io.TrainerRepository;
import com.example.autosystem.io.entity.Trainer;
import com.example.autosystem.service.TrainerService;
import com.example.autosystem.shared.dto.TrainerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class TrainerController {
    @Autowired
    TrainerService trainerService;
    @PostMapping("/trainers")
    public TrainerDto createTrainer(@RequestBody Trainer trainer) {
        TrainerDto trainerDto;
        if (trainer.getLogin() != null && trainer.getPassword() != null) {
            ModelMapper modelMapper = new ModelMapper();
            trainerDto = modelMapper.map(trainer, TrainerDto.class);
            trainerService.createTrainer(trainerDto);
            return trainerDto;
        } else {
            return null;
        }

    }
    @GetMapping("/trainers/{id}")
    public TrainerDto getTrainerById(@PathVariable Long id) {
        return trainerService.getTrainerById(id);

    }
    @PutMapping("/trainers/{id}")
    public TrainerDto updateTrainer(@PathVariable Long id, @RequestBody Trainer trainer) {
        TrainerDto trainerDto;
        if (trainer.getLogin() != null && trainer.getPassword() != null) {
            ModelMapper modelMapper = new ModelMapper();
            trainerDto = modelMapper.map(trainer, TrainerDto.class);
            trainerService.updateTrainer(id, trainerDto);
            return trainerDto;
        } else {
            return null;
        }
    }
    @DeleteMapping("/trainers/{id}")
    public void deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
    }
    @GetMapping("/trainers/{login}")
    public TrainerDto getTrainerByLogin(@PathVariable String login) {
        return trainerService.getTrainerByLogin(login);
    }
}
