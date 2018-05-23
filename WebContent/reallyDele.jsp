<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation</title>
</head>
<body>
<h2>本当に削除してもよろしいですか？</h2>
<form action="/jTraining/CandPServlet" method="post">
<input type="hidden" name="action" value="acDele">
<input type="submit" value="削除する">
</form>

<hr/>
<a href="/jTraining/intopage.jsp">削除をやめてMenuへ</a>

</body>
</html>