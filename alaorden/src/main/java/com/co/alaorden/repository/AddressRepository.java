package com.co.alaorden.repository;

import com.co.alaorden.model.AddressEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Integer> {
	
	@Query(value = "SELECT * FROM Address WHERE email = :userId", nativeQuery = true)
	List<AddressEntity> findByUser(@Param("userId") String userId);
}
