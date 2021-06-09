package com.kodilla.service;

import com.kodilla.domain.Prediction;
import com.kodilla.domain.User;
import com.kodilla.dto.PredictionDto;
import com.kodilla.mapper.PredictionMapper;
import com.kodilla.mapper.UserMapper;
import com.kodilla.repository.PredictionRepository;
import com.kodilla.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PredictionService {

    private final PredictionRepository predictionRepository;
    private final UserRepository userRepository;
    private final PredictionMapper predictionMapper;
    private final UserMapper userMapper;

    public List<PredictionDto> getPredictions() {
        return predictionRepository.findAll(Sort.by("matchId"))
                .stream()
                .map(predictionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public Optional<PredictionDto> getPrediction(final Long id) {
        return predictionRepository.findById(id)
                .map(predictionMapper::mapToDto);
    }

    @SneakyThrows
    public PredictionDto savePrediction(final PredictionDto predictionDto) {
        Prediction prediction = predictionMapper.mapFromDto(predictionDto);
        Optional<User> user = userRepository.findById(predictionDto.getUserId());
        if (user.isPresent()) {
            prediction.setUser(user.get());
        } else {
            throw new NotFoundException("User doesn't exist, please change the user.");
        }
        prediction = predictionRepository.save(prediction);
        return predictionMapper.mapToDto(prediction);
    }
}
