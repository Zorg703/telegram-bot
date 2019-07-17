package com.mordas.project.telegrambot.bot;

import com.mordas.project.telegrambot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BotService {
    MessageRepository messageRepository;

    public String getMessage(String key){
        return "aaaa";
    }
}
