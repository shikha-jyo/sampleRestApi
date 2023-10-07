package com.example.MovieApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ShowRepository extends JpaRepository<Show,Long> {

    @Query(value = "SELECT  new com.example.MovieApp.ShowDto(s.showId, s.movieId, s.theatreId,s.showTime,s.isActive, t.theatreName)"
            + "FROM Show s,Theatre t  WHERE t.theatreId = s.theatreId" +
            " AND s.movieId=?1",
            nativeQuery = false)
    List<ShowDto> queryByMovieId(@Param("movieId") Long movieId);

}
