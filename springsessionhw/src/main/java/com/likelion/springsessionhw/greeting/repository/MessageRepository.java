package com.likelion.springsessionhw.greeting.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    private final List<String> messages = new ArrayList<>();
    private Integer counts = 0;

    public void save(String message){
        messages.add(message);
    }

    public void messagecount(Integer count){
        counts += count;
    }

    public List<String> findAll(){
        return messages;
    }

    public Integer findCount(){
        return counts;
    }
}
