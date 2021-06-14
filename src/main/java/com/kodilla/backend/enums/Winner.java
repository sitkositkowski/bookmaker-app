package com.kodilla.backend.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Winner {
    @JsonProperty("HOME_TEAM")
    HOME_TEAM,
    @JsonProperty("AWAY_TEAM")
    AWAY_TEAM,
    @JsonProperty("DRAW")
    DRAW

}
