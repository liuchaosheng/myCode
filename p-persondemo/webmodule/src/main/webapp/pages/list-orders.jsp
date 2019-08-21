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
<title>所有订单</title>
</head>
<body>
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td>订单编号</td>
			<td>创建时间</td>
			<td>总价</td>
			<td>下单人</td>
			<td>详情</td>
		<tr>
		<c:forEach items="${allOrders }"  var="order">
			<tr>
				<td>${order.oid }</td>
				<td>${order.createTimeStr }</td>
				<td>${order.allPrice }</td>
				<td>${order.person.name }</td>
				<td>
					<c:forEach items="${order.orderDetails }" var="orderDetail">
						<li>产品名：${orderDetail.proname }，数量：${orderDetail.count }</li>
					</c:forEach>
				</td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>