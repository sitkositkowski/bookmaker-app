package com.kodilla.backend.service;

import com.kodilla.backend.domain.Prediction;
import com.kodilla.backend.domain.PredictionKey;
import com.kodilla.backend.dto.PredictionDto;
import com.kodilla.backend.mapper.PredictionMapper;
import com.kodilla.backend.mapper.UserMapper;
import com.kodilla.backend.repository.MatchRepository;
import com.kodilla.backend.domain.Match;
import com.kodilla.backend.domain.User;
import com.kodilla.backend.mapper.MatchMapper;
import com.kodilla.backend.repository.PredictionRepository;
import com.kodilla.backend.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.ReactiveAdapterRegistry;
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

    public Optional<PredictionDto> getPrediction(final Long userId, final Long matchId) {
        return predictionRepository.findById(new PredictionKey(userId, matchId))
                .map(predictionMapper::mapToDto);
    }

    public List<PredictionDto> getPredictionsByUser(final Long id) {
        User user = userRepository.getById(id);
        return predictionRepository.findByUser(user)
                .stream()
                .map(predictionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<PredictionDto> getPredictionsByMatch(final Long id) {
        Match match = matchRepository.getById(id);
        return predictionRepository.findByMatch(match)
                .stream()
                .map(predictionMapper::mapToDto)
                .collect(Collectors.toList());
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
        prediction.setId(new PredictionKey(predictionDto.getMatchId(), predictionDto.getUserId()));
        System.out.println(prediction);
        prediction = predictionRepository.save(prediction);
        return predictionMapper.mapToDto(prediction);
    }

    @SneakyThrows
    public Optional<PredictionDto> updatePrediction(final PredictionDto predictionDto) {
        PredictionKey predictionKey = new PredictionKey(predictionDto.getUserId(),predictionDto.getMatchId());
        Optional<Prediction> prediction = predictionRepository.findById(predictionKey);
        if (prediction.isPresent()) {
            prediction.ifPresent(p -> {
                p.setHomeTeamScore(predictionDto.getHomeTeamScore());
                p.setAwayTeamScore(predictionDto.getAwayTeamScore());
                p.setWinner(predictionDto.getWinner());
                p.setPoints(predictionDto.getPoints());
            });
            predictionRepository.save(prediction.get());
            return prediction.map(predictionMapper::mapToDto);
        }
        return Optional.empty();
    }

    public void deletePrediction (final Long userId, final Long matchId) {
        predictionRepository.deleteById(new PredictionKey(userId, matchId));
    }


}
