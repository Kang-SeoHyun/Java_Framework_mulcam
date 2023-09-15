<%@page import="com.multicampus.biz.user.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="com.multicampus.biz.board.BoardDAOJDBC"%>
<%@page import="com.multicampus.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	// 1. DB ���� ó��
	BoardVO vo = new BoardVO();
	BoardDAOJDBC dao = new BoardDAOJDBC();
	List<BoardVO> boardList = dao.getBoardList(vo);
	
	// 2. ���� ȭ�� ����
	UserVO user = (UserVO) session.getAttribute("user");	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ���</title>
</head>
<body>
<center>
<h1>�Խñ� ���</h1>
<h3><font color="red"><%= user.getName() %></font>�� ȯ���մϴ�....<a href="logout_proc.jsp">LOG-OUT</a></h3>

<!-- �˻� ȭ�� ���� -->
<form action="getBoardList.jsp" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
			<option value="TITLE">����</option>
			<option value="CONTENT">����</option>
			</select>
			<input name="searchKeyword" type="text"/>
			<input type="submit" value="�˻�"/>
		</td>
	</tr>
	</table>
</form>
<!-- �˻� ȭ�� ���� -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100">��ȣ</th>
	<th bgcolor="orange" width="200">����</th>
	<th bgcolor="orange" width="150">�ۼ���</th>
	<th bgcolor="orange" width="150">�����</th>
	<th bgcolor="orange" width="100">��ȸ��</th>
</tr>

<% for(BoardVO board : boardList) { %>
<tr>
	<td><%= board.getSeq() %></td>
	<td align="left"><a href="getBoard.jsp?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
	<td><%= board.getWriter() %></td>
	<td><%= board.getRegDate() %></td>
	<td><%= board.getCnt() %></td>
</tr>
<% } %>

</table>
<br>
<a href="insertBoard.jsp">��� ȭ������ �̵�</a>
</center>
</body>
</html>


