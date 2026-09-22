package com.likelion.springsessionhw.guestbook.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(length = 200)
    private String ps;

    public Guestbook(String title, String content, String writer, LocalDateTime createdAt, String ps){
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.ps = ps;
    }

    public void update(String title, String content, String writer, String ps){
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.ps = ps;
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