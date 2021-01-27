<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>


</head>
<style>
#write{
border : 2px solid red;
}
</style>
<body>
	<h1>ajax 실습</h1>
	<h3>
		받은 데이터 출력 >>
	</h3>
	<span id="data">변경</span>
		
	
	<button id="btn">서버 요청</button>


<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$(function() {
		//버튼을 클릭했을 때 동작하는 이벤트
		$('button').on('click', function() {
			//ajax구조 작성해보자

			$.ajax({
				//1. 서버의 url작성
				url : 'http://localhost:8081/travel1/AjaxServlet',
				//url : 'AjaxServlet',
				dataType : 'json',
				 data : 'num=1234',
	             

				success : function(result) {
					alert('요청성공!');
					console.log(result);
					$('#data').html(result);
					console.log("result 받아왔음");


				},
				error : function() {
					alert('요청실패..');
				}
			});//ajax

		});//func

	});
</script>
</body>
</html>