<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%//request.setCharacterEncoding("EUC-kr"); 
 //response.setContentType("text/html;charset=euc-kr");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/travel1/CSS/style.css" rel="stylesheet">
    <title>Document</title>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" />
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
</head>


<body>
    <div class="navbar navbar-dark bg-dark fixed-top navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="#">해피투어</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-content">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbar-content">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">국내</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">제주</a>
                            <a class="dropdown-item" href="#">Drag and Drop</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Motion</a>
                        </div>
                    </li>
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
                    <li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
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
    <!-- 공통 -->
    <div class="container">
        <form action="/travel1/upload.do" method="POST" enctype="multipart/form-data">
            <div class="row">

                <div class="col-md-12 board">
                    <div>
                        <h1>제목</h1>
                        <input type="text" name="title" id="title-input" placeholder="제목">
                    </div>
                    
                    <div class="content">
                        <p>내용</p>
                        <div class="textbox">
                            <textarea name="content" id="" cols="140" rows="15"></textarea>
                        </div>
                        <div>
                       		<%--<form action="upload.do" method="post" enctype="multipart/form-data">
                       			<input type = "file" name = "uploadFile"><br>
                       			<input type="submit" value="전송">
                       			
                       		</form> --%>
                       		<br>
                           <input type="submit" value="작성하기">
                        </div>
                    </div>

                    <button type="button" onclick="location.href='http://localhost:8081/travel/Board.do'"
                        name="수정하기">수정하기</button>
                </div>
                
                
            </div>
        </form>
    </div>
</body>

</html>