package com.example.demo.services.imp;

import com.example.demo.Repository.CityRepository;
import com.example.demo.models.City;
import com.example.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImp implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAll() {
        List<City> cityList = cityRepository.findAll();
//        System.out.println("imp:" + cityList.toString());
        return cityList;
    }
}
