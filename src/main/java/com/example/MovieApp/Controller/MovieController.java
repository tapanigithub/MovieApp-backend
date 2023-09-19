package com.example.MovieApp.Controller;

import com.example.MovieApp.Entity.Movie;
import com.example.MovieApp.Repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("/")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/ping")
    public String healthCheck() {
        return "This works";
    }

    @GetMapping("/movies")
    List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/movie/{id}")
    ResponseEntity<?> getMovie(@PathVariable("id") Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/movie")
    ResponseEntity<Movie> addMovie(@RequestBody Movie movie) throws URISyntaxException {
        Movie result = movieRepository.save(movie);
        return ResponseEntity.created(new URI("/api/movie/" + movie.getId()))
                .body(result);
    }

    @PutMapping("/movie/{id}")
    ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        Movie result = movieRepository.save(movie);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {
        movieRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
