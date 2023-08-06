<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/webapp/login" method="post">
	<div>
		<label for = "username">Username</label>
		<input type = "text" name = "username" id="username">
	</div>
	<div>
		<label for = "username">Password</label>
		<input type = "password" name = "password" id="password">
	</div>
	<div>
		<input type="submit" value="send">
	</div>
	</form>
</body>
</html>