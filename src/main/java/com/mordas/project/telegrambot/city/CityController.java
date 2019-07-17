package com.mordas.project.telegrambot.city;

import com.mordas.project.telegrambot.city.dto.CityGetListResponse;
import com.mordas.project.telegrambot.city.dto.CityGetResponse;
import com.mordas.project.telegrambot.city.dto.CityPostRequest;
import com.mordas.project.telegrambot.city.dto.CityPutRequest;
import com.mordas.project.telegrambot.domain.City;
import com.mordas.project.telegrambot.service.CityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(CityController.API_ADDRESS)
@Api(tags = "cities")
public class CityController {
    public static final String API_ADDRESS = "api/city";

    @Autowired
    private CityService cityService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<CityGetResponse> gеtCityById(Long id) {
        CityGetResponse result = new CityGetResponse();
        City city = cityService.getById(id);
        if (city != null) {
            result.setId(city.getId());
            result.setName(city.getName());

            return new ResponseEntity<>(result, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<CityGetListResponse> getAllCities(){
        CityGetListResponse result = new CityGetListResponse();

        List<City> cityList = cityService.getAll();

        cityList.forEach(city -> {
            var entity = new CityGetListResponse.CityGetListResponse_City();

            entity.setId(city.getId());
            entity.setName(city.getName());

            result.getCityList().add(entity);
        });

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(CityPostRequest request){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(CityPostRequest request){
        City city = new City();

        city.setName(request.getName());
        cityService.create(city);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(String id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
