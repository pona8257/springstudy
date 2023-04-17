package com.gdu.app04_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.app04_1.service.BoardService;

@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list.do")
	public String list(Model model) {
		return "board/list";
	}
}
