package com.example.MovieApp.controller;

import com.example.MovieApp.Dto.ShowDto;
import com.example.MovieApp.repository.primary.ShowRepository;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    ShowRepository showRepository;

@GetMapping("/movieById")
    public Single<Map<String,List<ShowDto>> > getListByMovieId(@RequestParam("movieId") Long movieId,
                                                               @RequestParam("from") String date) {

   DateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
   Date formatedDate = new Date();
   try {
       if(Optional.of(date).isPresent())
           formatedDate = format.parse(date);

   } catch(ParseException pe)  {
      System.out.println("Wrong format passed" + pe.getMessage());
   }
   final Date finalDate = formatedDate;
   return  Single.create(singleSubscriber -> {
        List<ShowDto> result = showRepository.queryByMovieId(movieId, finalDate);
        Map<String, List<ShowDto>> resultMap = result.stream().collect(Collectors.groupingBy(s -> s.getTheatreName()));
        singleSubscriber.onSuccess(resultMap);
    });
   // return resultMap;

    }

}
