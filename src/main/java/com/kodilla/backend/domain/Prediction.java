package com.kodilla.backend.domain;

import com.kodilla.backend.enums.Winner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "predictions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prediction {

    @NotNull
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Winner winner;

    @NotNull
    private Integer homeTeamScore;

    @NotNull
    private Integer awayTeamScore;

    //@Enumerated(EnumType.STRING)
    //private PredictionResult result;
    private Integer points;
}
