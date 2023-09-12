package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Component;

// 4. service ���� Ŭ���� (�����Ͻ� ���� ó�� ���)
//@Component("boardService")
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	// type injection
	@Autowired
	private BoardDAO boardDAO;
	
	private BoardServiceImpl() {
		System.out.println("===> BoardServiceImpl ����");
	}
	
	
/*	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}*/

	public void insertBoard(BoardVO vo) {
		// 0�� �Խñ��� ����Ϸ��� �� ��, ���ܸ� �߻���Ų��.
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