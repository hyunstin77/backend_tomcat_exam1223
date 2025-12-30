package com.smhrd.web.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 요청데이터를 임시보관하는 객체 클래스
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequestDTO {
	private String b_title;
	private String b_writer;
	private String b_content;
	private MultipartFile b_file;
}
