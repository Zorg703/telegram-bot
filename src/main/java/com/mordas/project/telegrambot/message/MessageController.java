package com.mordas.project.telegrambot.message;

import com.mordas.project.telegrambot.message.dto.MessageGetResponse;
import com.mordas.project.telegrambot.message.dto.MessagePostRequest;
import com.mordas.project.telegrambot.message.dto.MessagePutRequest;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(MessageController.API_ADDRESS)
@Api(tags = "messages")
public class MessageController {
    public static final String API_ADDRESS = "api/message";

    @GetMapping(path = "/{id}")
    public MessageGetResponse get(String id) {
        MessageGetResponse result = new MessageGetResponse();

        return result;
    }

    @GetMapping
    public List<MessageGetResponse> getAll() {
        List<MessageGetResponse> result = new ArrayList<>();

        return result;
    }

    @PutMapping
    public void update (MessagePostRequest request) {

    }

    @PostMapping
    public String create(MessagePutRequest request) {
        return null;
    }
}
