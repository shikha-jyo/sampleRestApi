package com.example.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;
@GetMapping("/movieById")
    public Map<String,List<ShowDto>>  getListByMovieId(@RequestParam("movieId") Long movieId) {


    List<ShowDto>  result = showRepository.queryByMovieId(movieId);
    Map<String,List<ShowDto>> resultMap= result.stream().collect(Collectors.groupingBy(s -> s.getTheatreName()));

    return resultMap;

    }
}
