package com.example.springweek3.servise;

import com.example.springweek3.model.Movie;
import com.example.springweek3.repoistory.MovieRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServise {
    private final MovieRepoistory movieRepoistory;
    public List<Movie> getMovie() {
        return movieRepoistory.findAll();
    }

    public void addMovie(Movie movie) {

        movieRepoistory.save(movie);
    }

    public void updateMovie(Movie movie, Integer id) {
        Movie oldovie=movieRepoistory.findById(id).get();
        oldovie.setId(movie.getId());
        oldovie.setName(movie.getName());
        oldovie.setDuration(movie.getDuration());
        oldovie.setGenre(movie.getGenre());
        oldovie.setRating(movie.getRating());
        oldovie.setLaunchDate(movie.getLaunchDate());
       movieRepoistory.save(oldovie);
    }

    public void removeMovie(Integer id) {

        movieRepoistory.deleteById(id);
    }
}
