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
<!-- 引入jquery  -->
<script type="text/javascript" src="bs/js/jquery-3.3.1.js"></script>
</head>
<body>
	<h3>测试主页面</h3>
	
	<button id="addPersonUseJsonMulty">发起ajax请求增加人员复杂对象</button>
	
	<br><br><br>
	
	<button id="addPersonUseJson">发起ajax请求增加人员</button>
	
	<br><br><br>
	<form action="product/add" method="post">
		名称：<input type="text" name="proname" id="proname"><br>
		原价：<input type="text" name="oriprice" id="oriprice"><br>
		价格：<input type="text" name="price" id="price"><br>
		数量：<input type="text" name="count" id="count"><br><br>
		<input type="submit" value="增加商品">
	</form>
	
	<br><br><br>
	
	<form action="person/add" method="post">
		姓名：<input type="text" name="name" id="name"><br>
		年龄：<input type="text" name="age" id="age"><br>
		工资：<input type="text" name="sal" id="sal"><br>
		生日：<input type="text" name="birthday" id="birthday" value="1990-10-04"><br><br>
		<input type="submit" value="增加人员">
	</form>

	<br><br><br>
	<a href="product/list">产品列表</a>
	<br><br><br>
	<a href="person/list">人员列表</a>
	<br><br><br>
	<a href="orders/list">订单列表</a>
	
	<script type="text/javascript">
		$(document).ready(function(){
			// 添加增加人员的事件监听器
			$("#addPersonUseJson").on("click",function(){
				var url = "person/addUserJson";
				var data = {
						name : "朝阳",
						age : 30,
						sal : 9000.0
				};
				$.ajax({
					url : url,
					data : JSON.stringify(data),
					type : "post",
					dataType : "json",
					contentType : "application/json",
					headers : {
						"x-nodeid" : 4050,
						Accept : "application/json"
					},
					success : function(data){
						console.log(data);
					},
					error : function(){
						alert("出错了");
					}
				});
			});
			
			// 复杂对象
			$("#addPersonUseJsonMulty").on("click",function(){
				var url = "person/addUserJsonNew";
				var data = {
						name : "朝阳",
						age : 30,
						sal : 9000.0,
						dept : {
							deptno : 10,
							dname : "开发部"
						}
				};
				$.ajax({
					url : url,
					data : JSON.stringify(data),
					type : "post",
					dataType : "json",
					contentType : "application/json",
					success : function(data){
						console.log(data);
					},
					error : function(){
						alert("出错了");
					}
				});
			});
		});
	</script>
	
</body>
</html>