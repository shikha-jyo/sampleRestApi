package com.example.MovieApp;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ShowDto {

    private Long showId;

    private Long movieId;

    private Long theatreId;

    private Date showDate;

    private Long showTime;

    private Boolean isActive;

    private String theatreName;
}
