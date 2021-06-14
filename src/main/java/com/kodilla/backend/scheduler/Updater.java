package com.kodilla.backend.scheduler;

import com.kodilla.backend.service.MatchService;
import com.kodilla.backend.dto.MatchDto;
import com.kodilla.backend.dto.PredictionDto;
import com.kodilla.backend.enums.PredictionResult;
import com.kodilla.backend.predictions.checker.Checker;
import com.kodilla.backend.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Updater {

    private final MatchService matchService;
    private final PredictionService predictionService;
    private final Checker checker;

    public void updateMatches() {
        List<MatchDto> matches = matchService.getMatchesFromApi();
        matches.stream()
                .forEach(match -> {
                    Optional<MatchDto> updateMatch = matchService.updateMatch(match);
                    if (updateMatch.isEmpty()){
                        matchService.saveMatch(match);
                    }
                });
    }

    public void updatePredictions(){
        List<PredictionDto> predictions = predictionService.getPredictions();
        predictions.stream()
                .forEach(predictionDto -> {
                    Optional<MatchDto> matchDto = matchService.getMatch(predictionDto.getMatchId());
                    if (matchDto.isPresent()){
                        PredictionResult predictionResult = checker.check(matchDto.get(),predictionDto);
                        predictionDto.setPoints(checker.convertToPoints(predictionResult));
                        predictionService.updatePrediction(predictionDto);
                    }
                });
    }
}
