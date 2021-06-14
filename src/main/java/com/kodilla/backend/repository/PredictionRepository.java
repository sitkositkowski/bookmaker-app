package com.kodilla.backend.repository;

import com.kodilla.backend.domain.Prediction;
import com.kodilla.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Long> {

    List<Prediction> findByUser(User user);


}
