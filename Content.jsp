<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <style>
        body {
            padding-top: 150px;
        }
        .board{
        border: red 2px solid;
        }
        .content{
            border: blue 2px solid;
            width: 100%;
            height: 800px;
        }

    </style>
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
    <div class="container">
        <div class="row">

            <div class="col-md-12 board">
            <div class="title">
            <h1>${vo.title }</h1>
            <h3>${vo.num }    조회수 : ${vo.click }          추천 : ${vo.rec }</h3>
            </div>
                <div class="content">
                <p>${vo.content }</p>
                </div>
                <button type="button" onclick="location.href='http://localhost:8081/travel/edit.do'" name="수정하기">수정하기</button>
            </div>
        </div>
    </div>
</body>

</html>