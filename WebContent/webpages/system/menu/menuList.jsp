<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/webpages/easyuipage.jsp"%>
<%@include file="/webpages/baselist.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div class="datacontent">
		<div class="toolbar" id="toolbar">
			<div>
				<ul>
					<li><i></i><font>菜单管理</font></li>
					<li><a id="add" href="#" onclick="add()" class="easyui-linkbutton"
						data-options="iconCls:'icon-add'">新增</a></li>
					<li><a href="#" onclick="expend()" class="easyui-linkbutton"
						data-options="iconCls:'icon-expend'">展开</a></li>
					<li><a href="#" onclick="collapse()" class="easyui-linkbutton"
						data-options="iconCls:'icon-collapse'">折叠</a></li>
				</ul>
			</div>
		</div>
		<div class="box">
			<table id="menu-list">
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$('#menu-list').treegrid({
			url : 'sys_BaseMenuController.do?dataGrid',
			fit : true,
			fitColumns : true,
			striped : true,
			rownumbers : true,
			animate : true,
			toolbar : '#toolbar',
			idField : 'menuID',
			treeField : 'menuName',   
			columns : [ [ {
				field : 'menuName',
				title : '菜单名称',
				width : 60,
				align : 'left',
				halign : 'center'
			}, {
				field : 'menuUrl',
				title : '访问地址',
				width : 60,
				align : 'left',
				halign : 'center'
			}, {
				field : 'orderNum',
				title : '排序',
				width : 60,
				align : 'center',
				halign : 'center'
			}, {
				field : 'opt',
				title : '操作',
				width : 60,
				align : 'center',
				halign : 'center',
				formatter : optformatter
			}, ] ]

		});
		function optformatter(value, row, index) {
			var str=''
				if(row.parentMenuID!=""){
					str+='<a href="#" class="grid-btn grid-edit" onclick="updateItem(\''
						+ row.menuId
						+ '\')">修改</a>';
							}
				if(row.parentMenuID!=""){
					str+='<a href="#" class="grid-btn grid-detail" onclick="lookItem(\''
							+ row.menuId
							+ '\')">查看</a>';
							}
				if(row.parentMenuID!=""){
					str+='<a href="#" class="grid-btn grid-delete" onclick="deleteMenu(\''
						+ row.menuId + '\')">删除</a>';
									}
				return str;	
		}
		function expend(){
			$('#menu-list').treegrid('expandAll');
		}
		function collapse(){
			$('#menu-list').treegrid('collapseAll');
		}
		function deleteMenu(MenuId){
			deleteItem('menuController.do?doDelete&MenuId='+MenuId,'menu-list');
		}
		function expend() {
			$('#menu-list').treegrid('expandAll');
		}
		function collapse() {
			$('#menu-list').treegrid('collapseAll');
		}
		 
		function updateItem(menuId) {
			openDialog('修改','sys_BaseMenuController.do?goAddorUpdate&menuId='+ menuId ,500,top.$(window).height() * 0.6);
		}
		function lookItem(menuId) {
			openDialogDetail('查看','menuController.do?goLook&MenuId='+ menuId ,500,top.$(window).height() * 0.6);
		}
		function add() {
			openDialog('新增','sys_BaseMenuController.do?goAddorUpdate',500,top.$(window).height() * 0.6);
		}
	</script>
</body>
</html>