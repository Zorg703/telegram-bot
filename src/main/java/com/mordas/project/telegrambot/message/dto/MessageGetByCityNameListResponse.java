package com.mordas.project.telegrambot.message.dto;

import java.util.ArrayList;
import java.util.List;

public class MessageGetByCityNameListResponse {
    private String cityName;

    private List<MessageGetByCityNameListResponse_Message> messageList = new ArrayList<>();

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<MessageGetByCityNameListResponse_Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageGetByCityNameListResponse_Message> messageList) {
        this.messageList = messageList;
    }

    public static class MessageGetByCityNameListResponse_Message {
        private Long id;
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
