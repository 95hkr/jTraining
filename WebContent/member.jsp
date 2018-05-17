<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


ソート：<a href="/jTraining/MemberServlet?action=sort&key=memBirth_asc">生年月日昇順</a>
<a href="/jTraining/MemberServlet?action=sort&key=memBirth_desc">生年月日降順</a>

<hr/>

	<table border="1" cellspacing="0">
	<tr><td>Name</td><td>Height</td><td>BirthDay</td><td>BloodType</td></tr>

	<c:forEach items="${member}" var="mem">
	<tr><td>${mem.memName}</td><td>${mem.memHeight}</td><td>${mem.memBirth}</td><td>${mem.memBlood}</td></tr>
	</c:forEach>

	</table>