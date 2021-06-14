package com.kodilla.backend.domain;

import com.kodilla.backend.enums.Duration;
import com.kodilla.backend.enums.MatchStatus;
import com.kodilla.backend.enums.Winner;
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
