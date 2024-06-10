<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Quản lý hoạt động</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	
	<link href="<c:url value="/resources/css/manage.css" />" rel="stylesheet">	
	<base href = "${pageContext.servletContext.contextPath}/"> 
</head>
<body>
	<header>
		<label><a href="manage/account-manage.htm" class="titleWeb">Hoạt động ngoại khóa</a></label>
		<a id="avatar" href="manage/activity-manage.htm">Avatar</a>
		<a id="logout" href="login.htm">Đăng xuất</a>
	</header>
 	<nav id="menu"> 
 		<ul>
			<li>
				<a href="manage/account-manage.htm">Quản lý tài khoản </a>
			</li>
			<li>
				<a href="manage/activity-manage.htm">Quản lý hoạt động </a>
			</li>
		</ul> 
	</nav>
<!-- 	<div class="container"> -->
		<div class="main">
			<div class="table-tool"> 
			<input type="text" name="search" placeholder="Tìm kiếm">
			<button class="btnSearch-form" name="btnSearch"> <i class="fa fa-search" style="font-size:18px"></i> </button>
			<button class="btnAddAccount-form" name="btnSearch">Thêm tài khoản</button>
			</div>				
		</div>
<!-- 	</div> -->
</body>