package com.kodilla.backend.controller;

import com.kodilla.backend.domain.RankingRecord;
import com.kodilla.backend.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1/ranking",  produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping
    public List<RankingRecord> getRanking() {
        return rankingService.getRanking();
    }
}
