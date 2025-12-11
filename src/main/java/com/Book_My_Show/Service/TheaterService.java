package com.Book_My_Show.Service;

import com.Book_My_Show.Enums.SeatType;
import com.Book_My_Show.Models.Theater;
import com.Book_My_Show.Models.TheaterSeat;
import com.Book_My_Show.Repository.TheaterRepository;
import com.Book_My_Show.Repository.TheaterSeatRepository;
import com.Book_My_Show.Requests.AddTheaterRequest;
import com.Book_My_Show.Requests.AddTheaterSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatRepository theaterSeatRepository;

    public String addTheater(AddTheaterRequest addTheaterRequest){

        //Convert this AddRequest to an Entity
        //how to do this ??

        //Use a constructor to create a object : Generally constructors are not available

//        Theater theater = new Theater();//We have this entity object
//        theater.setName(addTheaterRequest.getName());
//        theater.setAddress(addTheaterRequest.getAddress());
//        theater.setOnOfScreens(addTheaterRequest.getNoOfScreens());


        //Modern way of creating the object is
        Theater theater = Theater.builder().address(addTheaterRequest.getAddress())
                .onOfScreens(addTheaterRequest.getNoOfScreens())
                .name(addTheaterRequest.getName())
                .build();


        //Save the entity to the DB

        theater = theaterRepository.save(theater);
        return "The theater is with theaterId"+theater.getTheaterId();

    }

    public String addTheaterSeats(AddTheaterSeatRequest addTheaterSeatRequest){

        int noOfClassicSeats = addTheaterSeatRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterSeatRequest.getNoOfPremiumSeats();

        Integer theaterId = addTheaterSeatRequest.getTheaterId();
        Theater theater = theaterRepository.findById(theaterId).get();

        int classicSeatCountor = 1;
        char ch = 'A';
        int rowNo = 1;

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        while (classicSeatCountor<=noOfClassicSeats){

            String seatNo = rowNo+ "" +ch;
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
            ch++;


            if(classicSeatCountor % 5 == 0){
                rowNo = rowNo+1;
                ch = 'A';
            }
            classicSeatCountor++;
        }

        int premiumSeatCountor = 1;
        ch='A';

        if(classicSeatCountor%5!=1)
        rowNo = rowNo+1;

        while (premiumSeatCountor<=noOfPremiumSeats){

            String seatNo = rowNo+ "" +ch;
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
            ch++;

            if(premiumSeatCountor % 5 == 0){
                rowNo = rowNo+1;
                ch = 'A';
            }
            premiumSeatCountor++;
        }

        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);

        theaterSeatRepository.saveAll(theaterSeatList);

        //Theater seats will get automatically saved
        //bcz of cascading property written in the parent table
        return "Theater seats have been generated";
    }
}
