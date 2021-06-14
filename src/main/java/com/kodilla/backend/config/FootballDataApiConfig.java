package com.kodilla.backend.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class FootballDataApiConfig {

    @Value("${football.data.api.endpoint}")
    private String footballDataApiEndpoint;
    @Value("${football.data.api.token}")
    private String footballDataApiToken;
    @Value("${football.data.api.username}")
    private String username;
}
