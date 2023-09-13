<%@page import="com.multicampus.biz.board.BoardDAOJDBC"%>
<%@page import="com.multicampus.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>

<%
	// 1. 사용자 입력정보 추출
	String seq = request.getParameter("seq");

	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAOJDBC dao = new BoardDAOJDBC();
	BoardVO board = dao.getBoard(vo);
	
	// 3. 응답 화면 구성
%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 상세</title>
</head>
<body>
<center>
<h1>게시글 상세</h1>
<hr>
<form action="updateBoard_proc.jsp" method="post">
<input name="seq" type="hidden" value="<%= board.getSeq() %>"/>
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td bgcolor="MistyRose" width="70">제목</td>
	<td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"/></td>
</tr>
<tr>
	<td bgcolor="MistyRose">작성자</td>
	<td align="left"><%= board.getWriter() %></td>
</tr>
<tr>
	<td bgcolor="MistyRose">내용</td>
	<td align="left"><textarea name="content" cols="40" rows="10"><%= board.getContent() %></textarea></td>
</tr>
<tr>
	<td bgcolor="MistyRose">등록일</td>
	<td align="left"><%= board.getRegDate() %></td>
</tr>
<tr>
	<td bgcolor="MistyRose">조회수</td>
	<td align="left"><%= board.getCnt() %></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="글 수정하기"/>
	</td>
</tr>
</table>
</form>
<hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard_proc.jsp?seq=<%= board.getSeq() %>">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.jsp">글목록</a>
</center>
</body>
</html>






