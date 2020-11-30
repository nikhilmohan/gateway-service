package com.nikhilm.hourglass.gatewayservice.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieFallbackResponse {
    private List<Movie> movies = new ArrayList<>();
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate feedDate = LocalDate.now();
    private boolean isFavouritesEnabled = false;
}
