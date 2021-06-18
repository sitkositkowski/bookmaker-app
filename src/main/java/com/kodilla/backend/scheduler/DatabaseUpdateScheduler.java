package com.kodilla.backend.scheduler;

import com.kodilla.backend.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseUpdateScheduler {

    private final MatchService matchService;
    private final Updater updater;

    //@Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 0 10 * * *")
    public void updateDatabase() {
        updater.updateMatches();
        updater.updatePredictions();
    }


}
