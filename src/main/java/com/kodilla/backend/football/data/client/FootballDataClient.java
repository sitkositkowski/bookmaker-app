package com.kodilla.backend.football.data.client;

import com.kodilla.backend.config.FootballDataApiConfig;
import com.kodilla.backend.football.data.model.Competition;
import com.kodilla.backend.football.data.model.match.MatchList;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class FootballDataClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(FootballDataClient.class);

    private final RestTemplate restTemplate;
    private final FootballDataApiConfig footballDataApiConfig;

    public Competition getFootballApiTable() {

        URI url = buildUrlCompetition("2018");
        //System.out.println(url);
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("X-Auth-Token", footballDataApiConfig.getFootballDataApiToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            Competition competition = restTemplate.exchange(url, HttpMethod.GET, entity, Competition.class).getBody();
            //System.out.println(competition);
            return competition;
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    public MatchList getMatchFromApi(String id) {

        URI url = buildUrlMatch("23");
        //System.out.println(url);
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("X-Auth-Token", footballDataApiConfig.getFootballDataApiToken());
            HttpEntity<?> entity = new HttpEntity<Object>(headers);
            MatchList matches = restTemplate.exchange(url, HttpMethod.GET, entity, MatchList.class).getBody();
            return matches;
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    public URI buildUrlCompetition(String id) {
        return UriComponentsBuilder.fromHttpUrl(footballDataApiConfig.getFootballDataApiEndpoint() + "/competitions/" + id)
                    .build().encode().toUri();
    }

    public URI buildUrlMatch(String id) {
        return UriComponentsBuilder.fromHttpUrl(footballDataApiConfig.getFootballDataApiEndpoint() + "/competitions/EC/matches")
                .build().encode().toUri();
    }






}
