package com.co.alaorden.repository;

import com.co.alaorden.model.ContractServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractServicesRepository extends JpaRepository<ContractServicesEntity, Integer> {
}
