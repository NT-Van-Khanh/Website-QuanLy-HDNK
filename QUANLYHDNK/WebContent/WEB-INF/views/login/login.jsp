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
	<form action="login.htm" method ="post" enctype="multipart/form-data" class="login-form" >
	 	<p class="tilte">Login</p>
	 	<p class="text-name">Tài khoản</p> 
	 	<input type="text" name= "username" placeholder="Nhập tài khoản"> <br>
	 	<p class="text-name">Mật khẩu</p>  
	 	<input type="password" name= "password" placeholder="Nhập mật khẩu"> <br>
	 	<p class="error">${message}</p>
	 	<button name="SignIn">Đăng nhập</button>
	 	<br>
	 	<a href="login/forgot-password.htm" class="forgotPassword">Quên mật khẩu?</a>
	</form>	
</body>