package com.co.alaorden.repository;

import com.co.alaorden.model.PaymentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentTypeEntity,Integer> {
}
