package com.co.alaorden.service;

import com.co.alaorden.model.CityEntity;
import com.co.alaorden.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CityServices {
    @Autowired
    CityRepository cityRepository;

    public CityEntity create(CityEntity city){
        return cityRepository.save(city);
    }

    public CityEntity read(Integer id){
        return cityRepository.findById(id).get();
    }

    public CityEntity update(CityEntity city , Integer id){
        CityEntity tmpCity = cityRepository.findById(id).get();
        tmpCity.setName(city.getName());
        return cityRepository.save(tmpCity);
    }

    public String delete(Integer id){
        cityRepository.deleteById(id);
        return cityRepository.findById(id).get() == null ?
                "Eliminada la ciudad "+ id.toString() :
                "No se elimino la ciudad " + id.toString() ;
    }
}
