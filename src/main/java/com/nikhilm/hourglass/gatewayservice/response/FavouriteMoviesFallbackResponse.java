package com.nikhilm.hourglass.gatewayservice.response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteMoviesFallbackResponse {
    String userId;
    List<Movie> favouriteMovies = new ArrayList<>();
}
