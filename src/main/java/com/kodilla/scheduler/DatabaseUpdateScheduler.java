package com.kodilla.scheduler;

import com.kodilla.dto.MatchDto;
import com.kodilla.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DatabaseUpdateScheduler {

    private final MatchService matchService;
    private final Updater updater;

    @Scheduled(fixedDelay = 10000)
    //@Scheduled(crom = "0 0 10 * * *")
    public void updateDatabase() {
        updater.updateMatches();
        updater.updatePredictions();
    }


}
