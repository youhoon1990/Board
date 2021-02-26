<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<link href="/travel1/CSS/style.css" rel="stylesheet">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
function btnActive()  {
	  const target = document.getElementById('target_btn');
	  target.disabled = false;
	}

	function btnDisabled()  {
	  const target = document.getElementById('target_btn');
	  target.disabled = true;
	}
</script>
<script type="text/javascript">



	$(function() {
		//버튼을 클릭했을 때 동작하는 이벤트
		$('#btn').on('click', function() {
			//ajax구조 작성해보자
			
			$.ajax({
				//1. 서버의 url작성
				url : 'http://localhost:8083/travel1/IdCheck?id='+$('#input').val(),
				//url : 'AjaxServlet',
				dataType : 'json',
				/* data : 'id='+$('#input').val(), */

				success : function(result) {
					
					console.log($('#input').val());
					alert('요청성공!');
					console.log(result);
					$('#data').html(result.boolean);
					console.log(result.boolean);
					//let tf = result.boolean.toString();
					let tf = result.boolean;
					let tff = result.boolean.toString();
					console.log(typeof tf);
					//console.log(typeof result.boolean.toString());
					if(tf==true){
						var result = document.getElementById('data');
						//var input = document.getElementByID('input');
						//console.log(input.value);
						result.innerHTML = "이미 사용중인 아이디 입니다.";
						
					}else if(tf!=true){
						var result = document.getElementById('data');
						result.innerHTML = "사용 가능한 아이디 입니다.";
						
					}
					

				},
				error : function() {
					alert('요청실패..');
					
				}
			});//ajax

		});//func

	});
</script>
<script type="text/javascript">

	$(function() {
		//버튼을 클릭했을 때 동작하는 이벤트
		$('#confirm').on('click', function() {
			//ajax구조 작성해보자
			
			$.ajax({
				//1. 서버의 url작성
				url : 'http://localhost:8083/travel1/send?email='+$('#input2').val(),
				
				dataType : 'json',
				data : {"birth": $('#bt').val()},

				success : function(result) {
					
				
				},
				error : function() {
										
				}
			});//ajax

		});//func

	});
	
	
	$(function() {
		//버튼을 클릭했을 때 동작하는 이벤트
		$('#check').on('click', function() {
			//ajax구조 작성해보자
			
			$.ajax({
				//1. 서버의 url작성
				url : 'http://localhost:8083/travel1/confirm?code='+$('#input3').val(),
				data : {"birth": $('#bt').val()},
			        
				dataType : 'json',
				

				success : function(result) {
					
					console.log($('#input2').val());
					alert('요청성공!');
					console.log(result);
					console.log("아래 뭐지?")
					//$('#data2').html(result.boolean);
					console.log(result.boolean);
					//let tf = result.boolean.toString();
					let tf = result.boolean;
					let tff = result.boolean.toString();  //string으로 바꿔줌
					console.log(typeof tf);  // 변수의 타입명
					
					
					if(tf==true){
						var result = document.getElementById('data2');
						//var input = document.getElementByID('input');
						//console.log(input.value);
						result.innerHTML = "인증 성공.";
						btnActive();
						
					}else if(tf!=true){
						var result = document.getElementById('data2');
						result.innerHTML = "인증 실패. 코드를 확인해주세요";
						btnDisabled();
						
					}
					

				},
				error : function() {
					alert('요청실패..');
					
				}
			});//ajax

		});//func

	});
</script>

<style>

</style>

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
							<li class="nav-item"><a class="nav-link" href="/travel1/MemberInsert.do">회원가입</a></li>
							<li class="nav-item"><a class="nav-link" href="/travel1/Login.do">로그인</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="#">내 정보</a></li>
							<li class="nav-item"><a class="nav-link" href="/travel1/LogOut.do">로그아웃</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<!-- 공통 -->
	<div class="container">
		<div class="row">

			<div class="col-md-12 board">
				
				
				<div class="content">
						<div class="boxbox">
						<input type="text" name="id" id="input2">
						<button id="confirm">메일보내기</button>
						<span>버튼을 누르면 이메일로 코드가 전송됩니다.</span>
						
						
						
						</div>
						<div class="boxbox">
						
						
						<input type="text" name="id" id="input3">
						<button id="check">인증하기</button>
						<span id="data2">인증시 회원가입 버튼이 활성화 됩니다.</span>
						<br>
						
						</div>
						
					<div>
						<button id="btn" style="margin-left: 19%;">id 중복 확인</button>
						<span id="data">영문, 숫자 포함 20자 이하</span>
					</div>
					<div class="textbox">
						<form action="/travel1/MemberInsert2.do" method="post">
							<table class="tg" style="table-layout: fixed; width: 90%">
								<colgroup>
									<col style="width: 67px">
									<col style="width: 277px">
								</colgroup>
								<thead>
									<tr>
										<td class="tg-0lax">아이디</td>
										<td class="tg-0lax"><input type="text" name="id" id="input"></td>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="tg-0lax">비밀번호</td>
										<td class="tg-0lax"><input type="text" name="pass"></td>

									</tr>
									<tr>
										<td class="tg-0lax">이름</td>
										<td class="tg-0lax"><input type="text" name="name"></td>
									</tr>
									<tr>
										<td class="tg-0lax">생일</td>
										<td class="tg-0lax"><input type="text" name="birth" id="bt"></td>
									</tr>
									<tr>
										<td class="tg-0lax">전화번호</td>
										<td class="tg-0lax"><input type="text" name="tel"></td>
									</tr>

									<tr>
										<td class="tg-0lax" colspan="2"><input type="submit" id='target_btn'  
											value="회원가입" disabled='disabled'> <input type="reset" value="취소"></td>

									</tr>
								</tbody>
							</table>
						</form>
						
						
					</div>

				</div>


			</div>
		</div>
	</div>
</body>

</html>