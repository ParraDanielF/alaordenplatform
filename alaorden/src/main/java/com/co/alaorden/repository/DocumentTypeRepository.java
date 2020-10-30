package com.co.alaorden.repository;

import com.co.alaorden.model.DocumentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentTypeEntity,Integer> {
}
