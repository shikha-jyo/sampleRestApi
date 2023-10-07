package com.example.MovieApp;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShowDto {

    Long showId;

    Long movieId;

    Long theatreId;

    Long showTime;

    Boolean isActive;

    String theatreName;
}
