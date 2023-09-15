<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 로그아웃 요청한 브라우저와 매핑된 세션을 강제 종료한다. 
	session.invalidate();

	response.sendRedirect("/");
%>