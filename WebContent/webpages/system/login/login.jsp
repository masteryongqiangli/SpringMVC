<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>yongqiangli</title>
<meta charset="utf-8" />
<style>
</style>
<%@include file="/webpages/easyuipage.jsp"%>
<%@include file="/webpages/baselist.jsp"%>
<link rel="stylesheet" type="text/css" href="Res/styles/login/login.css">
<script type="text/javascript">
	(function($) {
		$.fn.drag = function(options) {
			var x, drag = this, isMove = false, defaults = {};
			var options = $.extend(defaults, options);
			//添加背景，文字，滑块
			var html = '<div class="drag_bg"></div>'
					+ '<div class="drag_text" onselectstart="return false;" unselectable="on">拖动滑块登录</div>'
					+ '<div class="handler handler_bg"></div>';
			this.append(html);

			var handler = drag.find('.handler');
			var drag_bg = drag.find('.drag_bg');
			var text = drag.find('.drag_text');
			var maxWidth = drag.width() - handler.width(); //能滑动的最大间距

			//鼠标按下时候的x轴的位置
			handler.mousedown(function(e) {
				if($("#userName").val()==""||$("#userPaswd").val()==""){
					isMove=false;
				}else{
					isMove = true;
				}
				x = e.pageX - parseInt(handler.css('left'), 10);
			});

			//鼠标指针在上下文移动时，移动距离大于0小于最大间距，滑块x轴位置等于鼠标移动距离
			$(document).mousemove(function(e) {
				var _x = e.pageX - x;
				if (isMove) {
					if (_x > 0 && _x <= maxWidth) {
						handler.css({
							'left' : _x
						});
						drag_bg.css({
							'width' : _x
						});
					} else if (_x > maxWidth) { //鼠标指针移动距离达到最大时清空事件
						dragOk();
					}
				}
			}).mouseup(function(e) {
				isMove = false;
				var _x = e.pageX - x;
				if (_x < maxWidth) { //鼠标松开时，如果没有达到最大距离位置，滑块就返回初始位置
					handler.css({
						'left' : 0
					});
					drag_bg.css({
						'width' : 0
					});
				}
			});

			//清空事件
			function dragOk() {
				handler.removeClass('handler_bg').addClass('handler_ok_bg');
				text.text('系统登录中....');
				drag.css({
					'color' : '#fff'
				});
				handler.unbind('mousedown');
				$(document).unbind('mousemove');
				$(document).unbind('mouseup');
				$.ajax({
			        type: "post",
			        cache:false, 
			        async:false, 
			        url: 'loginController.do?checkLogin',
			        data: {'userName':$("userName").val(),'passWord':$("#userPswd").val()},
			        success: function (data) {
			        	
			        },
			        error:function(data){
			        	handler.css({
							'left' : 0
						});
						drag_bg.css({
							'width' : 0
						});
			        }
			    });
			}
		};
	})(jQuery);
</script>
</head>
<body>
	<div class="content">
		<div class="content_body">
			<div class="top">
				<h1>
					<img src="Res/images/login/shulai.png" width="70px">
				</h1>
				<h1>
					yongqiangli
				</h1>
			</div>
			<form id="loginForm">
				<div class="middle">
					<div class="userInput userNameClass">
						<input id="userName" name="userName" type="text" placeholder="用户名"/>
						<label id="USER_NULL" style="display:none">用户名不能为空</label>
						<label id="NO_USER" style="display:none">用户名不存在</label>
					</div>
					<div class="userInput userPswdClass">
						<input id="userPswd" name="passWord" type="password" placeholder="密码"/>
						<label id="PASSWD_NULL" style="display:none">密码不能为空</label>
						<label id="ERROR_PASSWD" style="display:none">密码错误</label>
					</div>
				</div>
			</form>
			<div id="drag"></div>
		</div>
	</div>
	<script type="text/javascript">
		$('#drag').drag();
		var userName = $("#userName").val();
		var userPswd = $("#userPswd").val();
		$("#userName").blur(function(){
			if($(this).val()==""){
				$("#USER_NULL").show();
			}
		})
		$("#userPswd").blur(function(){
			if($(this).val()==""){
				$("#PASSWD_NULL").show();
			}
		})
		$('#userName').change(function() {
			if($(this).val()!=""){
				$('#userName').nextAll('label').hide();
			}
		});
		$('#userPswd').change(function() {
			if($(this).val()!=""){
				$('#userPswd').nextAll('label').hide();
			}
		});
	</script>
</body>
</html>