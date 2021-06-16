package com.kodilla.backend.predictions.checker;

import com.kodilla.backend.dto.MatchDto;
import com.kodilla.backend.dto.PredictionDto;
import com.kodilla.backend.enums.Duration;
import com.kodilla.backend.enums.MatchStatus;
import com.kodilla.backend.enums.PredictionResult;
import com.kodilla.backend.enums.Winner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CheckerTestSuite {

    @Autowired
    Checker checker;

    @Test
    public void testCheck() {
        //Given
        MatchDto matchDto = MatchDto.builder()
                .id(1L)
                .homeTeam("Test Team 1")
                .awayTeam("Test Team 2")
                .status(MatchStatus.FINISHED)
                .duration(Duration.REGULAR)
                .winner(Winner.HOME_TEAM)
                .homeTeamScore(1)
                .awayTeamScore(0)
                .build();

        PredictionDto predictionDto = PredictionDto.builder()
                //.id(1L)
                .matchId(1L)
                .userId(1L)
                .homeTeamScore(1)
                .awayTeamScore(0)
                .winner(Winner.HOME_TEAM)
                .points(0)
                .build();

        //When
        PredictionResult predictionResult =checker.check(matchDto,predictionDto);
        //Then
        assertEquals(PredictionResult.PERFECT_PREDICTION, predictionResult);
    }

    @Test
    public void testCheckIfMatchIsNotFinished() {
        //Given
        MatchDto matchDto = MatchDto.builder()
                .id(1L)
                .homeTeam("Test Team 1")
                .awayTeam("Test Team 2")
                .status(MatchStatus.LIVE)
                .duration(Duration.REGULAR)
                .winner(Winner.HOME_TEAM)
                .homeTeamScore(1)
                .awayTeamScore(0)
                .build();

        PredictionDto predictionDto = PredictionDto.builder()
                //.id(1L)
                .matchId(1L)
                .userId(1L)
                .homeTeamScore(1)
                .awayTeamScore(0)
                .winner(Winner.HOME_TEAM)
                .points(0)
                .build();

        //When
        PredictionResult predictionResult =checker.check(matchDto,predictionDto);
        //Then
        assertEquals(PredictionResult.NON_INFORMATION, predictionResult);
    }

    @Test
    public void testConvertToPoints() {
        //Given
        PredictionResult nonResult = PredictionResult.NON_INFORMATION;
        PredictionResult badResult = PredictionResult.BAD_PREDICTION;
        PredictionResult goodResult = PredictionResult.GOOD_PREDICTION;
        PredictionResult perfectResult = PredictionResult.PERFECT_PREDICTION;
        //When
        int nonPoints = checker.convertToPoints(nonResult);
        int badPoints = checker.convertToPoints(badResult);
        int goodPoints = checker.convertToPoints(goodResult);
        int perfectPoints = checker.convertToPoints(perfectResult);
        //Then
        assertEquals(0,nonPoints);
        assertEquals(0,badPoints);
        assertEquals(3,goodPoints);
        assertEquals(5,perfectPoints);
    }
}
