package com.kodilla.backend.football.data.model.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodilla.backend.enums.Duration;
import com.kodilla.backend.enums.Winner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchScore {

    private Winner winner;
    private Duration duration;
    private Score fullTime;
}
