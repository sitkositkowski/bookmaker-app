package com.kodilla.controller;

import com.kodilla.domain.Prediction;
import com.kodilla.dto.PredictionDto;
import com.kodilla.dto.UserDto;
import com.kodilla.enums.Winner;
import com.kodilla.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/predictions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PredictionController {

    private final PredictionService predictionService;

    @GetMapping
    public List<PredictionDto> getPredictions() {
        List<PredictionDto> predictions = new ArrayList<>();
        predictions.add(PredictionDto.builder()
                .id(1L)
                .userId(1L)
                .matchId(1L)
                .winner(Winner.HOME_TEAM)
                .homeTeamScore(2)
                .awayTeamScore(1)
                .build());
        return predictions;
    }

    @GetMapping("/{id}")
    public PredictionDto getPrediction(@PathVariable Long id) {
        return PredictionDto.builder()
                .id(1L)
                .userId(1L)
                .matchId(1L)
                .winner(Winner.HOME_TEAM)
                .homeTeamScore(2)
                .awayTeamScore(1)
                .build();
    }

    @PostMapping
    public PredictionDto createPrediction(@RequestBody PredictionDto predictionDto) {
        return PredictionDto.builder()
                .id(1L)
                .userId(1L)
                .matchId(1L)
                .winner(Winner.HOME_TEAM)
                .homeTeamScore(2)
                .awayTeamScore(1)
                .build();
    }

    @PutMapping
    public PredictionDto updatePredictions(@RequestBody PredictionDto predictionDto) {
        return PredictionDto.builder()
                .id(1L)
                .userId(1L)
                .matchId(1L)
                .winner(Winner.HOME_TEAM)
                .homeTeamScore(2)
                .awayTeamScore(1)
                .build();
    }

    @DeleteMapping("/{id}")
    public void deletePredictions(@PathVariable Long id) {

    }
}
