package com.bharath.TMR_Service.model;
import jakarta.persistence.ElementCollection;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class Movie {

    private Long id;

    private String name;

    private String director;

    @ElementCollection
    private List<String> actors = new ArrayList<>();
}
