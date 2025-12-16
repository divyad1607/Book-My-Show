package com.Book_My_Show.Controller;

import com.Book_My_Show.Models.Ticket;
import com.Book_My_Show.Models.User;
import com.Book_My_Show.Requests.BookTicketRequest;
import com.Book_My_Show.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;   // ✅ CORRECT
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity<?> bookTicket(
            @RequestBody BookTicketRequest bookTicketRequest
    ) {
        try {
            Ticket ticket = ticketService.bookTicket(bookTicketRequest);
            return ResponseEntity.ok(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cancel/{ticketId}")
    public ResponseEntity<String> cancelTicket(
            @PathVariable String ticketId,
            Authentication authentication
    ) {
        // JWT subject = email
        String email = authentication.getName();

        String response = ticketService.cancelTicket(ticketId, email);
        return ResponseEntity.ok(response);
    }

}
