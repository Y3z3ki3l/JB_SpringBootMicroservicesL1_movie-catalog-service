package io.javabrains.franniel.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.franniel.moviecatalogservice.models.CatalogItem;
import io.javabrains.franniel.moviecatalogservice.models.Movie;
import io.javabrains.franniel.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject("http://localhost:8082/movies/foo", Movie.class);
		
		// Get all rated movie IDs
		// TODO: remove hard coding
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 3),
				new Rating("1092", 5)
		);
		
		// For each movie ID, call movie info service and get details
		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			// new CatalogItem("Matrix Reloaded", "The best movie ever!", 5);
			return new CatalogItem(movie.getName(), "The best movie ever!", rating.getRating());
		}).collect(Collectors.toList());
		
		// Put them all together		
		
		
//		return Collections.singletonList(
//				new CatalogItem("Matrix Reloaded", "The best movie ever!", 5)
//		);
		
	}

}
