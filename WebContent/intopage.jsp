<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>～Welcome～</title>
</head>
<body>

<h3 style="color:#FF6347">${message}</h3>

<p>

<a href="member.jsp?name=action">Cinderella and Prince</a>
</p>

<p>
<a href="news.jsp">News</a>
</p>
<p>
<a href="disc.jsp">Discography</a>
</p>

<br/>
<p>
<a style="color:red" href="homepage.jsp">${error}</a>
</p>

</body>
</html>