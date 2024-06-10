<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thông tin tài khoản</title>
<link href="<c:url value="/resources/css/account.css" />"
	rel="stylesheet">
<base href="${pageContext.servletContext.contextPath}/">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
	<header class="header">
		<div class="container-header">
			<div class="header-iteam">
				<div class="header-logo">
					<a href="activity/activities.htm">ACTIVITY</a>
				</div>
				<div class="header-actions">
					<a href="" class="btntb"><i class="fas fa-bell"></i></a>
					<a href="activity/account.htm" class="btntk"><i class="fa fa-user"></i></a>
				</div>
			</div>
		</div>
	</header>
	<div class="container-body">
		<div class="sider">
			<div id="menu">
				<ul>
					<li><a href="activity/activities.htm" class="home"><i
							class="fas fa-home"></i> Trang chủ</a></li>
					<li><a href="activity/dangky.htm" class="dadky"><i
							class="fas fa-check-square"></i> Đã đăng ký</a></li>
					<li><a href="activity/thamgia.htm" class="thamgia"><i
							class="fas fa-thumbs-up"></i> Đã tham gia</a></li>
					<li><a href="login.htm" class="logout"><i class="fas fa-sign-out"></i>
							Đăng xuất</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="container-item">
				<h2 style="color: #0000a0;display: flex;justify-content: center; align-items: center;padding-bottom: 20px;">Trang tổng quát thông tin tài khoản</h2>
				<div class="card">
					<div class="card-header"><h3>Thông tin tài khoản</h3></div>
					<div class="card-body">
						<div class="anh">
							<img src="">
						</div>
						<div class="thongtin">
		                   	<p>Họ tên: <b></b></p>
		                    <p>Giới tính: <b></b></p>
		                    <p>Ngày sinh: <b></b></p>
		                    <p>Số điện thoại: <b></b></p>
		                    <p>Địa chỉ: <b></b></p>
			                
		                </div>
					</div>
				</div>			
			</div>
		</div>
	</div>
</body>
</html>