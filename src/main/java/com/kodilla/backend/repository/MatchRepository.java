package com.kodilla.backend.repository;

import com.kodilla.backend.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
