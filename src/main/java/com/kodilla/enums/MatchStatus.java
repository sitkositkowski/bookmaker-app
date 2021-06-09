package com.kodilla.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MatchStatus {
    @JsonProperty("SCHEDULED")
    SCHEDULED,
    @JsonProperty("LIVE")
    LIVE,
    @JsonProperty("IN_PLAY")
    IN_PLAY,
    @JsonProperty("PAUSED")
    PAUSED,
    @JsonProperty("FINISHED")
    FINISHED,
    @JsonProperty("POSTPONED")
    POSTPONED,
    @JsonProperty("SUSPENDED")
    SUSPENDED,
    @JsonProperty("CANCELED")
    CANCELED
}
