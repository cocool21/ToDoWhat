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
<form action="ListServlet" method="post">
		<input type="hidden" name="option" value="6">
	<input type="submit" value="Add new to list">
	
	</form>
</body>
</html>