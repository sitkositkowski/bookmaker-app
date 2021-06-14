package com.kodilla.backend.mapper;

import com.kodilla.backend.domain.Match;
import com.kodilla.backend.dto.MatchDto;
import com.kodilla.backend.football.data.model.match.MatchData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    Match mapFromDto(final MatchDto matchDto);

    MatchDto mapToDto(final Match match);

    default MatchDto mapFromApi(final MatchData matchData) {
        return MatchDto.builder()
                .id(Long.valueOf(matchData.getId()))
                .status(matchData.getStatus())
                .homeTeam(matchData.getHomeTeam().getName())
                .awayTeam(matchData.getAwayTeam().getName())
                .winner(matchData.getScore().getWinner())
                .duration(matchData.getScore().getDuration())
                .homeTeamScore(matchData.getScore().getFullTime().getHomeTeam())
                .awayTeamScore(matchData.getScore().getFullTime().getAwayTeam())
                .build();
    }

}
