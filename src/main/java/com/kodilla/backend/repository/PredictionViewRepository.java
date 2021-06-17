package com.kodilla.backend.repository;

import com.kodilla.backend.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface PredictionViewRepository extends JpaRepository<PredictionView, PredictionKey> {

    List<PredictionView> findByUserId(Long userId);

    List<PredictionView> findByMatchId(Long matchId);


}
