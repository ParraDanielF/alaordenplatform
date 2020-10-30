package com.co.alaorden.repository;

import com.co.alaorden.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
}
