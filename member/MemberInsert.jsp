<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            padding-top: 150px;
            /* border: red solid 2px; */
        }

        .board {
            border: red 2px solid;
        }

        .content {
            border: blue 2px solid;
            width: 100%;
            height: 800px;
        }

        #title-input {
            width: 800px;
        }

        .textbox {
            border: yellow 2px solid;
            position: relative;
            left: 10px;

        }

        .tg {
            border-collapse: collapse;
            border-spacing: 0;
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
            font-size: 14px;
            font-weight: normal;
            overflow: hidden;
            padding: 10px 5px;
            word-break: normal;
        }

        .tg .tg-0lax {
            text-align: left;
            vertical-align: top
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
                <div>
                    <h1>제목</h1>
                    <input type="text" name="" id="title-input" placeholder="제목">
                </div>
                <div>
                    <a href="http://localhost:8081/travel/Board.do">목록</a>
                    <a href="http://localhost:8081/travel/Content.do?num=1">이전글</a>
                    <a href="">다음글</a>
                </div>
                <div class="content">
                    <p>${vo.content }</p>
                    <div class="textbox">
                        <form action="/travel/MemberInsert.do" method="post">
                        <table class="tg" style="undefined;table-layout: fixed; width: 344px">
                            <colgroup>
                                <col style="width: 67px">
                                <col style="width: 277px">
                            </colgroup>
                            <thead>
                                <tr>
                                    <td class="tg-0lax">아이디</td>
                                    <td class="tg-0lax"><input type="text" name="id"></td>
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
                                    <td class="tg-0lax"><input type="text" name="birth"></td>
                                </tr>
                                <tr>
                                    <td class="tg-0lax">전화번호</td>
                                    <td class="tg-0lax"><input type="text" name="tel"></td>
                                </tr>
                                <tr>
                                    <td class="tg-0lax" colspan="2"><input type="submit" value="회원가입">
                                        <input type="reset" value="취소"></td>
                                    
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