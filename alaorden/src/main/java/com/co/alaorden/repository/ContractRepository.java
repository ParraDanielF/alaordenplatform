package com.co.alaorden.repository;

import com.co.alaorden.model.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity,Integer> {
}
