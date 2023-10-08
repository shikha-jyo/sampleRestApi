package com.example.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
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
    public Map<String,List<ShowDto>>  getListByMovieId(@RequestParam("movieId") Long movieId,
                                                       @RequestParam("from") String date) {

   DateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
   Date formatedDate = new Date();
   try {
       if(Optional.of(date).isPresent())
           formatedDate = format.parse(date);

   } catch(ParseException pe)  {
      System.out.println("Wrong format passed" + pe.getMessage());
   }

    List<ShowDto>  result = showRepository.queryByMovieId(movieId,formatedDate);
    Map<String,List<ShowDto>> resultMap= result.stream().collect(Collectors.groupingBy(s -> s.getTheatreName()));

    return resultMap;

    }
}
