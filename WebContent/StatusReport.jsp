<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Here is your status</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4>Here is the status: </h4>
<c:out value="${status}"/>
<form action="ListServlet" method="post">
                <input type="hidden" name="option" value="4">
                <input type="hidden" name="listId" value="${item.id}">
                <input type="submit" value="Back">
                </form>
                
</body>
</html>