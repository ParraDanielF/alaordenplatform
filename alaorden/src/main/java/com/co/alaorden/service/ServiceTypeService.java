package com.co.alaorden.service;

import com.co.alaorden.model.ServiceTypeEntity;
import com.co.alaorden.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    public ServiceTypeEntity create (ServiceTypeEntity serviceType){
        return serviceTypeRepository.save(serviceType);
    }

    public ServiceTypeEntity find (Integer id){
        return serviceTypeRepository.findById(id).get();
    }

    public ServiceTypeEntity update (ServiceTypeEntity serviceType, Integer id){
        ServiceTypeEntity tmpServiceType = serviceTypeRepository.findById(id).get();
        tmpServiceType.setDescription(serviceType.getDescription());
        tmpServiceType.setName(serviceType.getName());
        return serviceTypeRepository.save(tmpServiceType);
    }

    public String delete (Integer id){
        serviceTypeRepository.deleteById(id);
        return serviceTypeRepository.findById(id).get() == null ?
                "Eliminada el tipo de servicio "+ id.toString() :
                "No se elimino el tipo de servicio " + id.toString() ;
    }
}
