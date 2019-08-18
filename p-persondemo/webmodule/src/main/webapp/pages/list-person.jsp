<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath %>">
<title>所有人员</title>
</head>
<body>
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>工资</td>
			<td>生日</td>
			<td>操作</td>
		<tr>
		<c:forEach items="${persons }"  var="person">
			<tr>
				<td>${person.pid }</td>
				<td>${person.name }</td>
				<td>${person.age }</td>
				<td>${person.sal }</td>
				<td>${person.birthdayStr }</td>
				<td><a href="orders/preadd?pid=${person.pid }">下订单</a>&nbsp;&nbsp;<a href="orders/list?pid=${person.pid }">查订单</a></td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>