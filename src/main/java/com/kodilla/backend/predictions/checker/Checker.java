package com.kodilla.backend.predictions.checker;

import com.kodilla.backend.dto.PredictionDto;
import com.kodilla.backend.enums.MatchStatus;
import com.kodilla.backend.enums.PredictionResult;
import com.kodilla.backend.dto.MatchDto;
import org.springframework.stereotype.Component;

@Component
public class Checker {

    public PredictionResult check(MatchDto match, PredictionDto predictionDto){

        if (match.getStatus() == MatchStatus.FINISHED) {
            if (match.getWinner() == predictionDto.getWinner()) {
                if ((match.getHomeTeamScore().equals(predictionDto.getHomeTeamScore()) &&
                        (match.getAwayTeamScore().equals(predictionDto.getAwayTeamScore())))) {
                    return PredictionResult.PERFECT_PREDICTION;
                }
                return PredictionResult.GOOD_PREDICTION;
            }
            return PredictionResult.BAD_PREDICTION;
        }
        return PredictionResult.NON_INFORMATION;
    }

    public int convertToPoints(PredictionResult predictionResult) {
        switch (predictionResult) {
            case GOOD_PREDICTION: return 3;
            case PERFECT_PREDICTION: return 5;
            default: return 0;
        }
    }
}
