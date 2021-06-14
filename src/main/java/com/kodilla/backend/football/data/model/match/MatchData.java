package com.kodilla.backend.football.data.model.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodilla.backend.enums.MatchStatus;
import com.kodilla.backend.football.data.model.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchData {

    private String id;
    private MatchStatus status;
    private Team homeTeam;
    private Team awayTeam;
    private MatchScore score;

}
