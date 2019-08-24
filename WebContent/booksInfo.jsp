<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@page import="java.util.List,java.util.ArrayList,com.books.BooksBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h2{
	margin-left:500px;
}
table{
	height : 70%;
	margin-left:450px;
	width : 300px;
}
body{
	background-color:yellow; 
}
</style>
</head>
<body>
<h2>List Of Books</h2>
<%List<BooksBean> bookBean = (ArrayList)request.getAttribute("bookBean");%>
<c:forEach items="${bookBean}" var="book">
<table border="2px">
<tr padding="5px"><td>Book Id </td> <td><c:out value="${book.id}"/></td></tr>
<tr padding="5px"><td>Book Name</td><td> <c:out value="${book.bookName}"/></td></tr>
<tr padding="5px"><td>Book Qty</td><td> <c:out value="${book.qty}"/></td></tr>
</table>
</c:forEach>
</body>
</html>