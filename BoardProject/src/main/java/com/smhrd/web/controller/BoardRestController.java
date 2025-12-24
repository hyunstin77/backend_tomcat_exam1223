package com.smhrd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.web.entity.Board;
import com.smhrd.web.service.BoardService;

@RestController
@RequestMapping("/api/board") // api를 만들떄 어떤종류인지까지 설정하기
@CrossOrigin(origins ="http://10.1.1.6", allowedHeaders = "*")
//@CrossOrigin(origins ="http://127.0.0.1:5500", allowedHeaders = "*")
public class BoardRestController {
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public List<Board> list() {
		return service.getList();
	}
}
