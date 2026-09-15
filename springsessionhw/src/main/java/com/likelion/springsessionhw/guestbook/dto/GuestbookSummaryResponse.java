package com.likelion.springsessionhw.guestbook.dto;

import java.time.LocalDateTime;

public class GuestbookSummaryResponse {

    private final String title;
    private final String writer;
    private final String ps;

    public GuestbookSummaryResponse(
            String title,
            String writer,
            String ps
    ){
        this.title = title;
        this.writer = writer;
        this.ps = ps;
    }

    public String getTitle(){
        return title;
    }

    public String getWriter(){
        return writer;
    }

    public String getPs(){
        return ps;
    }
}

//제목 작성자 추신