package com.kodilla.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @NotNull
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 4, max = 50)
    private String name;

    /*
    @OneToMany(
            targetEntity = Prediction.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Prediction> predictions;
     */
}
