package com.smhrd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.web.entity.Board;
import com.smhrd.web.service.BoardService;

@RestController
@CrossOrigin(origins ="http://127.0.0.1:5500", allowedHeaders = "*")
public class BoardRestController {
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public List<Board> list() {
		return service.getList();
	}
}
