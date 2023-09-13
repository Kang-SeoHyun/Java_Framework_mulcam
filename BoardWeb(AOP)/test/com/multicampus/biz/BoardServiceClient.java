package com.multicampus.biz;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

import java.util.List;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. ������ �����̳ʸ� �����Ѵ�.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
		// 2. �����̳ʷκ��� BoardService Ÿ���� ��ü�� lookup�Ѵ�.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. LookUp�� ��ü�� �޼ҵ带 �׽�Ʈ�Ѵ�.
		BoardVO vo = new BoardVO();
		vo.setSeq(101);
		vo.setTitle("IoC �׽�Ʈ");
		vo.setWriter("�׽���");
		vo.setContent("IoC �׽�Ʈ ���Դϴ�.");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}

		// 4. �����̳ʸ� �����Ѵ�.
		container.close();
	}

}
