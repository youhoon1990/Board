<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
	var request = new XMLHttpRequest();
	function searchFunction(){
		request.open("Post", "./UserSearchServlet?userName="+ encodeURIComponent(document.getElementById("userName").value), true );
		request.onreadystatechange = searchProcess;
		request.send(null);
	}
	function searchProcess(){
		var table = document.getElementById("ajaxTable");
		table.innerHTML = "";
		if(request.readyState == 4 && request.status = 200){
			var object =eval('(' + request.responseText + ')');
			var result= object.result;
			for(var i=0; i<result.length; i++){
				var row = table.insertRow(0);
				for(var j=0; j<result[i].length; j++){
					var cell = row.insertCell(j);
					cell.innerHTML = result[i][j].value;
				}
			}
		}
		
	}
	window.onload = function(){
		searchFunction();
	}
</script>
</head>
<body>
	<div>
	<input id="userName" type="text" onkeyup="searchFunction()" size="20">
	</div>
	<div>
		<button onclick="searchFunction();" type="button">검색</button>
	</div>
	<div>
		<table>
		<thead>
		<th>이름</th>
		<th>생일</th>
		<th>아이디</th>
		<th>비밀번호</th>
		
		</thead>
		<tbody id="ajaxTable">

		
		</tbody>
		
		</table>
	</div>
</body>
</html>