<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%List<Map<String, Object>> mlist = (List<Map<String,Object>>) request.getAttribute("mlist"); %>
<body>


<form name = "sales" action = "/jsp03_hrd/member/sales" method = "post">
		<table>
		<thead align="center" bgcolor="pink">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
				
				
				
			</tr>
			</thead>

		<tbody>
		<%
			for(Map<String, Object> m : mlist){
		%>
			<tr>
					<td><a href="/jsp03_hrd/member/modify?custno=<%=m.get("custno") %>"><%=m.get("custno") %></a> </td>
					<td><%=m.get("custname") %> </td>
					<td><%=m.get("custgrade") %> </td>
					<td><%=m.get("sales") %> </pre></td>
					
				</tr>
		<%
			}
		%>
		</tbody>
	
	</table><br>
	<button> 확인</button> <button type = "reset">취소</button>
	</form>
</body>
</html>