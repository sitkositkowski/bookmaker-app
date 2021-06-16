package com.kodilla.backend.repository;

import com.kodilla.backend.domain.Prediction;
import com.kodilla.backend.domain.PredictionKey;
import com.kodilla.backend.domain.RankingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RankingRepository extends JpaRepository<RankingRecord, String> {
}
