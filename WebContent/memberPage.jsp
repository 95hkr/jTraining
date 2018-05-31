<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CandP Infomation</title>
 <style type="text/css">
  <!--
  	h1{font-family : 'Monotype Corsiva';
  	}
  	c{text-align : center;}
  	p{text-align : center;}
  	#pro{text-align : center;}
   -->
  </style>
</head>
<body>

<h1>CandP🌠</h1>
<hr>

<div id="pro">
<c:if test="${mCode == 1}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\model_m1.jpg" width="200" height="260">
</c:if>
<c:if test="${mCode == 2}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\model_f1.jpg" width="250" height="250">
</c:if>
<c:if test="${mCode == 3}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\model_m3.png" width="200" height="260">
</c:if>
<c:if test="${mCode == 4}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\model_f2.jpg" width="250" height="250">
</c:if>
<c:if test="${mCode == 5}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\model_f3.jpg" width="200" height="272">
</c:if>
<c:if test="${mCode == 6}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\model_m5.jpg" width="300" height="200">
</c:if>
<c:if test="${mCode == 7}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\tenma.jpg" width="300" height="200">
</c:if>
<c:if test="${mCode == 8}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\haruto.png" width="200" height="298">
</c:if>
</div>
<br/>
<p>⁑Name⁑ ${mName}</p>

<p>⁑Height⁑ ${mHeight}cm</p>

<p>⁑Birth Day⁑ ${mBirth}</p>

<p>⁑Blood Type⁑ ${mBlood}</p>

<p>⁑Photo⁑<br/>
<c:if test="${mCode == 1}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\model_m2.jpg" width="200" height="260">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\model_m4.jpg" width="200" height="260">
</c:if>
<c:if test="${mCode == 7}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\tenma2.jpg" width="250" height="250">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\tenma3.jpg" width="250" height="250">
</c:if>
<c:if test="${mCode == 8}">
	<img src="C:\Users\kanri\OneDrive\ドキュメント\soejima\model\haruto2.jpg" width="250" height="250">
</c:if>
</p>

<hr/>
<a href="/jTraining/member.jsp">Back</a>
<br/>
<br/>
<br/>

</body>
</html>