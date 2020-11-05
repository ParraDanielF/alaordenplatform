package com.co.alaorden.service;

import com.co.alaorden.model.CompanyCollaboratorsEntity;
import com.co.alaorden.repository.CompanyCollaboratorsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyCollaboratorsService {
    @Autowired
    CompanyCollaboratorsRepository companyCollaboratorsRepository;

    public CompanyCollaboratorsEntity create(CompanyCollaboratorsEntity companyCollabortor){
        return companyCollaboratorsRepository.save(companyCollabortor);
    }

    public CompanyCollaboratorsEntity read (Integer id){
        return companyCollaboratorsRepository.findById(id).get();
    }

    public CompanyCollaboratorsEntity update (CompanyCollaboratorsEntity companyCollabortor, Integer id){
        CompanyCollaboratorsEntity tmpCompanyCollabortor = companyCollaboratorsRepository.findById(id).get();
        tmpCompanyCollabortor.setCompanyId(companyCollabortor.getCompanyId());
        tmpCompanyCollabortor.setUserId(companyCollabortor.getUserId());
        return companyCollaboratorsRepository.save(tmpCompanyCollabortor);
    }

    public String delete (Integer id){
        companyCollaboratorsRepository.deleteById(id);
        return companyCollaboratorsRepository.findById(id).get() == null ?
                "Eliminada la compañia colaboradora "+ id.toString() :
                "No se elimino la compañia colaboradora " + id.toString() ;
    }
}
