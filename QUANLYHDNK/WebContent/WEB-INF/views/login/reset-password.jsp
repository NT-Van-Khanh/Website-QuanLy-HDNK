<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Đăng nhập</title>
	<link href="<c:url value="/resources/css/login2.css" />" rel="stylesheet">
</head>
<body>
	<h1 class="schoolName"> Welcome to PTIT HCM </h1>
	<h2 class="webName"> Hoạt động ngoại khóa</h2>
	<form action="reset-password.htm" method ="post" enctype="multipart/form-data" class="login-form" >
	 	<p class="tilte">Reset Password</p>
	 	<p class="text-name">Mật khẩu</p> 
	 	<input type="password" name= "new-password" placeholder="Nhập mật khẩu mới"> <br>
	 	<p class="text-name">Xác nhận lại mật khẩu</p>  
	 	<input type="password" name= "confirm-password"  placeholder="Nhập lại mật khẩu"> <br>
	 	<p class="error">${message}</p>
	 	<button name="Confirm">Xác nhận</button>
	 	<br>
	 	<a href="<c:url value='/login.htm'/>" class="forgotPassword">Quay lại</a>
	</form>	
</body>