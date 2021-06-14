package com.kodilla.backend.controller;

import com.kodilla.backend.dto.PredictionDto;
import com.kodilla.backend.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1/predictions",  produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping("/user/{id}")
    public List<PredictionDto> getPredictionsByUser(@PathVariable Long id) {
        return predictionService.getPredictionsByUser(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PredictionDto createPrediction(@RequestBody PredictionDto predictionDto) {
        return predictionService.savePrediction(predictionDto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Optional<PredictionDto> updatePrediction(@RequestBody PredictionDto predictionDto) {
        return predictionService.updatePrediction(predictionDto);
    }

    @DeleteMapping("/{id}")
    public void deletePrediction(@PathVariable Long id) {
        predictionService.deletePrediction(id);
    }
}
