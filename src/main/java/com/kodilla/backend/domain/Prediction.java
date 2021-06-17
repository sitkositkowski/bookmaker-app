package com.kodilla.backend.domain;

import com.kodilla.backend.enums.Winner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



/*
@NamedNativeQuery(
        name = "Prediction.getRanking",
        query = "SELECT u.name as username, sum(p.points) as tpoints FROM predictions AS p JOIN users AS u WHERE p.user_id=u.id",
        resultClass = RankingRecord2.class
)

 */





@Data
@Entity
@Table(name = "predictions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prediction {

    @NotNull
    @EmbeddedId
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.AUTO)
    private PredictionKey id;

    @NotNull
    @ManyToOne
    @MapsId("matchId")
    @JoinColumn(name = "match_id")
    private Match match;

    @NotNull
    @ManyToOne//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("userId")
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
