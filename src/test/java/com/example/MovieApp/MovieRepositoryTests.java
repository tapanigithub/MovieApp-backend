package com.example.MovieApp;

import com.example.MovieApp.Entity.Movie;
import com.example.MovieApp.Repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieRepositoryTests {

    @Autowired
    private MovieRepository repo;

    @Test
    @Rollback(value = false)
    public void testCreateMovie() {
        Movie savedmovie1 = repo.save(new Movie("Training day", "Action", 2001, 150));
        Movie savedmovie2 = repo.save(new Movie("Marvel movie", "Fantasy", 2020, 150));
        assertThat(savedmovie2.getId()).isGreaterThan(1);
    }


    @Test
    public void testListMovies() {
        List<Movie> movies = repo.findAll();
        assertThat(movies).size().isGreaterThan(1);
    }
}

