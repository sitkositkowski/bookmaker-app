package com.kodilla.football.data.model.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodilla.enums.MatchStatus;
import com.kodilla.football.data.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchData {

    private String id;
    private MatchStatus status;
    private Team homeTeam;
    private Team awayTeam;
    private MatchScore score;

}
