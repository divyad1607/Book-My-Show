package com.Book_My_Show.Controller;


import com.Book_My_Show.Requests.AddShowRequest;
import com.Book_My_Show.Requests.AddShowSeatRequest;
import com.Book_My_Show.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showServie;

    @PostMapping("addShow")
    private String addShow(@RequestBody AddShowRequest  showRequest) {

        String result = showServie.addShow(showRequest);
        return result;
    }

    @PostMapping("addShowSeats")
    public String addShowSeats(@RequestBody AddShowSeatRequest showSeatRequest) {

         String response = showServie.addShowSeats(showSeatRequest);
         return response;
    }
}
