package com.co.alaorden.service;

import com.co.alaorden.model.ContractServicesEntity;
import com.co.alaorden.repository.ContractServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ContractServicesService {
    @Autowired
    ContractServicesRepository contractServicesRepository;

    public ContractServicesEntity create(ContractServicesEntity contract){
        return contractServicesRepository.save(contract);
    }

    public ContractServicesEntity read(Integer id){
        return contractServicesRepository.findById(id).get();
    }

    public ContractServicesEntity update(ContractServicesEntity contract, Integer id){
        ContractServicesEntity tmpContract = contractServicesRepository.findById(id).get();
        tmpContract.setContractId(contract.getContractId());
        tmpContract.setServiceId(contract.getServiceId());
        return contractServicesRepository.save(contract);
    }

    public String delete(Integer id){
        contractServicesRepository.deleteById(id);
        return contractServicesRepository.findById(id).get() == null ?
                "Eliminado el contrato de servicios "+ id.toString() :
                "No se elimino el contrato de servicios " + id.toString();
    }
}
