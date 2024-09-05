package com.bharath.TMR_Service.controller;

import com.bharath.TMR_Service.model.Rating;
import com.bharath.TMR_Service.model.RatingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/public")
@Slf4j
public class PublicController {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${ratings-service.url}")
    private String ratingsServiceUrl;

    @PostMapping
    public ResponseEntity<Object> publicAddRating(@RequestBody RatingRequest request) {
        Rating rating;
        try {
            rating = restTemplate.postForObject(ratingsServiceUrl, request, Rating.class);
            log.info("Adding rating for movie: {}", request.getName());
            return ResponseEntity.ok(rating);
        }catch (HttpStatusCodeException ex)
        {
            log.error("Error while adding rating for movie: {}", request.getName());
            return ResponseEntity.status(ex.getStatusCode())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(ex.getResponseBodyAsString());
        }
    }
}
