<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${mem.memName} Infomation</title>
</head>
<body>

<c:forEach items="${member}" var="mem">

<p>⁑Name⁑ ${mem.memName}</p>

<p>⁑Height⁑ ${mem.memHeight}</p>

<p>⁑Birth Day⁑ ${mem.memBirth}</p>

<p>⁑Blood Type⁑ ${mem.memBlood}</p>
</c:forEach>

<hr/>
<a href="/jTraining/member.jsp">Back</a>

</body>
</html>