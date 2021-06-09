package com.kodilla.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Duration {
    @JsonProperty("REGULAR")
    REGULAR,
    @JsonProperty("PENALTY_SHOOTOUT")
    PENALTY_SHOOTOUT,
    @JsonProperty("EXTRA_TIME")
    EXTRA_TIME
}
