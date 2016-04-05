<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage your list here</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
th, td {
	padding: 15px;
}
th {
	text-align: left;
}
</style>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h2>Your To-Do List</h2>

	<table style="width: 100%">
		<tr>
			<th>Id in list</th>
			<th>Things to do</th>
			<th>Deadline</th>
			<th>Status</th>
			<th>Action</th>

		</tr>
		<c:forEach var="item" items="${ToDoList}">
			<tr>
				<td><c:out value="${item.id }" /></td>
				<td><c:out value="${item.item }" /></td>
                <td><c:out value="${item.deadline }" /></td>
                <td>
                <form action="ListServlet" method="post">
                <input type="hidden" name="option" value="2">
                <input type="hidden" name="listId" value="${item.id}">
                <input type="submit" value="Check Status">
                </form>
                </td>
  
                <td>
                <form action="ListServlet" method="post">
                <input type="hidden" name="option" value="3">
                <input type="hidden" name="listId" value="${item.id}">
                <input type="submit" value="I'm done!">
                </form>
                </td>
 
			</tr>
		</c:forEach>
	</table>
	<c:out value="${done}"/>
<h4>Add things to do here: </h4><br/>	
<form action="Listservlet" method="post">
		<input type="hidden" name="option" value="5">
        <input type="hidden" name="userId" value="${userId}">
			<label for="item">What do you want to do?</label> 
			<input id="item" name="item" value="${param.username}">
    <br/>
    <label for="username">When would you like to finish?</label><br/> 
		Month:<input id="month" name="month" value="${param.month}"><br>
        Date:<input id="date" name="date" value="${param.date}"><br>
        Year:<input id="year" name="year" value="${param.year}"><br>
	<input type="submit" value="Add">
	
	</form>
</body>
</html>