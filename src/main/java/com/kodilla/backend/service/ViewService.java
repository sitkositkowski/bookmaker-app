package com.kodilla.backend.service;

import com.kodilla.backend.domain.*;
import com.kodilla.backend.dto.PredictionDto;
import com.kodilla.backend.repository.PredictionViewRepository;
import com.kodilla.backend.repository.RankingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ViewService {
    private final RankingRepository rankingRepository;
    private final PredictionViewRepository predictionViewRepository;

    public List<RankingRecord> getRanking() {
        return rankingRepository.findAll(Sort.by("points"));
    }

    public List<PredictionView> getPredictions() { return predictionViewRepository.findAll();}

    public Optional<PredictionView> getPrediction(final Long userId, final Long matchId) {
        return predictionViewRepository.findById(new PredictionKey(userId, matchId));
    }

    public List<PredictionView> getPredictionsByUser(final Long id) {
        return predictionViewRepository.findByUserId(id);
    }

    public List<PredictionView> getPredictionsByMatch(final Long id) {
        return predictionViewRepository.findByMatchId(id);
    }
}
