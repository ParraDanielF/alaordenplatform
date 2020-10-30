package com.co.alaorden.repository;

import com.co.alaorden.model.ServiceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceTypeEntity,Integer> {
}
