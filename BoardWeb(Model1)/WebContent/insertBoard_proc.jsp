<%@page import="com.multicampus.biz.board.BoardDAOJDBC"%>
<%@page import="com.multicampus.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%

	// 0. ���ڵ� ����
	request.setCharacterEncoding("EUC-KR");
	
	// 1. ����� �Է����� ����
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");

	// 2. DB ���� ó��
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setContent(content);
	
	BoardDAOJDBC dao = new BoardDAOJDBC();
	BoardVO user = dao.getBoard(vo);
	dao.insertBoard(vo);
	
	// 3. �� ��� �����ϸ� ȭ�� �̵�
	response.sendRedirect("getBoardList.jsp");
%>