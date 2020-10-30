package com.co.alaorden.repository;

import com.co.alaorden.model.RecoveryDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryDataRepository extends JpaRepository<RecoveryDataEntity,Integer> {
}
