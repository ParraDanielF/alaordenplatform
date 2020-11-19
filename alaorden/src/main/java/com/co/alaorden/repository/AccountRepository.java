package com.co.alaorden.repository;

import com.co.alaorden.model.AccountEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

	@Query(value = "SELECT * FROM Account a where a.email = ?0", nativeQuery=true)
	Optional<AccountEntity> findByEmail(String email);
}
