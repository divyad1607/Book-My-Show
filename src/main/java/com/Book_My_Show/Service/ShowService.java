package com.Book_My_Show.Service;

import com.Book_My_Show.Enums.SeatType;
import com.Book_My_Show.Models.*;
import com.Book_My_Show.Repository.MovieRepository;
import com.Book_My_Show.Repository.ShowRepository;
import com.Book_My_Show.Repository.ShowSeatRepository;
import com.Book_My_Show.Repository.TheaterRepository;
import com.Book_My_Show.Requests.AddShowRequest;
import com.Book_My_Show.Requests.AddShowSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public String addShow(AddShowRequest showRequest){

        //Build an object of the Show Entity and save it to the DB

        //I need to get the movie Entity and Theater Entity : create the Show Entity

        Movie movie = movieRepository.findMovie(showRequest.getMovieName());

        Theater theater = theaterRepository.findById(showRequest.getTheaterId()).get();

        Show show = Show.builder()
                .showDate(showRequest.getShowDate())
                .showTime(showRequest.getShowTime())
                .movie(movie)
                .theater(theater)
                .build();

        showRepository.save(show);

        return "The show has been saved to the DB with showId"+show;
    }

    public String addShowSeats(AddShowSeatRequest showSeatRequest){

        Integer showId = showSeatRequest.getShowId();
        Show show = showRepository.findById(showId).get();

        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        //Your goal is generation of show List

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheaterSeat theaterSeat:theaterSeatList) {
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .isAvailable(Boolean.TRUE)
                    .show(show)
                    .build();

            if (theaterSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setPrice(showSeatRequest.getPriceOfClassicSeats());
            } else
                showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeats());

            showSeatList.add(showSeat);
        }
            showSeatRepository.saveAll(showSeatList);

        return "Show seats have been generated for the given showId";

    }
}
