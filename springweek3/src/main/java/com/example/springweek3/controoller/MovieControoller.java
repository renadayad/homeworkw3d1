package com.example.springweek3.controoller;


import com.example.springweek3.model.Movie;
import com.example.springweek3.servise.MovieServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieControoller {

    private final MovieServise movieServise;

    @GetMapping
    public ResponseEntity getMovie(){
        return ResponseEntity.status(200).body(movieServise.getMovie());
    }

    @PostMapping
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());}
        movieServise.addMovie(movie);
        return ResponseEntity.status(200).body("Movie added!");

    }
    @PutMapping("/{id}")
    public ResponseEntity updateMovie(@RequestBody @Valid Movie movie, @PathVariable Integer id,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());}
        movieServise.updateMovie(movie,id);
        return ResponseEntity.status(200).body("Update Movie !");

    }
    @DeleteMapping
    public ResponseEntity deletMovie(@PathVariable Integer id){
movieServise.removeMovie(id);
        return ResponseEntity.status(200).body("delet Movie");
    }

}
