package com.kodilla.backend.service;

import com.kodilla.backend.domain.Match;
import com.kodilla.backend.domain.Prediction;
import com.kodilla.backend.domain.PredictionKey;
import com.kodilla.backend.domain.User;
import com.kodilla.backend.dto.UserDto;
import com.kodilla.backend.enums.Winner;
import com.kodilla.backend.repository.MatchRepository;
import com.kodilla.backend.repository.PredictionRepository;
import com.kodilla.backend.repository.RankingRepository;
import com.kodilla.backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTestSuite {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PredictionRepository predictionRepository;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private RankingRepository rankingRepository;

    @Test
    void testSaveUser() {
        //Given
        UserDto userTest = new UserDto();
        userTest.setName("Test user - saveUser");

        //When
        UserDto savedUser = userService.saveUser(userTest);
        Long userId = savedUser.getId();

        //Then
        Optional<User> readUser = userRepository.findById(userId);
        assertTrue(readUser.isPresent());
        assertEquals("Test user - saveUser", readUser.get().getName());

        //CleanUp
        userRepository.deleteById(userId);
    }

    @Test
    void testUpdateUser() {
        //Given
        UserDto userTest = new UserDto();
        userTest.setName("Test user - updateUser");

        //When
        UserDto savedUser = userService.saveUser(userTest);
        Long userId = savedUser.getId();
        savedUser.setName("New name - updateUser");
        userService.updateUser(savedUser);

        //Then
        Optional<User> readUser = userRepository.findById(userId);
        assertTrue(readUser.isPresent());
        assertEquals("New name - updateUser", readUser.get().getName());

        //CleanUp
        userRepository.deleteById(userId);
    }

    @Test
    void testDeleteUser() {
        // Given
        UserDto userTest = new UserDto();
        userTest.setName("Test user - deleteUser");

        // When
        UserDto savedUser = userService.saveUser(userTest);
        Long userId = savedUser.getId();
        userRepository.deleteById(userId);
        Optional<User> userById = userRepository.findById(userId);

        // Then
        assertFalse(userRepository.existsById(userId));
        assertTrue(userById.isEmpty());
    }


    void prepareData() {

        List<Match> matches = matchRepository.findAll();
        List<User> users = userRepository.findAll();
        Prediction prediction;
        Winner winner;
        for (Match match : matches) {
            for (User user: users) {
                Random random = new Random();
                int homeTeamScore = random.nextInt(5);
                int awayTeamScore = random.nextInt(5);
                PredictionKey predictionKey = new PredictionKey(user.getId(),match.getId());
                if (homeTeamScore > awayTeamScore) {
                    winner = Winner.HOME_TEAM;
                } else if (awayTeamScore > homeTeamScore) {
                    winner = Winner.AWAY_TEAM;
                } else {
                    winner = Winner.DRAW;
                }

                prediction = Prediction.builder()
                        .id(predictionKey)
                        .user(user)
                        .match(match)
                        .homeTeamScore(homeTeamScore)
                        .awayTeamScore(awayTeamScore)
                        .points(0)
                        .winner(winner)
                        .build();

                predictionRepository.save(prediction);
            }

        }

    }

    @Test
    void testRanking() {
        System.out.println(rankingRepository.findAll());
    }

}
