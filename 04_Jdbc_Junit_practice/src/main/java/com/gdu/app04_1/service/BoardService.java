package com.gdu.app04_1.service;

import java.util.List;

import com.gdu.app04_1.domain.BoardDTO;

public interface BoardService {

	public List<BoardDTO> getBoardList();
	public BoardDTO getBoardByNo(int board);
	public int addBoard(BoardDTO board);
	public int modifyBoard(BoardDTO board);
	public int removeBoard(int board_no);
}
