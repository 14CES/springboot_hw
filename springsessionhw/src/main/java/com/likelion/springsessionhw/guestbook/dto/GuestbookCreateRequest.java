package com.likelion.springsessionhw.guestbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class GuestbookCreateRequest {

    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 100, message = "제목은 100자 이하로 작성해주세요.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    @Size(max = 500, message = "내용은 500자 이하로 작성해주세요.")
    private String content;

    @NotBlank(message = "작성자 필수입니다.")
    @Size(max = 20, message = "작성자는 20자 이하로 작성해주세요.")
    private String writer;

    @Size(max = 200, message = "추신은 200자 이하로 작성해주세요.")
    private String ps;
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