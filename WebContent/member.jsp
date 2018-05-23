<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h3>${favoMessage}</h3>


ソート：<a href="/jTraining/MemberServlet?action=sort&key=memBirth_asc">生年月日昇順</a>
<a href="/jTraining/MemberServlet?action=sort&key=memBirth_desc">生年月日降順</a>

<hr/>

	<table border="1" cellspacing="0">
	<tr><td>Name</td><td>Height</td><td>BirthDay</td><td>BloodType</td><td>Favorite</td></tr>

	<c:forEach items="${member}" var="mem">
	<!-- ↓メンバー名をリンクでServletに送ったとして、どのページに送るか（1人ずつのページにするのか） -->
	<tr><td><a href="/jTraining/MemberServlet?action=mInfo">${mem.memName}</a></td><td>${mem.memHeight}</td>
	<td>${mem.memBirth}</td><td>${mem.memBlood}</td>

	<td><form action="/jTraining/MemberServlet" method="post">
	<input type="hidden" name="action" value="favo">
	<button type="submit" name="bName" value="${mem.memName}">♡</button></form></td></tr>
	</c:forEach>

	</table>

	<a href="/jTraining/intopage.jsp">Back</a>