package com.example.MovieApp;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "show")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    Long showId;
    @Column(name = "movie_id")
    Long movieId;
    @Column(name = "theatre_id")
    Long theatreId;
    @Column(name = "start_time")
    Long startTime;
    @Column(name = "end_time")
    Long endTime;

    String theatreName;
}
