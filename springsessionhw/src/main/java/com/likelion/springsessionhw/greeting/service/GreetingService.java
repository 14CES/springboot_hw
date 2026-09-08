package com.likelion.springsessionhw.greeting.service;

import com.likelion.springsessionhw.greeting.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    private final MessageRepository messageRepository;

    public  GreetingService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public String greet(String name, int hour){
        String greeting;
        if (hour <= 5) {
            greeting = "아직 안 주무셨어요?";
        } else if (hour < 12) {
            greeting = "좋은 아침이예요";
        } else if (hour < 18) {
            greeting = "좋은 오후예요";
        } else {
            greeting = "좋은 저녁이예요";
        }

        String result = greeting + ", " + name + "님 !";
        Integer check = 1;
        messageRepository.save(result);
        messageRepository.messagecount(check);

        return result;
    }

    public List<String> getAllmessages(){
        return messageRepository.findAll();
    }

    public Integer getAllcounts(){
        return messageRepository.findCount();
    }
}
