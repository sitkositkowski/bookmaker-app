package com.kodilla.backend.service;

import com.kodilla.backend.domain.RankingRecord;
import com.kodilla.backend.dto.PredictionDto;
import com.kodilla.backend.repository.RankingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankingService {

    private final RankingRepository rankingRepository;

    public List<RankingRecord> getRanking() {
        return rankingRepository.findAll(Sort.by("points"));
    }
}
