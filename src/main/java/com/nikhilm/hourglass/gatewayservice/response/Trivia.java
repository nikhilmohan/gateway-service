package com.nikhilm.hourglass.gatewayservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Trivia {
    private String term;
    private String fact;
    private String category;
    @JsonProperty("favourite")
    private boolean isFavourite = false;

}
