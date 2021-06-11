package com.kodilla.scheduler;

import com.kodilla.domain.Prediction;
import com.kodilla.dto.MatchDto;
import com.kodilla.dto.PredictionDto;
import com.kodilla.enums.MatchStatus;
import com.kodilla.enums.PredictionResult;
import com.kodilla.predictions.checker.Checker;
import com.kodilla.service.MatchService;
import com.kodilla.service.PredictionService;
import javassist.NotFoundException;
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
        Optional<MatchDto> match = matchService.updateMatch(matches.get(1));
        if (match.isEmpty()){
            matchService.saveMatch(matches.get(1));
        }
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
