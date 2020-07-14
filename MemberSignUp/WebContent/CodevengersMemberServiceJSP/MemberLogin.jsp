<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코딩져스 신발가게 로그인화면</title>
</head>
<body>

<form action="../MemberCheckServlet">

아이디<input type="text" name="id">
비밀번호<input type="password" name="passwd">

<input type="submit">
</form>


<button onclick="location.href='MemberSignUp.jsp'">회원가입</button>
<br>




</body>
</html>