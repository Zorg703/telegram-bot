package com.mordas.project.telegrambot.service;

import com.mordas.project.telegrambot.domain.City;
import com.mordas.project.telegrambot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City getById(Long id) {
        Optional<City> entity = cityRepository.findById(id);

        return entity.orElseThrow(EntityNotFoundException::new);
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public void update(City city) {
        cityRepository.save(city);
    }

    public void create(City city) {
        cityRepository.save(city);
    }
}
