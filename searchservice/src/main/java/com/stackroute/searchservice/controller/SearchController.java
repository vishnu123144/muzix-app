package com.stackroute.searchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping(path = "api/v1/")
public class SearchController {
    private RestTemplate restTemplate;

    @Autowired
    public SearchController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("try")
    public String getRtr() {
        return "satry";
    }


    @GetMapping("search/{artistName}")
    public ResponseEntity<?> searchTrack(@PathVariable("artistName") String artistName) {
        final String url = "http://ws.audioscrobbler.com/2.0/?method=track.search&track=" + artistName + "&api_key=9971dc24c9b4831975c292afc948d1a9&format=json&page=1&limit=30";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return this.restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
    }
}
