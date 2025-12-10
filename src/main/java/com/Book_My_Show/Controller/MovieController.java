package com.Book_My_Show.Controller;

import com.Book_My_Show.Models.Movie;
import com.Book_My_Show.Service.MovieService;
import com.Book_My_Show.UpdateMovieRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public String addMovie(@RequestBody Movie movie){

        String response = movieService.addMovie(movie);
        return response;
    }

    @PutMapping("/updateMovie")
    public String updateMovieAttribute(@RequestParam("movieId")Integer movieId,
                                       @RequestParam("duration")double duration,
                                       @RequestParam("rating")double rating{


    }

    @PutMapping("/updateMovieAttributes")
    public String updateMovieAttributes(@RequestBody UpdateMovieRequest movieRequest){\
              //You have made sure that relevant attributes
             //are expose to the client

        String result = movieService.updateMovieAttributes(movieRequest);
        return result;
    }

}
