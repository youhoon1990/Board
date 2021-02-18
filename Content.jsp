<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.board {
	border: #F2F2F2 2px solid;
}

.content {
	border: #F2F2F2 2px solid;
	width: 100%;
	height: 500px;
}

.comment {
	border: green 2px solid;
	width: 100%;
	height: 100px;
}
.comment12 {
		border : green;
}
.modify {
		position: relative;
		left : 95%;
		
		
}
.list-btn{
		height: 80px;
}


</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>



<script type="text/javascript">



    //맨처음 배열선언 한 뒤  ajax에서 받아온 것 배열에 담아줄 것 ,  글 등록시 배열초기화하고 다시 띄워줄것, 가장 마지막 페이지 띄워줄것
    
    $(function(){
   $('.pageAjax').on("click",function(e){
       e.preventDefault();
       alert("a태그 막음");
   });
});
    
    var html = "";
    $(function(){
        
        getCommentList();
        
        
    });
    
    function getCommentList(){

    	console.log('ajax 실행')
    	$.ajax({
    		//게시글 번호를 가지고 가야함
    		url : 'http://localhost:8081/travel1/Comment?num='+${vo.num },
    		dataType : 'json',
    		success : function(result){
    			console.log(${vo.num })
    			alert('요청성공');
    			
    			html = "";
    			//var cnt = result.length;
    			var cnt = 500;
    			var pnum = cnt/20+1;
    			var pageNum = 1
    			console.log("json 길이는 "+result.length);
    			console.log(cnt);
    			console.log(result[1].reply);
    			if(result.length > 0){
                    
                    //for(i=0; i<result.length; i++){
                    for(i=0; i<2; i++){
                        html += "<div>";
                        html += "<div><table class='table'><h6><strong>"+result[i].name+"</strong></h6>";
                        html += result[i].reply + "<tr><td></td></tr>";
                        html += "</table></div>";
                        html += "</div>";
                    }
                    
                    html = html+"<strong> 1 </strong>"
                    
                    /*
                    for(j=2; j<cnt; j++){
                    	//html = html+"<a href=#page"+j+" id=page"+j+">" +j+" </a>" 
                    	html = html+"<a href="+"#"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> "
                    	pageNum++;
                    }
                    */
                    
                    // html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> "
                    if(pnum>2){//2페이지 이상일때만 a태그 만들어야함
                    	if(pnum<10){
                    	
                    	for(j=2; j<=pnum; j++){
                    		html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> "
                    		//pageNum++;
                    	}
                    	
                    		
                    	}else{
                    		for(j=2; j<=10; j++){
                        		html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> "
                        		//pageNum++;
                        	}
                    		html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> > </a> "	
                    	}
                    }
                    
                    
                    console.log("cnt는 "+cnt);
                    var result = document.getElementById('ajax');
                    result.innerHTML = html;
                } else {
                    
                    html += "<div>";
                    html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                    html += "</table></div>";
                    html += "</div>";
                    
                }
    		},
    		error : function(){
    			alert('요청실패..');
    		}
    		
    	});
    	
    	
    }
    
    
    function page(pageNum){
        
     	   $("a").on("click",function(e){
     	       e.preventDefault();
     	       
     	       console.log("실행안됨 a");
     	   });
     	
    	
    	$.ajax({
    		//게시글 번호를 가지고 가야함
    		url : 'http://localhost:8081/travel1/Comment?num='+${vo.num },
    		dataType : 'json',
    		success : function(result){
    			console.log(${vo.num })
    			console.log("페이지바꾸기 성공")
    			var page = $('#page2').val() //page2 태그 안에 들어있는 값?
    			console.log('page는 '+pageNum);
    			var cnt = 500;
    			var pnum = cnt/20+1; //총페이지수
    			
    			html = "";
    			
    			console.log("json 길이는 "+result.length);
    			console.log(cnt);
    			console.log(result[1].reply);
    			if(result.length > 0){
                    
                    for(i=pageNum; i<result.length; i++){
                        html += "<div>";
                        html += "<div><table class='table'><h6><strong>"+result[i].name+"</strong></h6>";
                        html += result[i].reply + "<tr><td></td></tr>";
                        html += "</table></div>";
                        html += "</div>";
                    }
                    
                    if(pageNum%10 == 0){
                    	var start = Math.floor(pageNum/10);
                    	if(start*10-9<=0){
                    		start = 1
                    	}else{
                    		start = start*10-9
                    	}
                    	
                    	
                    	for(j=start; j<pageNum; j++){
                    		html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> "
                    	}
                    	
                    	html = html+"<strong> "+pageNum+" </strong>"
                        
                        if(pnum> pageNum){
                        	start = pageNum/10;
                        	if(pnum-pageNum>10){
                        		for(j=pageNum+1; j<=start*10; j++){
                        			html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> "
                        		}
                        	}else{
                        		
                        		if(start+10>pnum){
                        			for(j=pageNum+1; j<= pnum; j++){
                        				html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> "
                        			}
                        			
                        		}
                        	}
                        }
                    	
                    	 html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> > </a> "
                    }else{  //현재 페이지가 0으로 안맞아떨어질때
                    	
                    	var start = Math.floor(pageNum/10);
                    	console.log("start는 "+start);
                    for(i=start*10+1; i<=pageNum-1; i++){
                    	html = html+"<a href="+"#commentStart"+" onclick="+"page("+i+") id="+"page"+i+"> "+i+" </a> "
                    }
                    html = html+"<strong> "+pageNum+" </strong>"
                    if(pnum>pageNum){
                    	if(pnum-pageNum > 10){
                    		for(j=pageNum+1; j<=start*10+10; j++){
                    			html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> "
                    		}
                    		console.log("2page갔을때 실행됨");
                    	}else{
                    		if(start*10+10>pnum){
                    			for(j=pageNum+1; j<=pnum; j++){
                    				html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> "
                    			}
                    		}else{
                    				for(j=pageNum+1; j<=start*10+10; j++){
                        				html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> "
                        			}
                    			}
                    		}
                    	}
                    	
                    	///
                    html = html+"<a href="+"#commentStart"+" onclick="+"page("+j+") id="+"page"+j+"> > </a> "
                    	
                    	
                    }//else문
                    
                    
                    	
                    	
                    
                    
                    /*
                    html = html+"<strong> 1 </strong>"
                    for(j=2; j<cnt; j++){
                    	html = html+"<a href="+"#"+" onclick="+"page("+j+") id="+"page"+j+"> "+j+" </a> " 
                    	
                    	
                    }
                    
                    */
                   
                    console.log("cnt는 "+cnt);
                    var result = document.getElementById('ajax');
                    result.innerHTML = html;
                
    		}
    		else {
                    
                    html += "<div>";
                    html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                    html += "</table></div>";
                    html += "</div>";
                    
                }
    			
    			//history.pushState
    			
    		},
    		error : function(){
    			alert('요청실패..');
    		}
    		
    		
    		
    	});
    	//history.pushState(null, null, '/page='+pageNum);
    }
    

    

    

    </script>
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
			<div class="list-btn">
				<c:if test="${pre!=0 }">
				<a href="Content.do?num=${pre }" class="btn btn-primary">이전글</a>				
							
				</c:if>
				
				<a href="Board.do" class="btn btn-primary">목록</a>
				<c:if test="${pre!=0 }">
				<a href="Content.do?num=${pre }" class="btn btn-primary">다음글</a>				
							
				</c:if>
				</div>
				<div class="title">
					<div class="subject"><h1>${vo.title }</h1></div>
					<h3 id="cnum">번호 : ${vo.num }	조회수 : ${vo.click } 	추천 : ${vo.rec }</h3>
				</div>
				<div class="content">
					<p>${vo.content }</p>

				</div>
				<div >
				
				<%--
				<button type="button"
					onclick="location.href='http://localhost:8081/travel/edit.do'"
					name="수정하기" class = "modify">    </button></div>   --%>
				<%-- 
                <c:forEach var="vo1" items="${vo1 }">
                <div class="comment">
                
                <h1>댓글 ㅁㄴㅇㄹ ${vo1.reply }</h1>
                </div>
                </c:forEach>  여긴 동기형 방식으로 댓글 read--%>
				<form action="/travel1/Comment.do?num=${vo.num }" method="POST">
					<textarea name="comment" id="" style="width:100%;" rows="8"
					onclick="if(this.value=='타인의 권리를 침해하거나 명예를 훼손하는 댓글은 운영원칙 및 관련 법률의 제재를 받을 수 있습니다.')
					{this.value=''}">타인의 권리를 침해하거나 명예를 훼손하는 댓글은 운영원칙 및 관련 법률의 제재를 받을 수 있습니다.</textarea>

					<div ><input type="submit" value="등록" class = "btn btn-primary modify"></div>
					
					<div id="ajax" class="comment12"></div>
				</form>
			</div>
		</div>
		<span id="commentStart">  </span>
	</div>
</body>

</html>