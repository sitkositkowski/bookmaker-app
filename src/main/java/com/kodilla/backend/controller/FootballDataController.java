package com.kodilla.backend.controller;

import com.kodilla.backend.football.data.model.Competition;
import com.kodilla.backend.football.data.model.match.MatchList;
import com.kodilla.backend.football.data.client.FootballDataClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1/api",  produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FootballDataController {

    private final FootballDataClient footballDataClient;

    @GetMapping("/competition")
    public Competition getCompetition() {
        return footballDataClient.getFootballApiTable();
    }

    @GetMapping("/match")
    public MatchList getMatch() {
        return footballDataClient.getMatchFromApi("");
    }


}
