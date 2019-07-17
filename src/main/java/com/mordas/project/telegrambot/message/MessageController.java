package com.mordas.project.telegrambot.message;

import com.mordas.project.telegrambot.domain.City;
import com.mordas.project.telegrambot.domain.Message;
import com.mordas.project.telegrambot.message.dto.*;
import com.mordas.project.telegrambot.service.CityService;
import com.mordas.project.telegrambot.service.MessageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(MessageController.API_ADDRESS)
@Api(tags = "messages")
public class MessageController {
    public static final String API_ADDRESS = "api/message";
    @Autowired
    private MessageService messageService;
    @Autowired
    private CityService cityService;

    @GetMapping(path = "/{id}")
    public MessageGetResponse get(Long id) {
        MessageGetResponse result = new MessageGetResponse();
        Message message = messageService.getById(id);
        result.setId(message.getId());
        result.setText(message.getText());

        City city = message.getCity();

        var resultCity = new MessageGetResponse.MessageGetResponse_City();
        resultCity.setId(city.getId());
        resultCity.setName(resultCity.getName());

        result.setCity(resultCity);

        return result;
    }

    @GetMapping(path = "/city")
    public ResponseEntity<MessageGetByCityNameListResponse> getByCityName(String cityName) {
        MessageGetByCityNameListResponse result = new MessageGetByCityNameListResponse();

        List<Message> messageList = messageService.getByCityName(cityName);
        messageList.forEach(message -> {
                    var entity = new MessageGetByCityNameListResponse.MessageGetByCityNameListResponse_Message();
                    entity.setId(message.getId());
                    entity.setText(message.getText());

                    if (result.getCityName() == null) {
                        result.setCityName(message.getCity().getName());
                    }

                    result.getMessageList().add(entity);
                }
        );

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<MessageGetListResponse> getAll() {
        MessageGetListResponse result = new MessageGetListResponse();

        List<Message> messageList = messageService.getAll();
        messageList.forEach(message -> {
                    var entity = new MessageGetListResponse.MessageGetListResponse_Message();
                    entity.setId(message.getId());
                    entity.setText(message.getText());

                    City city = message.getCity();
                    var cityResult = new MessageGetListResponse.MessageGetListResponse_City();
                    cityResult.setId(city.getId());
                    cityResult.setName(city.getName());

                    entity.setCity(cityResult);

                    result.getMessageList().add(entity);
                }
        );
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(MessagePutRequest request) {
        Message message = new Message();
        message.setText(request.getText());
        message.setId(request.getId());

        City city = new City();
        city.setName(request.getCity().getName());
        city.setId(request.getCity().getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(MessagePostRequest request) {
        Message message = new Message();
        message.setText(request.getText());

        City city = new City();
        city.setName(request.getCity().getName());
        city.setId(request.getCity().getId());

        messageService.update(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
