package com.co.alaorden.service;

import com.co.alaorden.model.ServiceEntity;
import com.co.alaorden.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ALaOrdenServices {

    @Autowired
    ServiceRepository serviceRepository;

    public Optional<ServiceEntity> getService(Integer id){
        return serviceRepository.findById(id);
    }
}
