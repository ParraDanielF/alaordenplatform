package com.co.alaorden.service;

import com.co.alaorden.model.CountryEntity;
import com.co.alaorden.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServices {
    @Autowired
    CountryRepository countryRepository;

    public CountryEntity create(CountryEntity country){
        return countryRepository.save(country);
    }

    public CountryEntity read(Integer id){
        return countryRepository.findById(id).get();
    }

    public CountryEntity update(CountryEntity country, Integer id){
        CountryEntity tmpCountry = countryRepository.findById(id).get();
        tmpCountry.setName(country.getName());
        return countryRepository.save(tmpCountry);
    }

    public String delete(Integer id){
        countryRepository.deleteById(id);
        return countryRepository.findById(id).get() == null ?
                "Eliminado el pais "+ id.toString() :
                "No se elimino el pais " + id.toString();
    }

}
