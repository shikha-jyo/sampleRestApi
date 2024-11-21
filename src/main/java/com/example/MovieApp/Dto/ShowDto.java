package com.example.MovieApp.Dto;

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

    @Override
    public String toString() {
        return "ShowDto{" +
                "showId=" + showId +
                ", movieId=" + movieId +
                ", theatreId=" + theatreId +
                ", showDate=" + showDate +
                ", showTime=" + showTime +
                ", isActive=" + isActive +
                ", theatreName='" + theatreName + '\'' +
                '}';
    }

    private String theatreName;
}
