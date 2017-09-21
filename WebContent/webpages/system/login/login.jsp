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

th {
	width: 30%;
}

td label {
	display: none;
}
</style>
</head>
<body>
	<form action="loginController.do?login" method='post'
		enctype="application/x-www-form-urlencoded">
		<div class="divCenter">
			<table>
				<tr>
					<th><label style="align: right">账号:</label></th>
					<td><input type="text" id="userName" name="userName" /> <label
						id="NO_USER">用户不存在</label> <label id="NULL_USER">用户名不能为空</label></td>
				</tr>
				<tr>
					<th><label style="align: right">密码:</label></th>
					<td><input type="text" id="password" name="password" /> <label
						id="NULL_PSWD">密码不能为空</label> <label id="ERROR_PSWD">密码错误</label>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="width: 400px"><input type="submit"
						id="loginSubmit" style="margin-left: 45%;" value="登录" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
<script type="text/javascript">
	$("#userName").blur(function() {
		$.ajax({
			url : "loginController.do?login",
			type : "post",
			async : false,
			dataType : 'json',
			data : {
				userName : $("#userName").val()
			},
			success : function(data) {
				alert(1)
			},
			error:function(data){
				alert(2)
			}
		});
	});

	/* $("#loginSubmit").click(function() {
		if ($("#userName").val() == "") {
			($("#NULL_USER").show())
		} else if ($("#password").val() == "") {
			($("#NULL_PSWD").show())
		} else {
			$.ajax({
				url : "loginController.do?checkUser",
				type : "get",
				async : false,
				dataType : 'json',
				data : {
					ueerName : $("#userName").val()
				},
				success : function(data) {

				}
			});
		}
	})
	$("#userName").click(function() {
		$(this).parent().find('label').hide();
	})
	$("#password").click(function() {
		$(this).parent().find('label').hide();
	}) */
</script>
</html>