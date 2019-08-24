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
	margin-left:450px;
}
input[type="submit"]{
	width:300px;
	margin-left :0px;
	background-color:pink;
}
body{
	background-color:yellow; 
}
</style>
</head>
<body>
<h2>List Of Books</h2>
<form method="post" action="BookController">
<table border="2px" style="background-color:orange">
<input type="hidden" name="action" value="listOfBook"/>
<tr padding="5px">
<td colspan="2">
<input type="submit" value="List Of Book">
</td>
</tr>
</table>
</form>
</body>
</html>