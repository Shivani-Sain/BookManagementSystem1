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
button{
	width : 100px;
}
body{
	background-color:yellow; 
}
input[type="text"]{
	width:300px;
}
input[type="submit"]{
	width:300px;
	margin-left :40px;
	background-color:pink;
}
</style>
</head>
<body>
<h2>Retreive Book</h2>
<form method="post" action="BookController">
<table border="2px" style="background-color:orange">
<input type="hidden" name="action" value="retrieveBook"/>
<tr padding="5px">
<td>
<label>Book Name:-</label>
</td>
<td>
<input type="text" name="bookName"/>
</td>
</tr>
<tr padding="5px">
<td colspan="2">
<input type="submit" value="RetreiveBook"/>
</td>
</tr>
</table>
</form>

</body>
</html>