<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
</head>
<body>
	<br><br>
	<form action="personedit" method="post">
		<input type="hidden" name="pid" value="10"/>
		姓名：<input type="text" name="name" value="zhaoyang"/>
		<input type="submit" value="修改"/>
	</form>
	<br><br>
</body>
</html>