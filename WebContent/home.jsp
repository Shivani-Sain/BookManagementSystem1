<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
h2{
	margin-left:500px;
}
table{
	height : 70%;
	margin-left:600px;
}
button{
	width : 100px;
}
body{
	background-color:yellow; 
}
</style>
</head>
<body>
<h2>Book Management System</h2>
<table border="2px" style="background-color:blue" padding="10px">
<tr><td><button style="background-color:pink","width:15px" padding="5px"><a href="addBook.jsp">Add Book</a></button></td>
</tr>
<tr><td><button style="background-color:pink" padding="5px"><a href="updateBook.jsp">Update Book</a></button></td>
</tr>
<tr><td><button style="background-color:pink" padding="5px"><a href="deleteBook.jsp">Delete Book</a></button></td>
</tr>
<tr><td><button style="background-color:pink" padding="5px"><a href="listOfBook.jsp">List Of Book</a></button></td>
</tr>
<tr><td><button style="background-color:pink" padding="5px"><a href="retrieveBook.jsp">Retreive Book</a></button></td>
</tr>
</table>
</body>
</html>