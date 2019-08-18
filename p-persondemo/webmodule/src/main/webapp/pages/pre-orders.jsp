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
	<h3>${person.name }下订单</h3>
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>价格</td>
			<td>库存</td>
			<td>购买数量<td>
		<tr>
		<c:forEach items="${products }"  var="product">
			<tr>
				<td>${product.proid }</td>
				<td>${product.proname }</td>
				<td>${product.price }</td>
				<td>${product.count }</td>
				<td><input type="text" name="count" id="count"  placeholder="输入购买数量" /><td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>