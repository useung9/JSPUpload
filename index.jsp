<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../header.jsp"%>
</head>
<body>
	<nav>
		
		<table class="navtable" >
			<tr>
				<td><a href="add.jsp">회원등록</a></td>
				<td><a href="/jsp03_hrd/member/search"> 회원목록 조회/수정</a></td>
				<td><a href="/jsp03_hrd/member/sales">회원매출 조회</a></td>
				<td>홈으로</td>
			<tr>
		</table>
		
	</nav>
	
	<section id = "sectionmove">
		<article>기본출력</article>
	</section>
</body>
<footer>
	<%@include file="../footer.jsp"%>
</footer>
</html>