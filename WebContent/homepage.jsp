<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>～Cinderella＆Prince Collection～</title>
  <style type="text/css">
  <!--
  	h1{font-family : 'Monotype Corsiva';
  	text-align : center;
  	}
   -->
  </style>
</head>
<body>

<h1>∼Wonderland∼</h1>
<p>
～Entrance～
</p>
<form action="/jTraining/CandPServlet" method="post">
お名前<input type="text" name="yourname"/><br/>
合言葉（英数字）<input type="password" name="pw"/><br/>
<input type="hidden" name="action" value="login"><br/>
<input type="submit" value="Enter">
</form>

<hr/>
<p>
～入館登録～
</p>
<form action="/jTraining/CandPServlet" method="post">
お名前<input type="text" name="nyourname"/><br/>
合言葉（英数字）<input type="password" name="npw"/><br/>
誕生日(ex.0000[年]00[月]00[日] [8word])<input type="text" name="mybirth"/><br/>
<input type="hidden" name="action" value="add"><br/>
<input type="submit" value="入館申請"/><br/>
</form>

</body>
</html>