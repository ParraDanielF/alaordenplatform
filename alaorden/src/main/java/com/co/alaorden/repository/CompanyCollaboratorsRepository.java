package com.co.alaorden.repository;

import com.co.alaorden.model.CompanyCollaboratorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyCollaboratorsRepository extends JpaRepository<CompanyCollaboratorsEntity,Integer> {
}
