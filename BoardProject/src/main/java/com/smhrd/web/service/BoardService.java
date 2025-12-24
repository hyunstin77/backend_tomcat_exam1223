package com.smhrd.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.web.entity.Board;
import com.smhrd.web.repository.BoardRepository;

@Service
public class BoardService {
	// 1. repository 객체 생성
	@Autowired
	private BoardRepository repo;
	
	// 2. DB관련 기능 구현
	// 게시글 전체보기 기능
	public List<Board> getList(){
		return repo.findAll();
	}
}
