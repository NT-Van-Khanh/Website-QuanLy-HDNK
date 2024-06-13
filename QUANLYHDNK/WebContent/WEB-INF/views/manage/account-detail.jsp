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
		
		<form class="form-info" action="manage/account-detail.htm" method="post" enctype="multipart/form-data" modelAttribute="account">
		    <div class="form-title">Thông tin tài khoản</div>
		    <div class="form-frame">
		        <div class="form-info-image">
		            <p><img src="data:image/png;base64,${acc.avatarBase64}" alt="No image" width=350px height=350px></p>
		            <!-- <input type="file" name="avatar" placeholder="Chọn ảnh"> -->
		        </div>
		        <div class="form-info-font">
		            <div class="form-info-content">                
		                <div class="input-field">
		                    <label>Mã số tài khoản:</label><br>
		                    <input type="text" name="userId" placeholder="Nhập mã tài khoản" value="${acc.userId}" readonly>
		                </div>
		                <div class="input-field">
		                    <label>Tên tài khoản:</label><br>
		                    <input type="text" name="userName" placeholder="Nhập tên tài khoản" value="${acc.userName}">
		                </div>
		                <div class="input-field">
		                    <label>Mật khẩu:</label><br>
		                    <input type="password" name="password" placeholder="Nhập mật khẩu" >
		                </div>
		                <div class="input-field">
		                    <label>Quyền:</label><br>
		                    <select name="role">
		                        <option value="SV" ${acc.role.getId() == 'SV' ? 'selected' : ''}>Sinh viên</option>
		                        <option value="ND" ${acc.role.getId() == 'ND' ? 'selected' : ''}>Người đăng</option>
		                        <option value="QL" ${acc.role.getId() == 'QL' ? 'selected' : ''}>Kỹ thuật</option>
		                    </select>
		                </div>
		                <div class="input-field">
		                    <label>Số điện thoại:</label><br>
		                    <input type="text" name="phoneNumber" placeholder="Nhập số điện thoại" value="${acc.phoneNumber}">
		                </div>
		                <div class="input-field">
		                    <label>Email:</label><br>
		                    <input type="email" name="email" placeholder="Nhập email" value="${acc.email}">
		                </div>
		                <div class="input-field">
		                    <label>Ngày sinh/ngày thành lập:</label><br>
		                    <input type="date" name="birthday" placeholder="Chọn ngày" value="${acc.birthday}">
		                </div>
		                <div class="input-field">
		                    <label>Giới tính:</label><br>
		                    <input type="radio" name="gender" value="true" ${acc.gender == true ? 'checked' : ''}>Nam
		                    <input type="radio" name="gender" value="false" ${acc.gender == false ? 'checked' : ''}>Nữ
		                    <input type="radio" name="gender" value="" ${acc.gender == null ? 'checked' : ''}>Khác
		                </div>
		            </div>
		            <div class="input-field">
		                <label>Địa chỉ:</label><br>
		                <input id="AR" type="text" name="address" placeholder="Nhập địa chỉ" value="${acc.address}">
		            </div>
		            <button type="submit" name="bthUpdateAccount">Cập nhật thông tin</button>
		        </div>
		    </div>
		</form>
		</div>
</body>
</html>
