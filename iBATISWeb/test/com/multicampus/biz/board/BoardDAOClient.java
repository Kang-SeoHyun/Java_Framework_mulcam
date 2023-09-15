package com.multicampus.biz.board;

import java.sql.SQLException;
import java.util.List;

public class BoardDAOClient {

	public static void main(String[] args) throws SQLException {
		BoardDAO boardDAO = new BoardDAO();

		BoardVO vo = new BoardVO();
		vo.setTitle("iBatis 제목");
		vo.setWriter("iBatis");
		vo.setContent("iBatis 내용......");
		boardDAO.insertBoard(vo);
		
		List<BoardVO> boardList = boardDAO.getBoardList();
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

}
