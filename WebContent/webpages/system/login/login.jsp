<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/webpages/easyuipage.jsp"%>
<%@include file="/webpages/baselist.jsp"%>
<head>
<title>SpringMVC</title>
<style type="text/css">
.divCenter {
	margin: 300px auto;
	width: 400px;
	height: 100px;
	border: 1px solid #F00;
}

tr {
	display: block; /*将tr设置为块体元素*/
	margin: 20px 0; /*设置tr间距为2px*/
	width: 400px;
}
th{
	width:30%;
}
</style>
</head>
<body>
	<form action="loginController.do?login" method = 'post' enctype="application/x-www-form-urlencoded">
		<div class="divCenter">
			<table>
				<tr>
					<th><label style="align:right">账号:</label></th>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<th><label style="align:right">密码:</label></th>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<td colspan="2" style="width: 400px"><input type="submit"
						style="margin-left: 45%;" value="登录" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>