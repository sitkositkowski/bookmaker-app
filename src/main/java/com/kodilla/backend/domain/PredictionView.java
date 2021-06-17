package com.kodilla.backend.domain;

import com.kodilla.backend.enums.Winner;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "predictions_view")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(PredictionKey.class)
public class PredictionView implements Serializable {

    @Id
    @JoinColumn(name = "match_id")
    private Long matchId;

    @Id
    @JoinColumn(name = "user_Id")
    private Long userId;

    private String username;
    private String home_team;
    private String home_team_score;
    private String away_team_score;
    private String away_team;
    private String status;
    private String pred_home_team_score;
    private String pred_away_team_score;
    private String winner;
    private String pred_winner;
    private Integer points;

}
