package com.co.alaorden.repository;

import com.co.alaorden.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {
}
