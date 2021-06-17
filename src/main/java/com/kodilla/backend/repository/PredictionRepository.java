package com.kodilla.backend.repository;

import com.kodilla.backend.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PredictionRepository extends JpaRepository<Prediction, PredictionKey> {

    List<Prediction> findByUser(User user);

    List<Prediction> findByMatch(Match match);

    /*
    @Query("select p from predictions p " +
            "where lower(p..firstName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.lastName) like lower(concat('%', :searchTerm, '%'))")


    List<Prediction> search(@Param("searchTerm") String searchTerm);

    @Query(nativeQuery = true)
    List<RankingRecord> getRanking();
     */
}
