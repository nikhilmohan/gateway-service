package com.nikhilm.hourglass.gatewayservice.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TriviaFallbackResponse {
    private List<Trivia> triviaList = new ArrayList<>();
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate feedDate;
    private boolean isFavouritesEnabled = true;
}
