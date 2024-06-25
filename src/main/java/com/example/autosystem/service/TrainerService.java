package com.example.autosystem.service;

import com.example.autosystem.shared.dto.TrainerDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface TrainerService extends UserDetailsService {
    TrainerDto createTrainer(TrainerDto trainerDto);
    TrainerDto getTrainerById(Long trainerId);
    TrainerDto updateTrainer(Long id,TrainerDto trainerDto);
    void deleteTrainer(Long trainerId);
    TrainerDto getTrainerByLogin(String login);

}
