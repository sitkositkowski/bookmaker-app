package com.kodilla.backend.mapper;

import com.kodilla.backend.enums.Duration;
import com.kodilla.backend.enums.MatchStatus;
import com.kodilla.backend.enums.Winner;
import com.kodilla.backend.football.data.model.match.Score;
import com.kodilla.backend.domain.Match;
import com.kodilla.backend.dto.MatchDto;
import com.kodilla.backend.football.data.model.Team;
import com.kodilla.backend.football.data.model.match.MatchData;
import com.kodilla.backend.football.data.model.match.MatchScore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MatchMapperTestSuite {

    @Autowired
    PredictionMapper predictionMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    MatchMapper matchMapper;

    @Test
    public void testMapToDto(){
        //Given
        Match match = Match.builder()
                .id(1L)
                .homeTeam("Test Team 1")
                .awayTeam("Test Team 2")
                .status(MatchStatus.FINISHED)
                .duration(Duration.REGULAR)
                .winner(Winner.HOME_TEAM)
                .homeTeamScore(1)
                .awayTeamScore(0)
                .build();
        //When
        MatchDto matchDto = matchMapper.mapToDto(match);
        //Then
        assertEquals(1L, matchDto.getId());
        assertEquals("Test Team 1",matchDto.getHomeTeam());
        assertEquals("Test Team 2",matchDto.getAwayTeam());
        assertEquals(1, matchDto.getHomeTeamScore());
        assertEquals(0, matchDto.getAwayTeamScore());
        assertEquals(MatchStatus.FINISHED,matchDto.getStatus());
        assertEquals(Winner.HOME_TEAM, matchDto.getWinner());

    }

    @Test
    public void testMapFromDto() {
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
        //When
        Match match = matchMapper.mapFromDto(matchDto);
        //Then
        assertEquals(1L, match.getId());
        assertEquals("Test Team 1",match.getHomeTeam());
        assertEquals("Test Team 2",match.getAwayTeam());
        assertEquals(1, match.getHomeTeamScore());
        assertEquals(0, match.getAwayTeamScore());
        assertEquals(MatchStatus.FINISHED,match.getStatus());
        assertEquals(Winner.HOME_TEAM, match.getWinner());
    }

    @Test
    public void testMapFromApi() {
        //Given
        MatchData matchData = MatchData.builder()
                .id("1")
                .homeTeam(Team.builder().id("1").name("Test Team 1").build())
                .awayTeam(Team.builder().id("2").name("Test Team 2").build())
                .status(MatchStatus.FINISHED)
                .score(MatchScore.builder()
                        .winner(Winner.HOME_TEAM)
                        .duration(Duration.REGULAR)
                        .fullTime(Score.builder()
                                .homeTeam(1)
                                .awayTeam(0)
                                .build())
                        .build())
                .build();
        //When
        MatchDto matchDto = matchMapper.mapFromApi(matchData);
        //Then
        assertEquals(1L, matchDto.getId());
        assertEquals("Test Team 1",matchDto.getHomeTeam());
        assertEquals("Test Team 2",matchDto.getAwayTeam());
        assertEquals(1, matchDto.getHomeTeamScore());
        assertEquals(0, matchDto.getAwayTeamScore());
        assertEquals(MatchStatus.FINISHED,matchDto.getStatus());
        assertEquals(Winner.HOME_TEAM, matchDto.getWinner());
    }

}
