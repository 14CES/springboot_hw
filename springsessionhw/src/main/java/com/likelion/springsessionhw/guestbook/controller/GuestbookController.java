package com.likelion.springsessionhw.guestbook.controller;

import com.likelion.springsessionhw.guestbook.dto.*;
import com.likelion.springsessionhw.guestbook.service.GuestbookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guestbooks")
public class GuestbookController {
    private final GuestbookService guestbookService;

    public GuestbookController(GuestbookService guestbookService){
        this.guestbookService = guestbookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestbookDetailResponse createGuestbook(
            @Valid @RequestBody GuestbookCreateRequest request
    ){
        return guestbookService.createGuestbook(request);
    }

    @GetMapping
    public List<GuestbookSummaryResponse> getPosts() {
        return guestbookService.getGuestbookSummaries();
    }

    @GetMapping("/{guestbookId}")
    public GuestbookDetailResponse getPost(
            @PathVariable("guestbookId") Long guestbookId
    ){
        return guestbookService.getGuestbook(guestbookId);
    }

    @PutMapping("/{guestbookId}")
    public GuestbookDetailResponse updateGuestbook(
            @PathVariable("guestbookId") Long guestbookId,
            @Valid @RequestBody GuestbookUpdateRequest request
    ){
        return guestbookService.updateGuestbook(guestbookId, request);
    }

    @DeleteMapping("/{guestbookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuestbook(@PathVariable("guestbookId") Long guestbookId){
        guestbookService.deleteGuestbook(guestbookId);
    }
}
