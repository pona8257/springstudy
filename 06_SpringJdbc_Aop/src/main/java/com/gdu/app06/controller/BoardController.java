package com.gdu.app06.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.app06.domain.BoardDTO;

import com.gdu.app06.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// ParameterCheckAOP에 의해서 파라미터를 체크할 메소드의 이름은 모두 ParamCheck로 끝난다. 
	
	@GetMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "list";
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "write";
	}
	
	@PostMapping("/add.do")
	public String addParamCheck(BoardDTO board) {
		boardService.addBoard(board);		// addboard() 메소드의 호출 결과인 int 값(0 또는 1)은 사용하지 않았다
		return "redirect:/list.do";	// 목록 보기로 redirect(redirect 경로는 항상 mapping으로 작성한다)
	}
	
	@GetMapping("/detail.do")
	public String detailParamCheck(HttpServletRequest request, Model model) {
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		model.addAttribute("board", boardService.getBoardByNo(boardNo));
		return "detail";
	}
	
	@GetMapping("/remove.do")
	public String removeParamCheck(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		boardService.removeBoard(boardNo);
		return "redirect:/list.do";
	}
	
	@PostMapping("/modify.do")
	public String modify(BoardDTO board) {
		boardService.editBoard(board);
		return "redirect:/detail.do?board_no=" + board.getBoard_no();
	}
	
	// 트랜잭션 처리 확인을 위한 testTx()메소드 호출하기
	@GetMapping("/tx.do") // http://localhost:9090/app06/board/tx.do
	public String tx() {
		boardService.testTx();
		return "redirect:/list.do";
	}
}
