package com.likelion.springsessionhw.guestbook.controller;

import com.likelion.springsessionhw.guestbook.dto.GuestbookSummaryResponse;
import com.likelion.springsessionhw.guestbook.entity.Guestbook;
import com.likelion.springsessionhw.guestbook.repository.GuestbookRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestbookController {
    private final GuestbookRepository guestbookRepository;

    public GuestbookController(GuestbookRepository guestbookRepository){
        this.guestbookRepository = guestbookRepository;
    }

    @GetMapping("/api/guestbooks")
    public List<GuestbookSummaryResponse> getGuestbooks(){
        List<Guestbook> guestbooks = guestbookRepository.findAll();
        List<GuestbookSummaryResponse> responses = new ArrayList<>();

        for (Guestbook guestbook : guestbooks){
            GuestbookSummaryResponse response = new GuestbookSummaryResponse(
                    guestbook.getTitle(),
                    guestbook.getWriter(),
                    guestbook.getPs()
            );
            responses.add(response);
        }


        return responses;
    }
}
