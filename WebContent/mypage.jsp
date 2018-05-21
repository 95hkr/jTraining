<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>～Your Page～</title>
</head>
<body>

<h2 style="color:#6495ED">～Your Infomation～</h2>
<hr/>

<table border="1" cellspacing="0">
	<tr><td>Name</td><td>Pass</td><td>Favorite</td></tr>

	<c:forEach items="${}" var="">
	<tr><td></td><td>}</td><td></td><td></td>
	<td><form action="/jTraining/CandPServlet" method="post">
	<input type="hidden" name="action" value="favo">
	<button type="submit" name="action" value="${mem.memName}">♡</button></form></td></tr>
	</c:forEach>

</table>


</body>
</html>