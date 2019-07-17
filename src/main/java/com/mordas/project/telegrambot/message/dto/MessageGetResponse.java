package com.mordas.project.telegrambot.message.dto;

public class MessageGetResponse {
    private Long id;
    private String text;
    private MessageGetResponse_City city;

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

    public MessageGetResponse_City getCity() {
        return city;
    }

    public void setCity(MessageGetResponse_City city) {
        this.city = city;
    }

    public static class MessageGetResponse_City{
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
