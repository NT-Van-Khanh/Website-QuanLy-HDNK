<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Quản lý tài khoản</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	<link href="<c:url value="/resources/css/manage.css" />" rel="stylesheet">	
	<base href = "${pageContext.servletContext.contextPath}/"> 
</head>
<body>
	<header>
		<label>Hoạt động ngoại khóa</label>
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
				<div>
					<input type="text" name="search" placeholder="Tìm kiếm">
					<button class="btnSearch-form" name="btnSearch"> <i class="fa fa-search" style="font-size:18px"></i> </button>
					<button class="btnAddAccount-form" name="btnSearch">Thêm tài khoản</button>	
				</div>	
				<div>		
					Lọc: <select name="fill">
						<option value="0">Tất cả</option>
						<option value="1">Kỹ thuật viên</option>
						<option value="2">Người đăng</option>
						<option value="3">Sinh viên</option>
					</select>
					Sắp xếp theo: <select name="sort">
						<option value="0">Mã tài khoản</option>
						<option value="1">Tên tài khoản</option>
						<option value="2">Ngày tạo</option>
						<option value="3">Mã tài khoản</option>
					</select>
				</div>
				
			</div>
			<table class="table-account">
				<tr>
					<th>STT</th>
					<th>Mã số tài khoản</th>
					<th>Tên tài khoản</th>
					<th>Email</th>
					<th>Số điện thoại</th>
					<th>Ngày sinh</th>
					<th>Giới tính</th>
					<th>Địa chỉ</th>
					<th>Ngày tạo</th>
					<th>Quyền</th>
			<!-- 		<th>Anh</th> -->
				</tr>
				<c:set var="counter" value="1" />
				<c:forEach var="acc" items ="${accounts}">
						<tr>
							<td>${counter}</td>
							<td>${acc.userId}</td>
							<td>${acc.userName}</td>
							<td>${acc.email}</td>
							<td>${acc.phoneNumber}</td>
							<td>${acc.birthday}</td>
							<td>${acc.gender}</td>
							<td>${acc.address}</td>
							<td>${acc.createDate}</td>
							<td>${acc.role.getNameRole()}</td>
							<%-- <td><img src="data:image/png;base64,${acc.avatarBase64}" alt="No image"></td> --%>
						</tr>
						<c:set var="counter" value="${counter + 1}"/>
					</c:forEach>  
			</table>
		</div>
</body>
</html>