package com.example.MovieApp.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "MOVIE")
public class Movie {

    public Movie(){}
    public Movie(String movieTitle, String movieGenre, int movieYear, int movieLength) {
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieYear = movieYear;
        this.movieLength = movieLength;
    }

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "movieTitle")
    private String movieTitle;

    @Column(name = "movieGenre")
    private String movieGenre;

    @Column(name = "movieYear")
    private int movieYear;

    @Column(name = "movieLength")
    private int movieLength;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMovieTitle() {
        return this.movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return this.movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieYear() {
        return this.movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public int getMovieLength() {
        return this.movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + Id +
                ", Title='" + movieTitle + '\'' +
                ", Genre='" + movieGenre + '\'' +
                ", Year='" + movieYear + '\'' +
                ", Length='" + movieLength +
                '}';
    }
}
