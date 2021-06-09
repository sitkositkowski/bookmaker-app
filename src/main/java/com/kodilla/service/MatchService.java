package com.kodilla.service;

import com.kodilla.domain.Match;
import com.kodilla.domain.User;
import com.kodilla.dto.MatchDto;
import com.kodilla.dto.PredictionDto;
import com.kodilla.dto.UserDto;
import com.kodilla.football.data.client.FootballDataClient;
import com.kodilla.football.data.model.match.MatchList;
import com.kodilla.mapper.MatchMapper;
import com.kodilla.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;
    private final FootballDataClient footballDataClient;

    public List<MatchDto> getMatches() {
        return matchRepository.findAll()
                .stream()
                .map(matchMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public Optional<MatchDto> getMatch(Long id) {
        return matchRepository.findById(id)
                .map(matchMapper::mapToDto);
    }

    public List<MatchDto> getMatchesFromApi() {
        MatchList matchList = footballDataClient.getMatchFromApi("");
        System.out.println(matchList.getMatches().get(0));
        List<MatchDto> matches = matchList.getMatches()
                .stream()
                .map(matchMapper::mapFromApi)
                .collect(Collectors.toList());
        return matches;
    }

    public MatchDto saveMatch(MatchDto matchDto) {
        Match match = matchMapper.mapFromDto(matchDto);
        match = matchRepository.save(match);
        return matchMapper.mapToDto(match);
    }

    public Optional<MatchDto> updateMatch(MatchDto matchDto) {
        Optional<Match> match = matchRepository.findById(matchDto.getId());
        if (match.isPresent()) {
            match.ifPresent(m -> {
                m.setHomeTeam(matchDto.getHomeTeam());
                m.setAwayTeam(matchDto.getAwayTeam());
                m.setStatus(matchDto.getStatus());
                m.setWinner(matchDto.getWinner());
                m.setHomeTeamScore(matchDto.getHomeTeamScore());
                m.setAwayTeamScore(matchDto.getAwayTeamScore());
            });
            return match.map(matchMapper::mapToDto);
        }
        return Optional.empty();
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
