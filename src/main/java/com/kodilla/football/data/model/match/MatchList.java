package com.kodilla.football.data.model.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodilla.football.data.model.Competition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchList {

    private String count;
    private Competition competition;
    private List<MatchData> matchData;

}
