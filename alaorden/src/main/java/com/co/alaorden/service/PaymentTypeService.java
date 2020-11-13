package com.co.alaorden.service;

import com.co.alaorden.model.PaymentTypeEntity;
import com.co.alaorden.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentTypeService {
    @Autowired
    PaymentTypeRepository paymentTypeRepository;

    public PaymentTypeEntity create (PaymentTypeEntity paymentType){
        return paymentTypeRepository.save(paymentType);
    }

    public PaymentTypeEntity read (Integer id){
        return paymentTypeRepository.findById(id).get();
    }

    public PaymentTypeEntity update (PaymentTypeEntity paymentType, Integer id){
        PaymentTypeEntity tmpPaymentType = paymentTypeRepository.findById(id).get();
        tmpPaymentType.setDescription(paymentType.getDescription());
        return paymentTypeRepository.save(tmpPaymentType);
    }

    public String delete (Integer id){
        paymentTypeRepository.deleteById(id);
        return paymentTypeRepository.findById(id).get() == null ?
                "Eliminado el tipo de pago "+ id.toString() :
                "No se elimino el tipo de pago " + id.toString() ;
    }
}
