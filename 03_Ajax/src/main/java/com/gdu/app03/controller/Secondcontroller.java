package com.gdu.app03.controller;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app03.domain.BmiVO;
import com.gdu.app03.service.ISecondService;



@Controller
public class Secondcontroller {

	private ISecondService secondService;
	
	
	@Autowired	// 생성자에서 @AoutoWired는 생략 가능
	public Secondcontroller(ISecondService secondService) {	// <-  이거 대신 @AllArgsConstructor 사용해도됨 
		super();
		this.secondService = secondService;
	}
	
	@ResponseBody
	@GetMapping(value="/second/bmi1", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BmiVO> bmi1(HttpServletRequest request){
		return secondService.execute1(request);
	}
	
	@ResponseBody
	@GetMapping("/second/bmi2")	// produces가 없음에 주의합니다. (반환 객체 ResponseEntity에 Conent-Type을 작성해서 보냅니다.)
	public ResponseEntity<Map<String, Object>> bmi2(BmiVO bmiVO){
		return secondService.execute2(bmiVO);
	}

	/*
	@ResponseBody
	@GetMapping(value="/second/bmi1", produces=MediaType.APPLICATION_JSON_VALUE)	// MediaType.APPLICATION_JSON_VALUE는 "application/json"이다.
	public BmiVO bmi1(HttpServletRequest request, HttpServletResponse response) {
		return secondService.execute1(request, response);
	}
	
	@ResponseBody
	@GetMapping(value="/second/bmi2", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> bmi2(BmiVO bmiVO){
		return secondService.execute2(bmiVO);
	} */
}
