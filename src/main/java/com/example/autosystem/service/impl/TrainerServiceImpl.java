package com.example.autosystem.service.impl;

import com.example.autosystem.io.TrainerRepository;
import com.example.autosystem.io.entity.Trainer;
import com.example.autosystem.service.TrainerService;
import com.example.autosystem.shared.dto.TrainerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    TrainerRepository trainerRepository;
    @Override
    public TrainerDto createTrainer(TrainerDto trainerDto) {
        ModelMapper modelMapper = new ModelMapper();
        Trainer storedTrainer = trainerRepository.findByLogin(trainerDto.getLogin());
        if (storedTrainer != null) {
            throw new RuntimeException("Trainer already exists");
        }
        Trainer trainer = modelMapper.map(trainerDto, Trainer.class);
        Trainer savedTrainer = trainerRepository.save(trainer);
        TrainerDto returnValue = modelMapper.map(savedTrainer, TrainerDto.class);
        return returnValue;

    }

    @Override
    public TrainerDto getTrainerById(Long trainerId) {
        TrainerDto returnValue = new TrainerDto();
        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
        if (trainer.isEmpty()) {
            throw new RuntimeException("Trainer doesn't exists");
        }
        new ModelMapper().map(trainer.get(), TrainerDto.class);
        BeanUtils.copyProperties(trainer.get(), returnValue);

        return returnValue;
    }

    @Override
    public TrainerDto updateTrainer(Long id, TrainerDto trainerDto) {
        TrainerDto returnValue = new TrainerDto();
        Optional<Trainer> trainer = trainerRepository.findById(id);
        if (trainer.isEmpty()) {
            throw new RuntimeException("Trainer doesn't exists");
        }
        trainer.get().setLogin(trainerDto.getLogin());
        trainer.get().setPassword(trainerDto.getPassword());
        Trainer updatedTrainer = trainerRepository.save(trainer.get());
        new ModelMapper().map(updatedTrainer, TrainerDto.class);
        BeanUtils.copyProperties(updatedTrainer, returnValue);
        return returnValue;
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
        if (trainer.isEmpty()) {
            throw new RuntimeException("Trainer doesn't exists");
        }
        trainerRepository.delete(trainer.get());
    }

    @Override
    public TrainerDto getTrainerByLogin(String login) {
        TrainerDto returnValue = new TrainerDto();
        Trainer trainer = trainerRepository.findByLogin(login);
        if (trainer == null) {
            throw new RuntimeException("Trainer doesn't exists");
        }
        new ModelMapper().map(trainer, TrainerDto.class);
        BeanUtils.copyProperties(trainer, returnValue);
        return returnValue;
    }
}
