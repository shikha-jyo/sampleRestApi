package com.example.MovieApp.model.primary;

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
    private Long movieId;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "language")
    private String language;
    @Column(name = "duration")
    private String duration;
    @Column(name = "genre")
    private String genre;
    @Column(name = "release_date")
    private Date releaseDate;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Show> listOfShow = new ArrayList<>();

}
