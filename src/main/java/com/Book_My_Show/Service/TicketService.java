package com.Book_My_Show.Service;

import com.Book_My_Show.Enums.Language;
import com.Book_My_Show.Exceptions.SeatUnavailableException;
import com.Book_My_Show.Models.*;
import com.Book_My_Show.Repository.*;
import com.Book_My_Show.Requests.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket bookTicket(BookTicketRequest bookTicketRequest) throws Exception {

        //1. Calculate the total cost of then tickets

        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
        Theater theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();

        //1.1 Find the showEEntity with this date and time
        Show show = showRepository.findByShowDateAndShowTimeAndMovieAndTheater(bookTicketRequest.getShowDate(),bookTicketRequest.getShowTime(), movie, theater);

        Integer showId = show.getShowId();
        List<ShowSeat> showSeatList = showSeatRepository.findShowSeats(showId);

        //Calculate the total Amt and if all seats mentioned are available or not
        int totalAmount = 0;
        Boolean areAllSeatsAvailable = Boolean.TRUE;

        for(String seatNo:bookTicketRequest.getRequestedSeats()){
            for(ShowSeat showSeat:showSeatList){
                if(showSeat.getSeatNo().equals(seatNo))
                {
                    if(showSeat.getIsAvailable()==Boolean.FALSE){
                        areAllSeatsAvailable = Boolean.FALSE;
                        break;
                    }
                    totalAmount = totalAmount+showSeat.getPrice();
                }
            }
        }
        if(areAllSeatsAvailable==Boolean.FALSE){
            throw new SeatUnavailableException("The requested seats are unavaiable");
        }
        //2. Make the seats booked : (Only if seats are available : otherwise throw exceptions)

        for(String seatNo:bookTicketRequest.getRequestedSeats()){
            for(ShowSeat showSeat:showSeatList){
                if(showSeat.getSeatNo().equals(seatNo))
                {
                    showSeat.setIsAvailable(Boolean.FALSE);
                }
            }
        }
        User user = userRepository.findUserByMobileNo(bookTicketRequest.getMobNo());

        //3. Save the ticketEntity
        Ticket ticket = Ticket.builder().user(user)
                .movieName(bookTicketRequest.getMovieName())
                .showDate(bookTicketRequest.getShowDate())
                .theaterNameAndAddress(theater.getName()+" "+theater.getAddress())
                .showTime(bookTicketRequest.getShowTime())
                .totalAmtPaid(totalAmount)
                .build();

        ticket = ticketRepository.save(ticket);

        //4. Generate and return back the actual ticket response

        return ticket;
    }
}
