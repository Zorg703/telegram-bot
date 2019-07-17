package com.mordas.project.telegrambot.service;

import com.mordas.project.telegrambot.domain.City;
import com.mordas.project.telegrambot.domain.Message;
import com.mordas.project.telegrambot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message getById(Long id) {
        Optional<Message> entity = messageRepository.findById(id);

        return entity.orElseThrow(RuntimeException::new);
    }

    public List<Message> getByCityId(Long cityId) {
        List<Message> resultList = messageRepository.findByCity(new City());

        return resultList;
    }
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public void update(Message message) {
        messageRepository.save(message);
    }

    public void create(Message message) {
         messageRepository.save(message);
    }
}
