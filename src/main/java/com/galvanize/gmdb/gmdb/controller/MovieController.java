package com.galvanize.gmdb.gmdb.controller;

import com.galvanize.gmdb.gmdb.entity.Movie;
import com.galvanize.gmdb.gmdb.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping("/ping")
    public String ping() {
        return "There is Movie controller";
    }

   @GetMapping("/getMovies")
   public Iterable<Movie> getMovies() {
       return this.movieRepository.findAll();
   }

    @PostMapping ("/createMovie")
    public void create(@RequestBody Movie movie) {
        this.movieRepository.save(movie);
    }


    @PutMapping("/updateMovie")
    public Movie update(@RequestBody Movie movie){
        return this.movieRepository.save(movie);
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public void delete(@PathVariable("movieId") Long movieId){
        this.movieRepository.deleteById(movieId);
    }

}
