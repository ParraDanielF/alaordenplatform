package com.co.alaorden.repository;

import com.co.alaorden.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer> {
}
