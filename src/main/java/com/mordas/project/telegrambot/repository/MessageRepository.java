package com.mordas.project.telegrambot.repository;

import com.mordas.project.telegrambot.domain.City;
import com.mordas.project.telegrambot.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAll();

    List<Message> findByCity(City city);

    Optional<Message> findById(Long id);

    void deleteById(Long id);

}
