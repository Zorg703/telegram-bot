package com.mordas.project.telegrambot.repository;

import com.mordas.project.telegrambot.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAll();

    Optional<City> findById(Long id);

    void deleteById(Long id);
}
