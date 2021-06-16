package com.kodilla.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PredictionKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "match_id")
    private Long matchId;

}
