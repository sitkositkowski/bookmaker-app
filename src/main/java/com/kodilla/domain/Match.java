package com.kodilla.domain;

import com.kodilla.enums.Duration;
import com.kodilla.enums.MatchStatus;
import com.kodilla.enums.Winner;
import com.kodilla.football.data.model.Team;
import com.kodilla.football.data.model.match.MatchScore;
import com.kodilla.football.data.model.match.Score;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "matches")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {

    @NotNull
    @Id
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    private String homeTeam;

    private String awayTeam;

    @Enumerated(EnumType.STRING)
    private Winner winner;

    @Enumerated(EnumType.STRING)
    private Duration duration;

    private Integer homeTeamScore;

    private Integer awayTeamScore;
}
