package com.Book_My_Show.Controller;

import com.Book_My_Show.Requests.AddTheaterRequest;
import com.Book_My_Show.Service.TheaterService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @PostMapping("addTheater")
    public String addTheater(@RequestBody AddTheaterRequest addTheaterRequest){

        String result = theaterService.addTheater(addTheaterRequest);
        return result;
    }
    @GetMapping("addTheaterSeats")
    public String addTheaterSeats(@RequestBody AddTheaterRequest addTheaterRequest){



    }

    //Add theater Seats

}
