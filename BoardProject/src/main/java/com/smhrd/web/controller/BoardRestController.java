package com.smhrd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.s3.S3Client;
import com.smhrd.web.BoardProjectApplication;
import com.smhrd.web.dto.BoardRequestDTO;
import com.smhrd.web.entity.Board;
import com.smhrd.web.service.BoardService;

@RestController
@RequestMapping("/api/board") // api를 만들떄 어떤종류인지까지 설정하기
//@CrossOrigin(origins ="http://10.1.1.6", allowedHeaders = "*")
@CrossOrigin(origins ="http://127.0.0.1:5500", allowedHeaders = "*")
public class BoardRestController {

    private final S3Client amazonS3;

    private final BoardProjectApplication boardProjectApplication;
	@Autowired
	private BoardService service;

    BoardRestController(BoardProjectApplication boardProjectApplication, S3Client amazonS3) {
        this.boardProjectApplication = boardProjectApplication;
        this.amazonS3 = amazonS3;
    }
	
	@GetMapping("/list")
	public List<Board> list() {
		return service.getList();
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute BoardRequestDTO dto) {
		try {
			service.register(dto);
			return "success";
		}catch(Exception e){
			return "fail";
		}
	}
	
	
	@GetMapping("/{idx}")
	public Board getDetail(@PathVariable("idx") long b_idx) {
		System.out.println("요청한 idx : " + b_idx);
		Board board = service.getDetail(b_idx);
		System.out.println(board);
		return board;
	}
	
	@GetMapping("/{idx}/download")
	public ResponseEntity<Resource> download(@PathVariable("idx") long b_idx) {
		try {
			return service.download(b_idx);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
