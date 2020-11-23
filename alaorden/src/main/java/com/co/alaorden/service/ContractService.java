package com.co.alaorden.service;

import com.co.alaorden.model.ContractEntity;
import com.co.alaorden.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractService {
    @Autowired
    ContractRepository contractRepository;

    public ContractEntity create(ContractEntity contract){
        return contractRepository.save(contract);
    }

    public ContractEntity read(Integer id){
        return contractRepository.findById(id).get();
    }

    public ContractEntity update(ContractEntity contract, Integer id){
        ContractEntity tmpContract = contractRepository.findById(id).get();
        tmpContract.setCompanyId(contract.getCompanyId());
        tmpContract.setContractDate(contract.getContractDate());
        tmpContract.setPaymentTypeId(contract.getPaymentTypeId());
        tmpContract.setUserId(contract.getUserId());
        return contractRepository.save(tmpContract);
    }

    public String delete(Integer id){
        contractRepository.deleteById(id);
        return contractRepository.findById(id).get() == null ?
                "Eliminado el contrato "+ id.toString() :
                "No se elimino el contrato " + id.toString() ;
    }
}
