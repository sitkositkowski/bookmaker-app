package com.kodilla.controller;

import com.kodilla.dto.PredictionDto;
import com.kodilla.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1/predictions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PredictionController {

    private final PredictionService predictionService;

    @GetMapping
    public List<PredictionDto> getPredictions() {
        return predictionService.getPredictions();
    }

    @GetMapping("/{id}")
    public Optional<PredictionDto> getPrediction(@PathVariable Long id) {
        return predictionService.getPrediction(id);
    }

    @PostMapping
    public PredictionDto createPrediction(@RequestBody PredictionDto predictionDto) {
        return predictionService.savePrediction(predictionDto);
    }

    @PutMapping
    public Optional<PredictionDto> updatePrediction(@RequestBody PredictionDto predictionDto) {
        return predictionService.updatePrediction(predictionDto);
    }

    @DeleteMapping("/{id}")
    public void deletePrediction(@PathVariable Long id) {
        predictionService.deletePrediction(id);
    }
}
