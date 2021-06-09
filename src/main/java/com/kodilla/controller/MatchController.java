package com.kodilla.controller;

import com.kodilla.dto.MatchDto;
import com.kodilla.repository.MatchRepository;
import com.kodilla.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/matches", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;
    private final MatchRepository matchRepository;

    @GetMapping
    public List<MatchDto> getMatches() {
        return matchService.getMatches();
    }

    @GetMapping("/api")
    public List<MatchDto> getMatchesFromApi() {
        List<MatchDto> matches = matchService.getMatchesFromApi();
        /*
        List<MatchDto> oldMatches = matches.stream()
                .filter(match -> matchRepository.findById(match.getId()).isPresent())
                .collect(Collectors.toList());
        List<MatchDto> newMatches = matches.stream()
                .filter(match -> matchRepository.findById(match.getId()).isEmpty())
                .collect(Collectors.toList());

         */
        return matches;
    }

    @PostMapping("/api")
    public MatchDto createMatchesFromApi() {
        List<MatchDto> matches = matchService.getMatchesFromApi();
        return matchService.saveMatch(matches.get(0));
    }
}
