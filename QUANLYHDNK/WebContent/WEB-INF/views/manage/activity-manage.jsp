<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Quản lý hoạt động</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	
	<link href="<c:url value="/resources/css/m7.css" />" rel="stylesheet">	
	<base href = "${pageContext.servletContext.contextPath}/"> 
</head>
<body>
	<header>
		<label><a href="manage/account-manage.htm" class="titleWeb">Hoạt động ngoại khóa</a></label>
		<a id="avatar" href="manage/activity-manage.htm">Avatar</a>
		<a id="logout" href="manage/logout.htm">Đăng xuất</a>
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
				<div>
					<input type="text" name="search" placeholder="Tìm kiếm">
					<button class="btnSearch-form" name="btnSearch"> <i class="fa fa-search" style="font-size:18px"></i> </button>
				</div>	
				<form action="manage/activity-manage.htm" method ="post">
					Sắp xếp theo: <select name="sort-activities" onchange="this.form.submit()">
						<option value="id" selected="selected">Mã hoạt động</option>
						<option value="name">Tên hoạt động</option>
						<option value="create-date">Ngày đăng</option>
						<option value="start-date">Ngày bắt đầu</option>
						<option value="end-date">Ngày kết thúc</option>
					</select>
				</form>
			</div>
			<table class="table-account">
				<tr>
					<th>STT</th>
					<th>Mã hoạt động</th>
					<th>Tên hoạt động</th>
					<th>Người đăng</th>
					<th>Thể loại</th>
					<th>Bắt đầu đăng ký</th>
					<th>Kết thúc đăng ký</th>
					<th>Địa điểm tổ chức</th>
					<th>Nội dung</th>
					<th>Số lượng đăng ký</th>
					<th>Đăng lúc</th>
			<!-- 		<th>Anh</th> -->
				</tr>
 				<c:set var="counter" value="1" />
				<c:forEach var="acti" items ="${activities}">
					<%-- <tr onclick="window.location.href='manage/activity-detail.htm?id=${acti.idActivity}'"> --%>
						<tr>
							<td>${counter}</td>
							<td>${acti.idActivity}</td>
							<td>${acti.nameActivity}</td>
							<td>${acti.posterActi.getUserName()}</td>
							<td>${acti.title.getIdTitle()}</td>
							<td>${acti.startTime}</td>
							<td>${acti.endTime}</td>
							<td>${acti.address}</td>
							<td>${acti.contentActivity}</td>
							<td>${acti.quantity}</td>
							<td>${acti.postTime}</td>
						</tr>
						<c:set var="counter" value="${counter + 1}"/>
					</c:forEach>   
			</table>
							
		</div>
<!-- 	</div> -->
</body>