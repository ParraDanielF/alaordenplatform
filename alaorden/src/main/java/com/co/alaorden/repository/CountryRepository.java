package com.co.alaorden.repository;

import com.co.alaorden.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
}
