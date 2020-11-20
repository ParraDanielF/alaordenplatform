package com.co.alaorden.service;

import com.co.alaorden.model.CompanyEntity;
import com.co.alaorden.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public CompanyEntity create (CompanyEntity company){
        return companyRepository.save(company);
    }

    public CompanyEntity read(Integer id){
        return companyRepository.findById(id).get();
    }

    public CompanyEntity update(CompanyEntity company, Integer id){
        CompanyEntity tmpCompany = companyRepository.findById(id).get();
        tmpCompany.setAddress(company.getAddress());
        tmpCompany.setCity(company.getCity());
        tmpCompany.setCountry(company.getCountry());
        tmpCompany.setIsActive(company.getIsActive());
        tmpCompany.setLatitude(company.getLatitude());
        tmpCompany.setLongitude(company.getLongitude());
        tmpCompany.setName(company.getName());
        tmpCompany.setOwner(company.getOwner());
        tmpCompany.setSegmentCode(company.getSegmentCode());
        return companyRepository.save(tmpCompany);
    }

    public String delete(Integer id){
        companyRepository.deleteById(id);
        return companyRepository.findById(id).get() == null ?
                "Eliminada la compañia "+ id.toString() :
                "No se elimino la compañia " + id.toString() ;
    }
}
