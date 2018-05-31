<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinderella and Prince</title>
 <style type="text/css">
  <!--
  	h2{font-family : 'Monotype Corsiva';
  	text-align : center;
  	}
  	table{text-align:center;}
   -->
  </style>
</head>
<body>


<p>${favoMessage}</p>
<h2>～Cinderella and Prince～</h2>
<br/>

ソート：<a href="/jTraining/MemberServlet?action=sort&key=memBirth_asc">生年月日昇順</a>
<a href="/jTraining/MemberServlet?action=sort&key=memBirth_desc">生年月日降順</a>

<hr/>
<br/>

	<table border="1" cellspacing="0">
	<tr><td>Name</td><td>BirthDay</td><td>Favorite</td></tr>

	<c:forEach items="${member}" var="mem">
	<!-- ↓メンバー名をリンクでServletに送ったとして、どのページに送るか（1人ずつのページにするのか） -->
	<tr><td><a href="/jTraining/MemberServlet?action=mInfo&memCode=${mem.memCode}">${mem.memName}</a></td>
	<td>${mem.memBirth}</td>

	<td><form action="/jTraining/MemberServlet" method="post">
	<input type="hidden" name="action" value="favo">
	<button type="submit" name="bName" value="${mem.memName}">∼♡∼</button></form></td></tr>
	</c:forEach>

	</table>

	<br/>
	<br/>
	<hr>

	<a href="/jTraining/intopage.jsp">Back</a>

</body>
</html>