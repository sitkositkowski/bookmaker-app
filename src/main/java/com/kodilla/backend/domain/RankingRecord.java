package com.kodilla.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ranking")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RankingRecord implements Serializable {

    //@Id
    //@GeneratedValue
    //Long id;
    @Id
    String name;

    @JoinColumn(name = "points")
    Double points;

    @JoinColumn(name = "predictions")
    Integer predictions;
}
