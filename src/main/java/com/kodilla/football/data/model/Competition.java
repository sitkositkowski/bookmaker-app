package com.kodilla.football.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.geom.Area;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Competition {

    private String id;
    //private Area area;
    private String name;
    private String code;
    private String plan;
    private String lastUpdated;

}
