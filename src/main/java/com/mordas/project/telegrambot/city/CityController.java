package com.mordas.project.telegrambot.city;

import com.mordas.project.telegrambot.city.dto.CityGetResponse;
import com.mordas.project.telegrambot.city.dto.CityPostRequest;
import com.mordas.project.telegrambot.city.dto.CityPutRequest;
import com.mordas.project.telegrambot.domain.City;
import com.mordas.project.telegrambot.service.CityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CityGetResponse gеtCityById(String id){
        CityGetResponse result = new CityGetResponse();

        return result;
    }

    @GetMapping
    public List<CityGetResponse> getAllCities(){
        List<CityGetResponse> result = new ArrayList<>();

        List<City> cityList = cityService.getAll();

        cityList.forEach(city -> {
            CityGetResponse entity = new CityGetResponse();

            entity.setId(city.getId());


        });

        return result;
    }

    @PutMapping
    public void update(CityPostRequest request){

    }

    @PostMapping
    public void create(CityPostRequest request){
        City city = new City();

        city.setName(request.getName());
        cityService.create(city);
    }

    @DeleteMapping
    public void delete(String id){

    }
}
