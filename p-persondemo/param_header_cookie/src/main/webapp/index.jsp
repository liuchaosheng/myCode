<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<a href="path/getsession">getSession person</a>
	<br><br>
	<form action="path/servletapi" method="post">
		<input type="text" name="pid" value="10001"><br>
		<input type="text" name="name" value="zhangsan"><br>
		<input type="text" name="age" value="30"><br>
		<input type="text" name="dept.deptno" value="20"><br>
		<input type="text" name="dept.dname" value="dev department"><br>
		<input type="text" name="dept.loc" value="Nanjing"><br>
		<input type="text" name="msgs" value="aaaa"><br>
		<input type="text" name="msgs" value="bbbb"><br>
		<input type="text" name="msgs" value="cccc"><br>
		<input type="text" name="msgs" value="dddd"><br>
		<input type="submit"  value="提交setSession">
	</form>
	<br><br>
	<form action="path/paramvo" method="get">
		<input type="text" name="pid" value="10001"><br>
		<input type="text" name="name" value="zhangsan"><br>
		<input type="text" name="age" value="30"><br>
		<input type="text" name="dept.deptno" value="20"><br>
		<input type="text" name="dept.dname" value="dev department"><br>
		<input type="text" name="dept.loc" value="Nanjing"><br>
		<input type="text" name="msgs" value="aaaa"><br>
		<input type="text" name="msgs" value="bbbb"><br>
		<input type="text" name="msgs" value="cccc"><br>
		<input type="text" name="msgs" value="dddd"><br>
		<input type="submit"  value="提交">
	</form>
	<br><br>
	<a href="path/cookie">测试cookieValue</a><br><br>
	<a href="path/referdemo">测试requestHeader</a>
	<br><br>
	<form action="path/addperson" method="get">
		<input type="text" name="name" value="xiaoming"><br><br>
		<input type="text" name="age" value="30"><br><br>
		<input type="submit" value="增加">
	</form>
	<br><br>
</body>
</html>