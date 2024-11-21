package com.example.MovieApp.controller;

import com.example.MovieApp.ResourceNotFoundException;
import com.example.MovieApp.model.primary.Show;
import com.example.MovieApp.repository.primary.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowRepository showRepository;

    @PostMapping("/addShow")
    public ResponseEntity<Show> createOrUpdateShow(@RequestBody Show show) {
        Show showReturned = showRepository.save(show);
        return ResponseEntity.status(HttpStatus.CREATED).body(showReturned);

    }
    @PutMapping("/updateShow/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable(value = "id") Long showId,
                                           @RequestBody Show showDetails) throws ResourceNotFoundException {
        Show show = showRepository.findById(showId).orElseThrow(()->
        new ResourceNotFoundException("Show not found for this id" + showId));
        show.setIsActive(showDetails.getIsActive());
        show.setShowTime(showDetails.getShowTime());
        final Show showUpdated = showRepository.save(show);
        return ResponseEntity.ok(show);
    }

    @DeleteMapping("/deleteShow/{id}")
    public Map<String, Boolean> deleteShow(@PathVariable(value = "id") Long showId,
                                           @RequestBody Show showDetails) throws ResourceNotFoundException {
        Show show = showRepository.findById(showId).orElseThrow(() ->
                new ResourceNotFoundException("Show not found for this id" + showId));

        showRepository.delete(show);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }
}
