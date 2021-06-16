package com.kodilla.backend.dto;

import com.kodilla.backend.domain.PredictionKey;
import com.kodilla.backend.enums.Winner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PredictionDto {

    private PredictionKey id;
    private Long userId;
    private Long matchId;
    private Winner winner;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private Integer points;
}
