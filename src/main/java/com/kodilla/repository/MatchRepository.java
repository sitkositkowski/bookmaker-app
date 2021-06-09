package com.kodilla.repository;

import com.kodilla.domain.Match;
import com.kodilla.domain.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
