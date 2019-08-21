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
<title>下单</title>
<link rel="stylesheet" type="text/css" href="bs/css/bootstrap.css">
<script type="text/javascript" src="bs/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="bs/js/bootstrap.js"></script>
</head>
<body>
	<h3>${person.name }下订单<input id="pid" value="${person.pid }" style="display:none"></h3>
	<table class="table table-bordered" id="productTable">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>价格</td>
			<td>库存</td>
			<td>购买数量</td>
			<td>价格计算</td>
		</tr>
		<c:forEach items="${products }"  var="product">
			<tr>
				<td>${product.proid }</td>
				<td>${product.proname }</td>
				<td>${product.price }</td>
				<td>${product.count }</td>
				<td>
					<button class="btn btn-xs btn-primary" style="border-radius:5px" data-attach="subBtn">-</button>
					<input type="text" name="count_${product.proid }" id="count_${proid }"  value="0" style="display:inline-block;width:50px" disabled="disabled"/>
					<button class="btn btn-xs btn-primary" data-attach="addBtn">+</button>
				</td>
				<td class="oneprice">0</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="5" style="text-align:right">总价</td>
				<td id="allprice">0</td>
			</tr>
	</table>
	<hr>
	<button class="btn btn-primary" id="addOrdersBtn">提交订单</button>
	<br><br><br>
	<a href="index.jsp">主页</a>
	
	
	<script type="text/javascript">
		// btn的事件委托
		$("#productTable").on("click",".btn",function(event){
			var target = $(event.target);
			if(target.attr("data-attach") == "subBtn"){
				var input = target.siblings("input");
				var value = input.val();
				if(value > 0){
					input.val(--value);
				}
				var price = (target.parent().siblings("td:eq(2)").text()) * value;
				target.parent().siblings("td:last").text(price);
				var allprice = 0;
				$(".oneprice").each(function(index,ele){
					allprice+=Number($(ele).text());
				});
				$("#allprice").text(allprice);
			}else{
				var input = target.siblings("input");
				var value = input.val();
				input.val(++value);
				var price = (target.parent().siblings("td:eq(2)").text()) * value;
				target.parent().siblings("td:last").text(price);
				var allprice = 0;
				$(".oneprice").each(function(index,ele){
					allprice+=Number($(ele).text());
				});
				$("#allprice").text(allprice);
			}
		});
		$("#addOrdersBtn").on("click",function(){
			var proids="";
			var counts="";
			var theCount = 0;
			//该对象将被ajax请求以json的格式发给服务器
			var obj = {
					pid : $("#pid").val(),
					proids : [],
					counts : []
			};
			// 计算proids,counts
			$("table input").each(function(index,ele){
				var count = $(ele).val();
				if(count > 0){
					theCount ++;
					obj.counts.push(count);
					var proid=$(ele).parent().siblings("td:eq(0)").text();
					obj.proids.push(proid);
				}
			});
			if(theCount > 0){
				$.ajax({
					url : "orders/add",
					method : "post",
					dataType : "text",
					contentType : "application/json",
					data : JSON.stringify(obj),
					success : function(data){
						alert(data);
					},
					error : function(){
						alert("error");
					}
				});				
			}
		});
	</script>
</body>
</html>