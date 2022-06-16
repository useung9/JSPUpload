<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../design.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<script>
	
<%Member member = (Member) request.getAttribute("member");%>
	
function modifyUser() {
	// 유효성검사
	var custno = document.getElementById("custno");
	var custname = document.getElementById("custname");
	var custphone = document.getElementById("custphone");
	var custaddress = document.getElementById("custaddress");
	var custjoin = document.getElementById("custjoin");
	var custgrade = document.getElementById("custgrade");
	var custcity = document.getElementById("custcity");
	
	
	if(custno.value == ''){
		alert('정보를 다시입력해주세요');
		custno.focus();
		return ;
	}else if(custname.value == ''){
		alert('이름를 다시입력해주세요');
		custname.focus();
		return ;
	}else if(custphone.value == ''){
		alert('전화번호를 다시입력해주세요');
		custphone.focus();
		return ;
	}
	else if(custaddress.value == ''){
		alert('주소를 다시입력해주세요');
		custaddress.focus();
		return ;
	}
	else if(custjoin.value == ''){
		alert('가입날짜를 다시입력해주세요');
		custjoin.focus();
		return ;
	}
	else if(custgrade.value == '' || custgrade.value !='A' || custgrade.value != 'B'|| custgrade.value != 'C'){
		alert('고객등급를 다시입력해주세요');
		custgrade.focus();
		return ;
	}
	else if(custcity.value == '' ){
		alert('도시를 다시입력해주세요');
		custcity.focus();
		return ;
	}else {
	document.getElementById("frmmodify").submit();
	}
}

	
	
</script>
<body>
	<h2>홈쇼핑 회원 정보 수정</h2>

	<form action="/jsp03_hrd/member/update?
	custno=<%=member.getCustno()%>&custname=<%=member.getCustname()%>&custphone=<%=member.getCustphone()%>
	&custjoin=<%=member.getCustjoindate()%>&custaddress=<%=member.getCustaddress()%>&custgrade=<%=member.getCustgrade()%>&custcity=<%=member.getCustcity()%>
	" id="frmmodify" method="post" id= "update">
		<table class="modify_table">

			<tr bgcolor="pink">
				<td>회원번호</td>
				<td><input type="text" readonly="readonly"value="<%=member.getCustno()%>"></td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td><input type="text" value="<%=member.getCustname()%>" id="custname"></td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td><input type="text" value="<%=member.getCustphone()%>" id="custphone"></td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td><input type="text" value="<%=member.getCustjoindate()%>"id="custjoin"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" value="<%=member.getCustaddress()%>" id="custaddress"></td>
			</tr>
			<tr>
				<td>고객등급[ A:VIP, B:일반, C:직원]</td>
				<td><input type="text" value="<%=member.getCustgrade()%>" id="custgrade"></td>
			
			</tr>
			<tr>
				<td>도시코드</td>
				<td><input type="text" value="<%=member.getCustcity()%>" id="custcity"></td>
			</tr>

		</table>
		<button onclick="modifyUser()">확인</button>
		<button type="reset">취소</button>

	</form>
</body>
</html>