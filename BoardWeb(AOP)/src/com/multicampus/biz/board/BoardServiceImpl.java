package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Component;

// 4. service 구현 클래스 (비지니스 로직 처리 담당)
//@Component("boardService")
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	// type injection
	@Autowired
	private BoardDAO boardDAO;
	
	public BoardServiceImpl() {
		System.out.println("===> BoardServiceImpl 생성");
	}
	
	
/*	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}*/

	public void insertBoard(BoardVO vo) {
		// 0번 게시글을 등록하려고 할 때, 예외를 발생시킨다.
		if (vo.getSeq() == 0) {
			throw new IllegalArgumentException();
		}
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
