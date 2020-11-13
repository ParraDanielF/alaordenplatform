package com.co.alaorden.service;

import com.co.alaorden.model.RecoveryDataEntity;
import com.co.alaorden.repository.RecoveryDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RecoveryDataService {
    @Autowired
    RecoveryDataRepository recoveryDataRepository;

    public RecoveryDataEntity create (RecoveryDataEntity recoveryData){
        return recoveryDataRepository.save(recoveryData);
    }

    public RecoveryDataEntity read (Integer id){
        return recoveryDataRepository.findById(id).get();
    }

    public RecoveryDataEntity update (RecoveryDataEntity recoveryData, Integer id) {
        RecoveryDataEntity tmpRecoveryData = recoveryDataRepository.findById(id).get();
        tmpRecoveryData.setAccountId(recoveryData.getAccountId());
        tmpRecoveryData.setExpiredAt(recoveryData.getExpiredAt());
        tmpRecoveryData.setRecoveryToken(recoveryData.getRecoveryToken());
        return recoveryDataRepository.save(tmpRecoveryData);
    }

    public String delete (Integer id){
        recoveryDataRepository.deleteById(id);
        return recoveryDataRepository.findById(id).get() == null ?
                "Eliminada la informacion "+ id.toString() :
                "No se elimino la informacio " + id.toString() ;
    }
}
