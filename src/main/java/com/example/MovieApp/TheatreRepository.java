package com.example.MovieApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TheatreRepository  extends JpaRepository<Theatre,Long> {

    //public Map<Theatre,List<Show>> findShowByMovie(Long movieId); Map<Theatre,List<Show>

}
