package com.kodilla.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PredictionResult {
    @JsonProperty("NON_INFORMATION")
    NON_INFORMATION,
    @JsonProperty("BAD_PREDICTION")
    BAD_PREDICTION,
    @JsonProperty("GOOD_PREDICTION")
    GOOD_PREDICTION,
    @JsonProperty("PERFECT_PREDICTION")
    PERFECT_PREDICTION
}
