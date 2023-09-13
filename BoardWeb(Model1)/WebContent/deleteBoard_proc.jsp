<%@page import="com.multicampus.biz.board.BoardDAOJDBC"%>
<%@page import="com.multicampus.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%

	// 1. 삭제 글 입력정보 추출
	String seq = request.getParameter("seq");

	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAOJDBC dao = new BoardDAOJDBC();
	dao.deleteBoard(vo);
	
	// 3. 글 삭제 성공하면 화면 이동
	response.sendRedirect("getBoardList.jsp");
%>