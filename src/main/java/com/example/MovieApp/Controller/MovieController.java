package com.example.MovieApp.Controller;

import com.example.MovieApp.Entity.Movie;
import com.example.MovieApp.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8090")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(value= "/ping", method = RequestMethod.GET)
    @ResponseBody
    public String healthCheck() {
        return "This works";
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @RequestMapping(value="/movie", method = RequestMethod.POST)
    @ResponseBody
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @RequestMapping(value="/findmovie", method = RequestMethod.GET)
    @ResponseBody
    public Movie findMovie(@RequestParam("movieId") int movieId) {
        return movieRepository.findById(movieId);
    }

    @RequestMapping(value= "/updatemovie", method = RequestMethod.PUT)
    @ResponseBody
    public Movie updateMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    @RequestMapping(value="/deletemovie", method = RequestMethod.GET)
    @ResponseBody
    public void deleteMovie(@RequestParam("movieId") int movieId) {
        movieRepository.deleteById(movieId);
    }

}
