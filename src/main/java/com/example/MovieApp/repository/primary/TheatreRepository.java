package com.example.MovieApp.repository.primary;

import com.example.MovieApp.model.primary.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository  extends JpaRepository<Theatre,Long> {

    //public Map<Theatre,List<Show>> findShowByMovie(Long movieId); Map<Theatre,List<Show>

}
