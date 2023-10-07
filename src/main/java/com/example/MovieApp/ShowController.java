package com.example.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Show createOrUpdateShow( @RequestBody Show show) {
        Show showReturned = showRepository.save(show);
        return showReturned;
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
