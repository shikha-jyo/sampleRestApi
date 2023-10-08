package com.example.MovieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class MovieAppApplication implements CommandLineRunner {

	@Autowired
	TheatreRepository theatreRepository;

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	ShowRepository showRepository;

	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);
	}

@Override
	public void run(String... args) throws Exception {


	Movie movie1 = Movie.builder()
			.movieName("Fukrey")
			.duration("2h39min")
			.genre("Action")
			.releaseDate(Calendar.getInstance().getTime())
			.language("HINDI")
			.build();
	Map movieList = new HashMap<Movie, List<Show>>();
	List showList = new ArrayList<Show>();
	movieList.put(movie1, showList);

	movieRepository.save(movie1);
	Theatre theatre = Theatre.builder().theatreName("Forum").addressId(1234).build();

	theatreRepository.save(theatre);

	Theatre theatre2 = Theatre.builder().theatreName("Cinepolis").addressId(1234).build();

	theatreRepository.save(theatre2);
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = dateFormat.parse("2023-10-07");


	Show show = Show.builder().movieId(movie1.getMovieId()).showTime(Calendar.getInstance().getTime().getTime())

			.theatreId(theatre.getTheatreId()).showDate(date).isActive(true).
			build();
	Show show2 = Show.builder().movieId(movie1.getMovieId()).showTime(Calendar.getInstance().getTime().getTime())
			.theatreId(theatre2.getTheatreId()).showDate(date).isActive(false).
			build();
try {
	showRepository.save(show);
	showRepository.save(show2);
}catch(Exception e){
	e.printStackTrace();
}
	List<ShowDto> map = showRepository.queryByMovieId(movie1.getMovieId(),date);
	Map<String,List<ShowDto>> result = map.stream().collect(Collectors.groupingBy(s -> s.getTheatreName()));
	result.entrySet().stream().forEach(e ->System.out.println(e.getKey() + ":" + e.getValue().toString()));
}

}
