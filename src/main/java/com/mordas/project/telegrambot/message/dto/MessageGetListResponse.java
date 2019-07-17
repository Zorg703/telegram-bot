package com.mordas.project.telegrambot.message.dto;

import java.util.ArrayList;
import java.util.List;

public class MessageGetListResponse {
    private List<MessageGetListResponse_Message> messageList = new ArrayList<>();

    public List<MessageGetListResponse_Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageGetListResponse_Message> messageList) {
        this.messageList = messageList;
    }

    public static class MessageGetListResponse_Message {
        private Long id;
        private String text;
        private MessageGetListResponse_City city;

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

        public MessageGetListResponse_City getCity() {
            return city;
        }

        public void setCity(MessageGetListResponse_City city) {
            this.city = city;
        }
    }

    public static class MessageGetListResponse_City {
        private Long id;
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
