<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<form action="path/restful/101" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="restful-delete">
	</form>
	<br><br>
	<form action="path/restful/101" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="restful-put">
	</form>
	<br><br>
	<form action="path/restful" method="post">
		<input type="submit" value="restful-post">
	</form>
	<br><br>
	<a href="path/restful/1">restful-get</a>
	<br><br>
	<a href="path/jsp/demo.jsp">请求的jsp跟requestMapping中定义的ant路径一致</a>
	<br><br>
	<a href="path/testAnt/abxddsjlfjsljflsj">ant风格</a>
	<br><br>
	<a href="path/param?username=xiaoming&age=10">param路径的get请求带有参数</a>
	<br><br>
	<form action="path/method" method="post">
		<input type="submit" value="method路径的post请求">
	</form>
	<br><br>
	<a href="path/method">method路径的get请求</a>
	<br><br>
</body>
</html>