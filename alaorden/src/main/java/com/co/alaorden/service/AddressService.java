package com.co.alaorden.service;

import com.co.alaorden.model.AddressEntity;
import com.co.alaorden.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public AddressEntity create(AddressEntity address){
        return addressRepository.save(address);
    }

    public AddressEntity read (Integer id){
        return addressRepository.findById(id).get();
    }

    public AddressEntity update(AddressEntity addres, Integer id){
        AddressEntity tmpAdress = addressRepository.findById(id).get();
        tmpAdress.setAddress(addres.getAddress());
        tmpAdress.setIsTheMainAddress(addres.getIsTheMainAddress());
        tmpAdress.setLatitude(addres.getLatitude());
        tmpAdress.setLongitude(addres.getLongitude());
        tmpAdress.setName(addres.getName());
        tmpAdress.setUserId(addres.getUserId());
        return addressRepository.save(tmpAdress);
    }

    public String delete(Integer id){
        addressRepository.deleteById(id);
        return addressRepository.findById(id).get() == null ?
                "Eliminada la direccion "+ id.toString() :
                "No se elimino la direccions " + id.toString() ;
    }

}
