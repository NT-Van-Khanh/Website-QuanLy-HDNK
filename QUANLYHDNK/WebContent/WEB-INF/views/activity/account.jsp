<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<a href="activity/thongbao.htm" class="btntb"><i class="fas fa-bell"></i></a>
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
				<div class="form-frame">
			        <div class="form-info-image">
			            <!-- <p><img src="${avartar}" alt="No Image"></p> -->
			            <!-- <input type="file" name="avatar" placeholder="Chọn ảnh"> -->
			        </div>
			        <div class="form-info-font">
			            <div class="form-info-content">                
			                <div class="input-field">
			                    <div>Mã tài khoản: <b>${account.userId}</b> </div> <br>
			                </div>
			                <div class="input-field">
			                    <div>Tên tài khoản: <b>${account.userName}</b> </div> <br>
			                </div>
			                <div class="input-field">
			                    <div>Số điện thoại: <b>${account.phoneNumber}</b> </div> <br>
			                </div>
			                <div class="input-field">
			                    <div>Email: <b>${account.email}</b> </div><br>
			                </div>
			                <div class="input-field">
			                    <label>Ngày sinh: <b>${account.birthday}</b> </label><br>
			                </div>
			                <br>
			                <div class="input-field">
			                    <div>Giới tính: <b>
				                    <c:choose>
								        <c:when test="${account.gender == true}">
								            Nam
								        </c:when>
								        <c:otherwise>
								            Nữ
								        </c:otherwise>
								    </c:choose> </b>
								</div><br>
			                </div>
			            </div>
			            <div class="input-field">
			                <div>Địa chỉ: <b>${account.address}</b> </div><br>
			            </div>
			        </div>
			    </div>			
			</div>
		</div>
	</div>
</body>
</html>