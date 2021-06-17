package com.kodilla.backend.controller;

import com.kodilla.backend.domain.PredictionView;
import com.kodilla.backend.domain.RankingRecord;
import com.kodilla.backend.service.ViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1",  produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ViewController {

    private final ViewService viewService;

    @GetMapping("/ranking")
    public List<RankingRecord> getRanking() {
        return viewService.getRanking();
    }

    @GetMapping("/predictionView")
    public List<PredictionView> getPredictions() {
        return viewService.getPredictions();
    }

    @GetMapping("/predictionView/{userId}&{matchId}")
    public Optional<PredictionView> getPrediction(@PathVariable Long userId, @PathVariable Long matchId) {
        return viewService.getPrediction(userId, matchId);
    }

    @GetMapping("/predictionView/user/{id}")
    public List<PredictionView> getPredictionsByUser(@PathVariable Long id) {
        return viewService.getPredictionsByUser(id);
    }

    @GetMapping("/predictionView/match/{id}")
    public List<PredictionView> getPredictionsByMatch(@PathVariable Long id) {
        return viewService.getPredictionsByMatch(id);
    }
}
