package com.example.MovieApp;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
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
    @Column(name="show_date")
    Date showDate;
    @Column(name = "show_time")
    Long showTime;
    @Column(name = "active")
    Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie.movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre.theatre_id")
    private Theatre theatre;

}
