package com.kodilla.football.data.model.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodilla.enums.Duration;
import com.kodilla.enums.Winner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchScore {

    private Winner winner;
    private Duration duration;
    private Score fullTime;
}
