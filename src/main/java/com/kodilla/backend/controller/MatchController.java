package com.kodilla.backend.controller;

import com.kodilla.backend.dto.MatchDto;
import com.kodilla.backend.repository.MatchRepository;
import com.kodilla.backend.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1/matches", produces = MediaType.APPLICATION_JSON_VALUE)
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
