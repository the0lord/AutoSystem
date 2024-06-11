package com.example.autosystem.service;

import com.example.autosystem.shared.dto.TrainerDto;

public interface TrainerService {
    TrainerDto createTrainer(TrainerDto trainerDto);
    TrainerDto getTrainerById(Long trainerId);
    TrainerDto updateTrainer(Long id,TrainerDto trainerDto);
    void deleteTrainer(Long trainerId);
    TrainerDto getTrainerByLogin(String login);

}
