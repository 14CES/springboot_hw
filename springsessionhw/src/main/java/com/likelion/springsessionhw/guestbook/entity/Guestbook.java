package com.likelion.springsessionhw.guestbook.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "guestbooks")
public class Guestbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false, length = 20)
    private String writer;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, length = 200)
    private String ps;


    protected Guestbook(){
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public String getWriter(){
        return writer;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public String getPs(){
        return ps;
    }
}

//-- guestbooks 테이블 구조
//CREATE TABLE guestbooks (
//        id BIGINT AUTO_INCREMENT PRIMARY KEY,
//        title VARCHAR(100) NOT NULL,          -- 제목
//content VARCHAR(500) NOT NULL,        -- 내용
//writer VARCHAR(20) NOT NULL,          -- 작성자
//created_at DATETIME NOT NULL,         -- 작성일
//ps VARCHAR(200)                       -- 추신 (P.S.)
//);