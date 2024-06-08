<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8">
	<title>Quản lý tài khoản</title>
	<link href="<c:url value="/resources/css/manage.css" />" rel="stylesheet">
	<base href = "${pageContext.servletContext.contextPath}/"> 
</head>
<body>
	<header>
		<label>Hoạt động ngoại khóa</label>
		<a id="avatar" href="manage/activityManage.htm">Avatar</a>
		<a id="logout" href="manage/activityManage.htm">Đăng xuất</a>
	</header>
 	<nav id="menu"> 
 		<ul>
			<li>
				<a href="manage/accountManage.htm">Quản lý tài khoản </a>
			</li>
			<li>
				<a href="manage/activityManage.htm">Quản lý hoạt động </a>
			</li>
		</ul> 
	</nav>
<!-- 	<div class="container"> -->
		<div class="main">
			<div class="table-tool"> 
			<input type="text" name="search" placeholder="Tìm kiếm">
			<button class="btnSearch-form" name="btnSearch"> a  </button>
			<button class="btnAddAccount-form" name="btnSearch">Thêm tài khoản</button>
			</div>
					
		</div>
<!-- 	</div> -->
	
</body>