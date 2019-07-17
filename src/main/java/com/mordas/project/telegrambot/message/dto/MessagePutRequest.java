package com.mordas.project.telegrambot.message.dto;

public class MessagePutRequest extends MessagePostRequest{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
