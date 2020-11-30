package com.nikhilm.hourglass.gatewayservice.fallbackutils;

import com.nikhilm.hourglass.gatewayservice.response.*;

import java.util.Arrays;

public class ResponseBuilder {

    public static MovieFallbackResponse buildMovieResponse() {
        MovieFallbackResponse response = new MovieFallbackResponse();
        response.setMovies(Arrays.asList(new Movie("5f9672a3d20d3846ef8cd39d", "Knife in the Clear Water", "2016", "Drama",
                        "Ma Zishan (Yang Shengcang) is an aging Muslim farmer, part of the Hui minority. He and his family eke out an existence farming on an arid moonscape in China's northwest Ningxia province. ...",
                        "https://m.media-amazon.com/images/M/MV5BMTg1MmUwOGYtZTQ2ZS00ODgzLWFlODEtNDAxY2U4YWE0NDczXkEyXkFqcGdeQXVyNzI1NzMxNzM@._V1_SX300.jpg",
                        "99",
                        true, "N/A", "92 min", "6.5", false),
                new Movie("5f96741231a5f039c69e7235", "Fear City: A Family-Style Comedy", "1994", "Comedy, Horror", "A second-class horror movie has to be shown at Cannes Film Festival, but, before each screening, the projectionist is killed by a mysterious fellow, with hammer and sickle, just as it happens in the film to be shown.",
                        "https://m.media-amazon.com/images/M/MV5BMjVlZDliMWItMDI3ZS00OTc3LTlmZWYtZmMxZDlkMTlhYTNhXkEyXkFqcGdeQXVyMTYzMDM0NTU@._V1_SX300.jpg",
                        "8186", true, "N/A", "93 min", "7.6", false),
                new Movie("5f967471cd5fdb67817a8f1c", "The Light in the Forest", "1958", "Adventure, Drama, Family, Romance, Western",
                        "A young white man who spent his whole life raised by Native Americans is sent to live with his birth family and must learn to fit in with people he was taught to hate.",
                        "https://m.media-amazon.com/images/M/MV5BMGE5YjY5ZjYtZTRkOC00Y2MzLThjZjQtODJhNzcwYzVhMDA1XkEyXkFqcGdeQXVyMTE2NzA0Ng@@._V1_SX300.jpg",
                        "520", true, "Unrated", "83 min", "6.5", false)));
        return response;
    }

    public static TriviaFallbackResponse buildTriviaResponse() {
        TriviaFallbackResponse response = new TriviaFallbackResponse();
        response.setTriviaList(Arrays.asList(new Trivia("football", "world game", "sport", false),
                new Trivia("computer", "innovation", "technology", false),
                new Trivia("destination", "Plitvice National Park is awesome!", "travel", false),
                new Trivia("thermodynamics", "relationship between heat and other forms of energy", "science", false)));
        return response;
    }

    public static DashboardFallbackResponse buildDashboardResponse() {
        DashboardFallbackResponse response = new DashboardFallbackResponse();
        response.setFallback("Your activity details will be available shortly!");
        return response;
    }
}
