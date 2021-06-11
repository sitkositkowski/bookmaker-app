package com.kodilla.mapper;

import com.kodilla.domain.Match;
import com.kodilla.domain.Prediction;
import com.kodilla.domain.User;
import com.kodilla.dto.PredictionDto;
import com.kodilla.dto.UserDto;
import com.kodilla.enums.Winner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PredictionMapperTestSuite {

    @Autowired
    PredictionMapper predictionMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    MatchMapper matchMapper;



    @Test
    void testMapFromDto() {
        //Given
        PredictionDto predictionDto = PredictionDto.builder()
                .id(1L)
                .matchId(1L)
                .userId(1L)
                .homeTeamScore(0)
                .awayTeamScore(0)
                .winner(Winner.DRAW)
                .points(0)
                .build();
        //When
        Prediction prediction = predictionMapper.mapFromDto(predictionDto);
        //Then
        assertEquals(1L, prediction.getId());
        assertEquals(0, prediction.getHomeTeamScore());
        assertEquals(0, prediction.getAwayTeamScore());
        assertEquals(Winner.DRAW, prediction.getWinner());
        assertEquals(0, prediction.getPoints());

    }

    @Test
    void testMapToDto() {
        Prediction prediction = Prediction.builder()
                .id(1L)
                .match(Match.builder().id(1L).build())
                .user(User.builder().id(1L).build())
                .homeTeamScore(0)
                .awayTeamScore(0)
                .winner(Winner.DRAW)
                .points(0)
                .build();
        //When
        PredictionDto predictionDto = predictionMapper.mapToDto(prediction);
        //Then
        assertEquals(1L, predictionDto.getId());
        assertEquals(1L, predictionDto.getMatchId());
        assertEquals(1L, predictionDto.getUserId());
        assertEquals(0, predictionDto.getHomeTeamScore());
        assertEquals(0, predictionDto.getAwayTeamScore());
        assertEquals(Winner.DRAW, predictionDto.getWinner());
        assertEquals(0, predictionDto.getPoints());
    }
}
