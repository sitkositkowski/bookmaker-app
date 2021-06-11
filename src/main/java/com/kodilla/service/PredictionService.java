package com.kodilla.service;

import com.kodilla.domain.Match;
import com.kodilla.domain.Prediction;
import com.kodilla.domain.User;
import com.kodilla.dto.PredictionDto;
import com.kodilla.mapper.MatchMapper;
import com.kodilla.mapper.PredictionMapper;
import com.kodilla.mapper.UserMapper;
import com.kodilla.repository.MatchRepository;
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
    private final MatchRepository matchRepository;
    private final PredictionMapper predictionMapper;
    private final UserMapper userMapper;
    private final MatchMapper matchMapper;

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
        Optional<Match> match = matchRepository.findById(predictionDto.getMatchId());
        if (match.isPresent()) {
            prediction.setMatch(match.get());
            if (user.isPresent()) {
                prediction.setUser(user.get());
            } else {
                throw new NotFoundException("User doesn't exist, please change the user.");
            }
        } else {
            throw new NotFoundException("Match doesn't exist, please change the match.");
        }
        prediction = predictionRepository.save(prediction);
        return predictionMapper.mapToDto(prediction);
    }

    @SneakyThrows
    public Optional<PredictionDto> updatePrediction(final PredictionDto predictionDto) {
        Optional<Prediction> prediction = predictionRepository.findById(predictionDto.getId());
        if (prediction.isPresent()) {
            prediction.ifPresent(p -> {
                p.setHomeTeamScore(predictionDto.getHomeTeamScore());
                p.setAwayTeamScore(predictionDto.getAwayTeamScore());
                p.setWinner(predictionDto.getWinner());
                p.setPoints(predictionDto.getPoints());
            });
            return prediction.map(predictionMapper::mapToDto);
        }
        return Optional.empty();
    }

    public void deletePrediction (final Long id) {
        predictionRepository.deleteById(id);
    }

}
