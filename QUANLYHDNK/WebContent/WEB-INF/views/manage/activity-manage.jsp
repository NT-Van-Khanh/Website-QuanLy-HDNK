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
				<form action="manage/account-manage.htm" method ="post">
<!-- 					Lọc: <select name="fill" onchange="this.form.submit()">
						<option value="ALL" selected="selected">Tất cả</option>
						<option value="QL">Kỹ thuật viên</option>
						<option value="ND">Người đăng</option>
						<option value="SV">Sinh viên</option>
					</select> -->
					Sắp xếp theo: <select name="sort" onchange="this.form.submit()">
						<option value="id" selected="selected">Mã tài khoản</option>
						<option value="name">Tên tài khoản</option>
						<option value="create-date">Ngày tạo</option>
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