package com.example.MovieApp;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    Long movieId;
    @Column(name = "movie_name")
    String movieName;
    @Column(name = "language")
    String language;
    @Column(name = "duration")
    String duration;
    @Column(name = "genre")
    String genre;
    @Column(name = "release_date")
    Date releaseDate;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Show> listOfShow = new ArrayList<>();

}
