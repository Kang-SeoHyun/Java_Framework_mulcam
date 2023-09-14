package com.multicampus.controller.board;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.board.BoardDAOJDBC;
import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

// Model�� "board"��� �̸��� �����Ͱ� ��ϵ� ��, ���ǿ��� "board"��� �̸����� �����ϰ� ����ض�.
@SessionAttributes("board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// �� ��� ȭ������ �̵�
	@RequestMapping("/insertBoardView.do")
	public String insertBoardView() throws Exception {
		return "insertBoard";
	}

	// �� ��� 
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
		
		// 1. ���� ���ε� ó��
		MultipartFile upload = vo.getUploadFile();
		if (!upload.isEmpty()) {
			String fileName = upload.getOriginalFilename();
			upload.transferTo(new File("C:/DEV/upload_files/" + fileName));
		}
		
		// 2. �� ��� ó��
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	// �� ����
	@RequestMapping("/updateBoard.do")
	// ���ǿ� ���� ��� �̸����� ��ϵ� ��ü�� �ִٸ� �� ��ü�� �켱 �����ض�.
	public String updateBoard(@ModelAttribute("board") BoardVO vo) throws Exception {
		boardService.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// �� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// �� �� ��ȸ
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}
	
	// �� ��� �˻�
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
		//Null check
		if (vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo));
		model.addAttribute("search", vo);
		return "getBoardList";
	}

}









