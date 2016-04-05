<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to To-Do-List</title>
</head>
<body>
<form action="ListServlet" method="post">
		<h1>Login</h1>

			<label for="username">What's your username?</label> 
			<input id="username" name="username" value="${param.username}">
    <br/>
			<label for="password">What's your password?</label> 
			<input id="password" name="password" value="${param.password}">
				<input type="hidden" name="option" value="1">
	<br/>	
			<input type="submit" value="Login">
			<span>${error}</span>
	</form>
</body>
</html>