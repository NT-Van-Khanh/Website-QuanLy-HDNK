<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Đăng bài</title>
	<link href="<c:url value="/resources/css/edit-activity.css" />" rel="stylesheet">
	<base href = "${pageContext.servletContext.contextPath}/">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	</head>
<body>
	<header class="header">
        <div class="container-header">
            <div class="header-iteam">
                <div class="header-logo">
                    <a href="nguoidang/dangdienra.htm">ACTIVITY</a>
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
					<li><a href="nguoidang/dangdienra.htm" class="dangdienra"><i
							class="fas fa-home"></i> Đang diễn ra</a></li>
					<li><a href="nguoidang/dadang.htm" class="dadang"><i
							class="fas fa-check-square"></i> Bài đã đăng</a></li>
					<li><a href="nguoidang/dangbai.htm" class="dangbai"><i
							class="fas fa-thumbs-up"></i> Đăng bài</a></li>
					<li><a href="" class="logout"><i class="fas fa-sign-out"></i>
							Đăng xuất</a></li>
				</ul>
			</div>
<!--     		<div id="menu"> 
		 		<ul>
		 			<li>
		 				<a href="nguoidang/dangdienra.htm" class="dangdienra"><i class="fas fa-home"></i> Đang diễn ra</a>
		 			</li>
					<li>
						<a href="nguoidang/dadang.htm" class="dadang"><i class="fas fa-check-square"></i> Bài đã đăng</a>
					</li>
					<li>
						<a href="nguoidang/dangbai.htm" class="dangbai"><i class="fas fa-thumbs-up"></i> Đăng bài</a>
					</li>
					<li>
						<a href="" class="logout"><i class="fas fa-sign-out"></i> Đăng xuất</a>
					</li>
				</ul>
	    	</div> -->
		</div>
		<div class="main">
			<div>
				<h2>ĐĂNG BÀI HOẠT ĐỘNG</h2>
			</div>   
				<!-- Form đăng bài hoạt động bắt đầu từ đây -->
		<div class="main-content">
			<form action="nguoidang/edit-activity.htm" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="title">Mã hoạt động:</label>
					<input type="text" id="title" name="id-activity" value="${activity.idActivity}" readonly>
				</div>
				<div class="form-group">
					<label for="title">Tiêu đề:</label>
					<input type="text" id="title" name="name-activity" placeholder="Nhập tiêu đề hoạt động" required value="${activity.nameActivity}">
				</div>
				<div class="form-group">
				  <label for="category">Chọn thể loại hoạt động:</label>
				  <select id="category" name="title">
				    <option value="DH">Đoàn hội</option>
				    <option value="HN">Hướng nghiệp</option>
				    <option value="KH">Khóa học</option>
				    <option value="LB">Câu lạc bộ</option>
				    <option value="NC">Nghiên cứu</option>
				    <option value="SK">Sự kiện</option>
				    <option value="TN">Tình nghuyện</option>
				  </select>
				  <br><br>
				</div>

				<div class="form-group">
					<label for="time">Mở đăng ký:</label>
					<input type="datetime-local" id="time" name="start-time" required value="${activity.startTime}">
				</div>
				<div class="form-group">
					<label for="time">Kết thúc đăng ký:</label>
					<input type="datetime-local" id="time" name="end-time"required value="${activity.endTime}">
				</div>
				<div class="form-group">
					<label for="content">Nội dung:</label>
					<textarea id="content" name="content-activity" placeholder="Nội dung hoạt động" required>${activity.contentActivity}</textarea>
				</div>

				<div class="form-group">
					<label for="slots">Số lượng:</label>
					<input type="text" id="slots" name="quantity" placeholder="Số lượng tham gia (VD: 100/100)" required value="${activity.quantity}">
				</div>

				<div class="form-group">
<!-- 					<label for="image">Hình ảnh:</label>
					<input type="file" id="image" name="avatar" accept="image/*"> -->
				</div>
				<div class="form-group">
					<label for="address">Địa điểm tổ chức:</label>
					<input type="text" id="address" name="address" placeholder="Nhập địa chỉ" value="${activity.address}">
				</div>
				<div class="thongbao"><b>${message}</b></div>
				<div class="form-group">
					<button type="submit">Cập nhật</button>
				</div>
			</form>
		</div>
	</div>
	<script>
		// Đặt giá trị mặc định cho thời gian đăng là thời gian hiện tại
		document.getElementById('postTime').value = new Date().toLocaleString();
	</script>
					
		</div>
   
</body>
</html>