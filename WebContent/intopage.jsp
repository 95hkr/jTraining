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

<h2 style="color:#FFD700">～${intoName}様、ようこそ～</h2>

<p></p><form action="/jTraining/MemberServlet" method="post">
<input type="hidden" name="action" value="group">
<input type="submit" value="Cinderella and Prince">
</form>

<p></p><form action="/jTraining/???Servlet" method="post">
<input type="hidden" name="action" value="ns">
<input type="submit" value="News">
</form>

<p></p><form action=/jTraining/???Servlet method="post">
<input type="hidden" name="action" value="disc">
<input type="submit" value="Product">
</form>

<p></p><form action="/jTraining/CandPServlet" method="post">
<input type="hidden" name="action" value="mypg">
<input type="submit" value="My Page">
</form>

<p></p><form action="/jTraining/CandPServlet" method="post">
<input type="hidden" name="action" value="logout">
<input type="submit" value="出口">
</form>

</body>
</html>