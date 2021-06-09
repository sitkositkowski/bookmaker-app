package com.kodilla.dto;

import com.kodilla.enums.Duration;
import com.kodilla.enums.MatchStatus;
import com.kodilla.enums.Winner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchDto {

    private Long id;
    private MatchStatus status;
    private String homeTeam;
    private String awayTeam;
    private Winner winner;
    private Duration duration;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
}
