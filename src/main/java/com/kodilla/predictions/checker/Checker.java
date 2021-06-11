package com.kodilla.predictions.checker;

import com.kodilla.dto.MatchDto;
import com.kodilla.dto.PredictionDto;
import com.kodilla.enums.MatchStatus;
import com.kodilla.enums.PredictionResult;
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
