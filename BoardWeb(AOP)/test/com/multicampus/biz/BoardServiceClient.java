package com.multicampus.biz;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

import java.util.List;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너를 생성한다.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
		// 2. 컨테이너로부터 BoardService 타입의 객체를 lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. LookUp한 객체의 메소드를 테스트한다.
		BoardVO vo = new BoardVO();
		vo.setSeq(101);
		vo.setTitle("IoC 테스트");
		vo.setWriter("테스터");
		vo.setContent("IoC 테스트 중입니다.");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}

		// 4. 컨테이너를 종료한다.
		container.close();
	}

}
