package com.example.autosystem.ui.controller;

import com.example.autosystem.service.TrainerService;
import com.example.autosystem.shared.dto.TrainerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class TrainerController {
    @Autowired
    TrainerService trainerService;
    @PostMapping("/trainers")
    public TrainerDto createTrainer(@RequestBody TrainerDto trainerDto) {
        if (trainerDto.getLogin() != null && trainerDto.getPassword() != null) {
            return   trainerService.createTrainer(trainerDto);
        } else {
            return null;
        }

    }
    @GetMapping("/trainers/{id}")
    public TrainerDto getTrainerById(@PathVariable Long id) {
        return trainerService.getTrainerById(id);

    }
    @PutMapping("/trainers/{id}")
    public TrainerDto updateTrainer(@PathVariable Long id, @RequestBody TrainerDto trainerDto) {
        if (trainerDto.getLogin() != null && trainerDto.getPassword() != null) {
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
