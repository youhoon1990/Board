# Board
혼자하는 게시판 프로젝트

2.26일 완료

주소
===================================

smhousegrid.com:8083/travel1/Board.do


개발환경
=================================

tomcat 8.5

jdk 1.8

oracle 11g

jquery-3.5.1.min

eclipse Version: 2020-09 (4.17.0)

bootstrap 4.2.1





특징
==================================
1. dns서버 구축
2. 회원가입 시 인증번호 메일 전송
3. 비동기 통신을 이용한 댓글
4. 게시판 페이징
5. 계층형 게시판 (답글 작성 가능)

소감
===================================

ajax의 경우 localhost가 아닌 도메인으로 데이터를 주고 받을 때 CORS 문제 발생 (response.setHeader("Access-Control-Allow-Origin", "*"); 코드로 해결가능)

ajax의 경우 jquery가 slim버전인 경우 실행 불가 

javamail의 경우 jdk 1.8 이하에서만 적용되는 문제  (Stack Overflow 에서 해결방법 찾음 javax.activision.jar 받아서 class path 하니 해결함)

이클립스 재설치 3번 했음.

war파일에 자바 파일 못찾아서 고생함(나중에 알고보니 파일 하나하나 컴파일 하는 방법 있었음)

도메인을 구입하고 개인 컴퓨터에 직접 서버를 구축하면서 고생함 (bind9 활용 , conf 파일등을 설정해주신 김광진 대표님 감사합니다.)

깃허브를 적극적으로 사용해야겠음.


