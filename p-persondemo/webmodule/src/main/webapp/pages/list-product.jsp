<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有产品</title>
</head>
<body>
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>原价</td>
			<td>价格</td>
			<td>库存</td>
		<tr>
		<c:forEach items="${products }"  var="product">
			<tr>
				<td>${product.proid }</td>
				<td>${product.proname }</td>
				<td>${product.oriprice }</td>
				<td>${product.price }</td>
				<td>${product.count }</td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>