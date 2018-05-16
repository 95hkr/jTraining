<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>～Cinderella and Prince～</title>
</head>
<body>

<table border="1" cellspacing="0">
<tr><td>Name</td><td>Height</td><td>BirthDay</td><td>BloodType</td></tr>

<c:forEach member="${member}" var="mem">
	<tr><td>${mem.name}</td><td>${mem.height}</td><td>${mem.birth}</td><td>${mem.blood}</td></tr>
	</c:forEach>

	</table>

</body>
</html>