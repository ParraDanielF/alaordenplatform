package com.co.alaorden.repository;

import com.co.alaorden.model.AccountEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

	@Query(value = "SELECT * FROM Account WHERE email = :email", nativeQuery = true)
	AccountEntity findByEmail(@Param("email") String email);
}
