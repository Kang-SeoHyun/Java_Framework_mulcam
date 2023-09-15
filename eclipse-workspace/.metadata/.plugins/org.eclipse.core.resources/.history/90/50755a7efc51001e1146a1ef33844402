<%@page import="com.multicampus.biz.board.BoardDAOJDBC"%>
<%@page import="com.multicampus.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 0. 인코딩 설정
	request.setCharacterEncoding("EUC-KR");

	// 1. 사용자 입력정보 추출
	String title = request.getParameter("title");
	String seq = request.getParameter("seq");
	String content = request.getParameter("content");
	
	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setSeq(Integer.parseInt(seq));
	vo.setContent(content);
	
	BoardDAOJDBC dao = new BoardDAOJDBC();
	dao.updateBoard(vo);
	
	// 3. 화면 이동
	response.sendRedirect("getBoardList.jsp");
%>







