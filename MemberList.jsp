<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="travel1.model.*" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>
.table{
border: solid 2px black;

}
</style>
<script>
	function memberDel(num){
		location.href="memberDelete.do?num="+num;
	}
</script>
<body>
	회원리스트(MVC : Model2방식 JSTL+EL)
	<table class="table">
	<tr>
	<th>번호</th>
	<th>아이디</th>
	<th>비밀번호</th>
	<th>이름</th>
	<th>전화번호</th>
	<th>이메일</th>
	<th>주소</th>
	<th>삭제</th>
	</tr>
	
<c:forEach var="vo" items="${list }">
	<tr>
	<td>${vo.num }</td>
	<td>${vo.id }</td>
	<td>${vo.pass }</td>
	<td>${vo.name }</td>
	<td>${vo.tel }</td>
	<td>${vo.email }</td>
	<td>${vo.addr }</td>
	<td><input type="button" value="삭제" onclick="memberDel(${vo.num })"/></td>
	
	</tr>
</c:forEach>
	<tr>
	<td colspan="8"><input type="button" value="회원가입" onclick="location.href='member/member.html'"/></td>
	</tr>
	</table>
</body>
</html>