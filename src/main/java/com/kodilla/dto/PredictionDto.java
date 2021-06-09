package com.kodilla.dto;

import com.kodilla.enums.Winner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PredictionDto {

    private Long id;
    private Long userId;
    private Long matchId;
    private Winner winner;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private Integer points;
}
