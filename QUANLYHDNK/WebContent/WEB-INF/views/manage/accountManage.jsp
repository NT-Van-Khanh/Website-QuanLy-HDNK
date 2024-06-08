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
					<th>Ngày tạo tài khoản</th>
					<th>Quyền</th>
				</tr>
					<tr>
						<td>Test1</td>
						<td>Test1</td>
						<td>Test1</td>
						<td>Test1</td>
						<td>Test1</td>
						<td>Test1</td>
						
					</tr>
			
						<%-- 		<c:forEach var="p" items ="${prods}">
						<td>${p.name}</td>
										<td><f:formatNumber value="${p.newPrice}" type="currency"/></td>
										<td><f:formatNumber value="${p.discount}" type="percent"/></td>
										<td><f:formatNumber value="${p.untiPrice}" type="currency"/></td>
								</c:forEach> --%>
			</table>
		</div>

<!-- 	</div> -->
</body>
</html>