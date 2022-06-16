<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<script type= "text/javascript">
if('<%=request.getParameter("msg")%>' != 'null')
{
	alert(<%=request.getParameter("msg")%>);
}



function addUser() {
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
	document.getElementById("frmadd").submit();
	}
}

</script>


<html>
<head>
<link href="../design.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h2> 홈쇼핑 회원 등록</h2>
	<form action="/jsp03_hrd/member/add" id="frmadd">
		<table class="add_table" border="1">
			<tr>
				<td>회원번호</td> 	<td><input type ="text" name = "custno" value="" readonly="readonly"></td>
			</tr>	
			<tr>
				<td>회원성명</td> <td><input type = "text" name = "custname" id="custname"></td>
			</tr> 
			<tr>
				<td>회원전화</td> <td><input type = "text" name = "custphone" id="custphone"></td>
			</tr> 
			<tr>
				<td>회원주소</td> <td><input type = "text" name = "custaddress" id="custaddress"></td>
			</tr> 
			<tr>
				<td>가입일자</td> <td><input type = "text" name = "custjoin" id = "custjoin" value="test" readonly="readonly"></td>
			</tr> 
			<tr>
				<td>고객등급[A : VIP, B: 일반, C: 직원]</td> <td><input type = "text" name = "custgrade" id= "custgrade" maxlength="3"></td>
			</tr> 
			<tr>
				<td>도시코드</td> <td><input type = "text" name = "custcity" id = "custcity" maxlength="2"></td>
			</tr> 
			
		</table>
		<button onclick="addUser()"> 확인</button>
		<button type = "reset" > 취소</button>
	</form>
</body>
</html>

