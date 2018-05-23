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

<p>⁑Name⁑ ${intoName}</p>

<p>⁑Pass⁑ ${mypass}</p>

<p>⁑BirthDay⁑ ${mybirth}</p>

<p>⁑Favorite Member⁑ ${myFmem} ${nullmessage}</p>

<form action="/jTraining/MemberServlet" method="post">
<input type="hidden" name="action" value="nullfavo">
<input type="submit" value="Reset">
</form>

<hr/>
<p><a href="/jTraining/intopage.jsp">Menuへ</a></p>

<a href="/jTraining/reallyDele.jsp">アカウントを削除</a>

</body>
</html>