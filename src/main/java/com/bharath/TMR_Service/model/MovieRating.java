package com.bharath.TMR_Service.model;

import lombok.Data;

@Data
public class MovieRating {
    private Movie movie;
    private Rating rating;

}