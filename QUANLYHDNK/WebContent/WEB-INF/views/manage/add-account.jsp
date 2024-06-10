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
		<div class="main">
		
		<form class="form-info" action="">
			<div id="form-info-image">
				<p><img src="${avartar}" alt="No Image" style="width:auto;"></p>
				<input type="file" name="avatar" placeholder="Chọn ảnh"> 
			</div>
			<div id="form-info-content">	
				<div id="form-title">Thêm tài khoản</div>
					<div>
						<label class="title-of-input">Mã số tài khoản:</label> <input type="text" name="userId" placeholder="Nhập mã tài khoản"> 
						<label class="title-of-input">Tên tài khoản: </label><input type="text" name="userName" placeholder="Nhập tên tài khoản"> 
					</div>	
					<div>	
						Mật khẩu: <input type="password" name="password" placeholder="Nhập mật khẩu"> 
						Quyền: <input type="text" name="role" placeholder="Nhập tài khoản">
					</div>
					<div>
						Số điện thoại: <input type="text" name="phoneNumber" placeholder="Nhập số điện thoại"> 
						Email: <input type="email" name="email" placeholder="Nhập email">
					</div>
					<div>
						Ngày sinh/ngày thành lập: <input type="date" name="birthday" placeholder="Chọn ngày"> 
						Giới tính:
							  <input type="radio" name="gender" value="male">Nam
							  <input type="radio" name="gender" value="female">Nữ
							  <input type="radio" name="gender" value="another"><label for="another">Khác</label>
					</div>
					<div>
						Địa chỉ : <input type="text" name="userId" placeholder="Nhập địa chỉ"> <br>			
					</div>
					<div><button name="bthInsertAccount">Thêm tài khoản</button></div>
			</div>
		</form>
		</div>
</body>
</html>
