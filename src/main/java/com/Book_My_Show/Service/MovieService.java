package com.Book_My_Show.Service;
import com.Book_My_Show.Models.Movie;
import com.Book_My_Show.Repository.MovieRepository;
import com.Book_My_Show.Requests.AddMovieRequest;
import com.Book_My_Show.Requests.UpdateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieRequest movieRequest) {

        //From my Request Entry I am creating the entity : bcz entity saves into the DB
        Movie movie = new Movie();
        movie.setMovieName(movieRequest.getMovieName());
        movie.setDuration(movieRequest.getDuration());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setRating(movieRequest.getRating());
        movie.setReleaseDate(movieRequest.getReleaseDate());
        movie = movieRepository.save(movie);
        return "The movie has been saved to the DB with movieId" + movie.getMovieId();

    }

    public String updateMovieAttributes(UpdateMovieRequest movieRequest) {
        Movie movie = movieRepository.findById(movieRequest.getMovieName()).get();

        double rating = movieRequest.getRating();
        double duration = movieRequest.getDuration();

        movie.setDuration(duration);
        movie.setRating(rating);

        movieRepository.save(movie);
        return "Attributes are modified";

    }
}