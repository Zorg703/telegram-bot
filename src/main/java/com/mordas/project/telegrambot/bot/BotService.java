package com.mordas.project.telegrambot.bot;

import com.mordas.project.telegrambot.domain.City;
import com.mordas.project.telegrambot.domain.Message;
import com.mordas.project.telegrambot.repository.CityRepository;
import com.mordas.project.telegrambot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BotService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private CityRepository cityRepository;

    public String getMessage(String key) {
        Optional<City> cityOptional = cityRepository.findByName(key);

        String result = null;

        if (cityOptional.isPresent()) {
            List<Message> messageList = messageRepository.findByCity(cityOptional.get());

            if (!messageList.isEmpty()) {
                result = messageList.stream().map(Message::getText).collect(Collectors.joining("\\n"));
            }
        }

        if (result == null) {
            return "К сожалению, я не могу Вам ни чего достойного порекомендовать к посещению в городе: " + key;
        }

        return result;
    }
}
