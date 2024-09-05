package com.bharath.TMR_Service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private int id;

    private String name;

    private double avgRating;

    private int count;
}
