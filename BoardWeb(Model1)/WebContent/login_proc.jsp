<%@page import="com.multicampus.biz.user.UserDAOJDBC"%>
<%@page import="com.multicampus.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	// 1. 사용자 입력정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB 연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAOJDBC dao = new UserDAOJDBC();
	UserVO user = dao.getUser(vo);
	
	// 3. 화면 이동
	if(user != null) {	// 로그인 성공
		session.setAttribute("user", user);
		
		response.sendRedirect("getBoardList.jsp");
	} else {			// 로그인 실패
		response.sendRedirect("login.jsp");
	}
%>
    















