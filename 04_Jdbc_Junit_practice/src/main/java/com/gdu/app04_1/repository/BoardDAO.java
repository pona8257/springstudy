package com.gdu.app04_1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.app04_1.domain.BoardDTO;






@Repository
public class BoardDAO {

	// jdbc 방식
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// private 메소드
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GDJ61", "1111");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// private 메소드 - 2 (BoardDAO 클래스 내부에서만 사용)
	private void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DAO 메소드 (BoardServiceImpl 클래스에서 사용하는 메소드)
	// DAO 메소드명
	// 방법1. BoardServiceImpl의 메소드와 이름을 맞춤
	// 방법2. DB 친화적으로 새 이름을 부여 (이론상 권장)
			
	// 1. 목록
	public List<BoardDTO> selectBoardList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list.add(new BoardDTO(1, "제목", "내용", "작성자", "작성일", "수정일"));
		return list;
	}
	
}
