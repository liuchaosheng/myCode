<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人员信息列表</title>
</head>
<body>
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>人员编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${persons}" var="person">
			<tr>
				<td>${person.pid}</td>
				<td>${person.name}</td>
				<td>${person.age}</td>
			</tr>
		</c:forEach>
	</table>
		<br>
		<hr>
		<h3>${sessionScope.msg }</h3>
</body>
</html>