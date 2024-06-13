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
		
		<form class="form-info" action="manage/add-account.htm" method="post" enctype="multipart/form-data">
		    <div class="form-title">Thêm tài khoản</div>
		    <div class="form-frame">
		        <div class="form-info-image">
		        	<img id="blah" alt="your image" width=350px height=350px style="display:none;"/>
                    <input type="file" name="avatar" 
                        onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0]); 
                        		document.getElementById('blah').style.display = 'block';">
		            <!-- <p><img src="${avartar}" alt="No Image"></p> -->
<!-- 		            <input type="file" name="avatar" placeholder="Chọn ảnh" onchange="loadFile(event)">  -->
		        </div>
		        <div class="form-info-font">
		            <div class="form-info-content">                
		                <div class="input-field">
		                    <label>Mã số tài khoản:</label><br>
		                    <input type="text" name="userId" placeholder="Nhập mã tài khoản"  required>
		                </div>
		                <div class="input-field">
		                    <label>Tên tài khoản:</label><br>
		                    <input type="text" name="userName" placeholder="Nhập tên tài khoản"  required>
		                </div>
		                <div class="input-field">
		                    <label>Mật khẩu:</label><br>
		                    <input type="password" name="password" placeholder="Nhập mật khẩu"  required>
		                </div>
		                <div class="input-field">
		                    <label>Quyền:</label><br>
		                    <select name="role">
		                        <option value="SV" selected>Sinh viên</option>
		                        <option value="ND">Người đăng</option>
		                        <option value="QL">Kỹ thuật</option>
		                    </select>
		                </div>
		                <div class="input-field">
		                    <label>Số điện thoại:</label><br>
		                    <input type="text" name="phoneNumber" placeholder="Nhập số điện thoại"  required>
		                </div>
		                <div class="input-field">
		                    <label>Email:</label><br>
		                    <input type="email" name="email" placeholder="Nhập email"  required>
		                </div>
		                <div class="input-field">
		                    <label>Ngày sinh/ngày thành lập:</label><br>
		                    <input type="date" name="birthday" placeholder="Chọn ngày"  required>
		                </div>
		                <div class="input-field">
		                    <label>Giới tính:</label><br>
		                    <input type="radio" name="gender" value="true" checked>Nam
		                    <input type="radio" name="gender" value="false">Nữ
		                    <input type="radio" name="gender" value="">Khác
		                </div>
		            </div>
		            <div class="input-field">
		                <label>Địa chỉ:</label><br>
		                <input id="AR" type="text" name="address" placeholder="Nhập địa chỉ">
		            </div>
		            <button type="submit" name="bthInsertAccount">Thêm tài khoản</button> 
		        </div>
		    </div>
		    ${message}
		</form>
	</div>
    <script>
        document.getElementById('avatarInput').addEventListener('change', function(event) {
            const file = event.target.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function(e) {
                    const preview = document.getElementById('preview');
                    preview.src = e.target.result;
                    preview.style.display = 'block';
                };
                reader.readAsDataURL(file);
            }
        });
    </script>	
</body>
</html>
