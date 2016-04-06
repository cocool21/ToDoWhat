<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Add things to do here: </h4><br/>	
<form action="ListServlet" method="post">
		<input type="hidden" name="option" value="5">
        <input type="hidden" name="userId" value="${userId}">
			<label for="item">What do you want to do?</label> 
			<input id="item" name="item" value="${param.item}">
    <br/>
    <label for="username">When would you like to finish?</label><br/> 
		Month:<input id="month" name="month" value="${param.month}">
        Date:<input id="date" name="date" value="${param.date}">
        Year:<input id="year" name="year" value="${param.year}">
	<input type="submit" value="Add">
	
	</form>
	<form action="ListServlet" method="post">
		<input type="hidden" name="option" value="4">
	<input type="submit" value="Back">
	
	</form>
</body>
</html>