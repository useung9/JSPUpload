<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	Member m1 = new Member();
	Date date = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	
	String custgrade="";
	
	
%>
<body>
	<h2> 회원목록 조회 / 수정</h2>
	<table>
		<thead bgcolor ="pink"  align="center">
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>가입일자</th>
			<th>고객등급</th>
			<th>거지주역</th>
		</tr>
	
		
		<%
		List<Member> mList = (List<Member>) request.getAttribute("mList"); 
			if(mList != null ){
				for(Member member  : mList){
		%>
		</thead>
		<tbody>
		<tr>
		
			<td><a href="/jsp03_hrd/member/modify?custno=<%=member.getCustno() %>"><%=member.getCustno() %></a></td>
			<td><%=member.getCustname() %></td>
			<td><%=member.getCustphone() %></td>
			<td><%=member.getCustaddress() %></td>
			<%String[] arr =  member.getCustjoindate().split(" ");  %>
			<td><%=arr[0] %></td>
			<td><%if(member.getCustgrade().toString().equals("A")) custgrade="VIP";
			else if(member.getCustgrade().toString().equals("B")) custgrade="일반";
			else custgrade = "직원";
			%> <%=custgrade %></td>
			<td><%=member.getCustcity() %></td>
		</tr>
		<%			
				}
			}
		%>
		</tbody>
	</table>
</body>
</html>