package com.co.alaorden.repository;

import com.co.alaorden.model.NotificationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends JpaRepository<NotificationsEntity, Integer> {
}
