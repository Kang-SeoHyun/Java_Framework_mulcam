<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// �α׾ƿ� ��û�� �������� ���ε� ������ ���� �����Ѵ�. 
	session.invalidate();

	response.sendRedirect("/");
%>