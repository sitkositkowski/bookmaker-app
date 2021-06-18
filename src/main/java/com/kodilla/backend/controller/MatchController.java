package com.kodilla.backend.controller;

import com.kodilla.backend.dto.MatchDto;
import com.kodilla.backend.repository.MatchRepository;
import com.kodilla.backend.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin("*")
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

    @GetMapping("/{id}")
    public Optional<MatchDto> getMatch(@PathVariable Long id) {return matchService.getMatch(id);}

    @GetMapping("/api")
    public List<MatchDto> getMatchesFromApi() {
        List<MatchDto> matches = matchService.getMatchesFromApi();
        return matches;
    }

    @PostMapping("/api")
    public List<MatchDto> createMatchesFromApi() {
        List<MatchDto> matches = matchService.getMatchesFromApi();
        return matches.stream()
                .map(matchService::saveMatch)
                .collect(Collectors.toList());
    }
}
