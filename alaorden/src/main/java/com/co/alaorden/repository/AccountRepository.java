package com.co.alaorden.repository;

import com.co.alaorden.model.AccountEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
	
	AccountEntity findByEmail(String email);
}
