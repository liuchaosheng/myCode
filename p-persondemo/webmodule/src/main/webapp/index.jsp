<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath %>">
<title>主页</title>
</head>
<body>
	<h3>测试页面</h3>
	<form action="product/add" method="post">
		名称：<input type="text" name="proname" id="proname"><br>
		原价：<input type="text" name="oriprice" id="oriprice"><br>
		价格：<input type="text" name="price" id="price"><br>
		数量：<input type="text" name="count" id="count"><br>
		<input type="submit" value="增加商品">
	</form>
</body>
</html>