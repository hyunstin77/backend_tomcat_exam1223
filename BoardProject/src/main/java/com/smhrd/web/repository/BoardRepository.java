package com.smhrd.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.web.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	
}
