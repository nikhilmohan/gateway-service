package com.nikhilm.hourglass.gatewayservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Movie {
    private String id;
    private String title;
    private String year;
    @JsonProperty("certification")
    private String rated;
    @JsonProperty("runningTime")
    private String runtime;
    private String genre;
    private String plot;
    private String poster;
    @JsonProperty("ratings")
    private String imdbRating;
    private String imdbVotes;
    private boolean used;
    @JsonProperty("favourite")
    private boolean isFavourite = false;

    public Movie(String id, String title, String year, String genre, String plot, String poster, String imdbVotes, boolean used, String rated,
                 String runtime, String imdbRating, boolean isFavourite) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.plot = plot;
        this.poster = poster;
        this.imdbVotes = imdbVotes;
        this.imdbRating = imdbRating;
        this.used = used;
        this.rated = rated;
        this.runtime = runtime;
        this.isFavourite = isFavourite;
    }
}


