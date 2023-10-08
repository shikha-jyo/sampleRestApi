package com.example.MovieApp;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ShowDto {

    Long showId;

    Long movieId;

    Long theatreId;

    Date showDate;

    Long showTime;

    Boolean isActive;

    String theatreName;
}
