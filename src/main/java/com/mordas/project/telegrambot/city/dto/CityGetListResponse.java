package com.mordas.project.telegrambot.city.dto;

import java.util.ArrayList;
import java.util.List;

public class CityGetListResponse {
    List<CityGetListResponse_City> cityList = new ArrayList<>();

    public List<CityGetListResponse_City> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityGetListResponse_City> cityList) {
        this.cityList = cityList;
    }

    public static class CityGetListResponse_City {
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
