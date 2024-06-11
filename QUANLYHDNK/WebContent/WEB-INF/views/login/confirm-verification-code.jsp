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
	<form action="confirm-verification-code.htm" method ="post" enctype="multipart/form-data" class="login-form" >
	 	<p class="tilte">Verification Code</p>
	 	<p class="text-name">Nhập mã xác nhận</p> 
	 	<input type="text" name= "code" placeholder="Vui lòng nhập code"> <br>
	 	<p class="error">${message}</p>
	 	<button name="Confirm">Xác nhận</button>
	 	<br>
	 	<a href="<c:url value='/login.htm'/>" class="forgotPassword">Quay lại</a>
	</form>	
</body>