<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="travel1.model.*"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--

 <c:forEach var="vo" items="${vo }">
                      <tr>
                        <td class="tg-0pky">${vo.num }</td>
                        <td class="tg-0pky"><a href="Content.do?num=${vo.num }">${vo.title }</a></td>
                        <td class="tg-0pky">${vo.name }</td>
                        <td class="tg-0pky">${vo.day }</td>
                        <td class="tg-0pky">${vo.click }</td>
                        <td class="tg-0pky">${vo.rec }</td>
                      </tr>
                      </c:forEach>

 --%>
<%
	int i = 1;
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
body {
	padding-top: 150px;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
}

.tg td {
	border-color: black;
	border-style: solid;
	border-width: 1px;
	font-family: Arial, sans-serif;
	font-size: 14px;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg th {
	border-color: black;
	border-style: solid;
	border-width: 1px;
	font-family: Arial, sans-serif;
	font-size: 12px;
	font-weight: normal;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg .tg-cjtp {
	background-color: #ecf4ff;
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-0pky {
	border-color: inherit;
	text-align: left;
	vertical-align: top
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
</head>


<body>
	<div class="navbar navbar-dark bg-dark fixed-top navbar-expand-lg">
		<div class="container">
			<a class="navbar-brand" href="#">해피투어</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbar-content">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbar-content">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">국내</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">제주</a> <a class="dropdown-item"
								href="#">Drag and Drop</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Motion</a>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="#">해외</a></li>
					<li class="nav-item"><a class="nav-link" href="#">이벤트</a></li>
					<li class="nav-item"><a class="nav-link" href="#">맞춤추천</a></li>
					<li class="nav-item"><a class="nav-link" href="#">고객센터</a></li>
				</ul>
				<form class="form-inline">
					<input type="text" class="form-control" placeholder="Search" />
				</form>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${sessionScope.id eq null }">
							<li class="nav-item"><a class="nav-link"
								href="MemberInsert.do">회원가입</a></li>
							<li class="nav-item"><a class="nav-link" href="Login.do">로그인</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="#">내 정보</a></li>
							<li class="nav-item"><a class="nav-link" href="LogOut.do">로그아웃</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<!-- 공통 -->
	<div class="container">
		<div class="row">

			<div class="col-md-12">
				<div class="jumbotron">
					<h1>자유 게시판</h1>
					<p>자유롭게 의견을 나누는 공간입니다.</p>
					<a class="btn btn-primary btn-lg" href="Write.do">글 작성하기</a>
				</div>
				<table class="tg">
					<thead>
						<tr>
							<th class="tg-cjtp" width="50px">번호</th>
							<th class="tg-cjtp">&nbsp; 제목 &nbsp;</th>
							<th class="tg-cjtp" width="70px">글쓴이</th>
							<th class="tg-cjtp" width="50">등록일</th>
							<th class="tg-cjtp" width="60">조회</th>
							<th class="tg-cjtp" width="40">추천</th>
						</tr>
					</thead>
					<tbody>
						<%-- <c:forEach var="vo" items="${vo }" begin="0" end="1" step="1">  --%>
						<c:forEach var="vo" items="${vo }">
							<tr>
								<td class="tg-0pky">${vo.num }</td>
								<td class="tg-0pky"><a href="Content.do?num=${vo.num }">${vo.title }</a></td>
								<td class="tg-0pky">${vo.name }</td>
								<td class="tg-0pky">${vo.day }</td>
								<td class="tg-0pky">${vo.click }</td>
								<td class="tg-0pky">${vo.rec }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="6"><input type="text" name="" id=""> <input
								type="submit" value="검색"> <a href="Write.do">글쓰기</a> <%--<c:forEach var="vo" items="${vo }" varStatus="status" begin="1" end= "${fn:length(vo)/20}" step="1"> --%>

								<%--게시글 페이징 시작 --%>
								<c:choose>
								<%-- pnum이 0으로 끝날때 --%>
									<c:when test="${pnum%10 eq 0 }">
										<fmt:parseNumber var="start" value="${pnum/10 }"									
									integerOnly="true" /> 
										<fmt:parseNumber var="end" value="${pnum/10 }"
									integerOnly="true" /> 
									
									<c:forEach
									var="cnt" varStatus="status" begin="${start*10-9 }"
									end="${pnum-1 }">									
									
									
									<a href="Board.do?pnum=${status.index } ">${status.index }</a>
									
									
									</c:forEach>
									<strong>${pnum }</strong> 
									
									
									
									
									
									<c:if test="${cnt > pnum }">									
									<c:choose>
									<%-- 뒤에 10페이지까지 만들어주는 경우 --%>
									<c:when test="${cnt-pnum >10 }">									
										<c:forEach var="cnt"
										varStatus="status" begin="${pnum+1 }" end="${end*10 }">
											<a href="Board.do?pnum=${status.index } ">${status.index }</a>
										</c:forEach>									
									</c:when>
									<%--총페이지까지만 만들어주는 경우 --%>
									<c:otherwise>
										<c:choose>
										<c:when test="${end+10>cnt }">
											<c:forEach var="cnt"
										varStatus="status" begin="${pnum+1 }" end="${cnt }">
											<a href="Board.do?pnum=${status.index } ">${status.index }</a>
										</c:forEach>
										</c:when>
										<c:otherwise>
										
										</c:otherwise>
										</c:choose>

																			
									</c:otherwise>
									</c:choose>
									
									</c:if>

									</c:when>
									
									
									
									
									<%-- pnum이 0으로 맞아떨어지지 않을 때  --%>
									<c:otherwise>
										<fmt:parseNumber var="start" value="${pnum/10 }"
									integerOnly="true" /> 
										<fmt:parseNumber var="end" value="${pnum/10 }"
									integerOnly="true" /> 
									
									<c:forEach
									var="cnt" varStatus="status" begin="${start*10+1 }"
									end="${pnum-1 }">

									<a href="Board.do?pnum=${status.index } ">${status.index }</a>

									</c:forEach>
									<strong>${pnum }</strong> 
								
								<c:if test="${cnt > pnum}">
									
									<c:choose>
									<%-- 뒤에 10페이지까지 만들어주는 경우 --%>
									<c:when test="${cnt-pnum gt 10 }">	
														
										<c:forEach var="cnt"
										varStatus="status" begin="${pnum+1 }" end="${end*10+10 }">
										<a href="Board.do?pnum=${status.index } ">${status.index }</a>
										</c:forEach>									
									</c:when>
									<%--총페이지까지만 만들어주는 경우 --%>
									<c:otherwise>
									<c:choose>
										<c:when test="${end*10+10>cnt }">
										
											<c:forEach var="cnt"
										varStatus="status" begin="${pnum+1 }" end="${cnt}">
											<a href="Board.do?pnum=${status.index } ">${status.index }</a>
										</c:forEach>
										</c:when>
										<c:otherwise>
											<c:forEach var="cnt"
										varStatus="status" begin="${pnum+1 }" end="${end*10+10}">
											<a href="Board.do?pnum=${status.index } ">${status.index }</a>
										</c:forEach>
										</c:otherwise>
										</c:choose>
								
									</c:otherwise>
									</c:choose>
									
									</c:if>	

					
									
									</c:otherwise>
								</c:choose>




								<c:if test="${pnum%ten }==0">
									<h5>if문 실행됨</h5>
								</c:if> 

								<h5>시작 ${start+1}</h5>
								<h5>중간 ${pnum-1 }</h5>
								<h5>${pnum%10 }</h5>
								<h5>start는 ${start }</h5>
								<h5>end 시작은 ${pnum+1 }</h5>
								<h5>end는 ${end }</h5>
								<h5>cnt-pnum는 ${cnt-pnum }</h5>
								<h5>cnt=  ${cnt }</h5></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

</html>