<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Các hoạt động</title>
<link href="<c:url value="/resources/css/activities.css" />"
	rel="stylesheet">
<base href="${pageContext.servletContext.contextPath}/">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
	<header class="header">
		<div class="container-header">
			<div class="header-iteam">
				<div class="header-logo">
					<a href="activity/activities.htm">ACTIVITY</a>
				</div>
				<div class="header-actions">
					<a href="" class="btntk">Tài khoản</a>
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
					<li><a href="" class="logout"><i class="fas fa-sign-out"></i>
							Đăng xuất</a></li>
				</ul>
			</div>
		</div>
		<div class="main">
			<div>
				<h2>CÁC HOẠT ĐỘNG NGOẠI KHÓA</h2>
			</div>
			<div class="container-item">
				<div class="body-search">
					<div class="search-container">
						<div class="search-item">
							<i class="fas fa-search"></i> <input type="text"
								class="search-input" placeholder="Hoạt động">
							<div class="filter-dropdown">
								<label for="hd-filter">Loại hoạt động:</label> <select
									id="hd-filter">
									<option value="all">Tất cả</option>
									<option value="tinhnguyen">Tình nguyện</option>
									<option value="hoctap">Học tập</option>
								</select>
							</div>
							<button class="search-button">Tìm kiếm</button>
						</div>
					</div>
				</div>

				<div class="dshoatdong">
					<div class="tthoatdong">
						<div class="hoatdong">
							<div class="khung1">
								<div class="images">
									<img src="images/bvmt.jpg" alt="Image">
								</div>
							</div>
							<div class="dangky">
								<form action="/QUANLYHDNK/activity/dangky.htm" method="POST">
									<input type="hidden" name="title" value="Mùa hè xanh">
									<input type="hidden" name="poster" value="Đoàn thanh niên">
									<input type="hidden" name="category" value="Tình nguyện">
									<input type="hidden" name="time" value="1/7/2024 đến 7/7/2024">
									<input type="hidden" name="content"
										value="Phong trào trồng cây xanh, vệ sinh đường phố, tuyên truyền">
									<input type="hidden" name="slots" value="100/100"> <input
										type="hidden" name="postTime" value="22:42 25/6/2024">
									<input type="hidden" name="imageUrl"
										value="images/bvmt.jpg">
									<button type="submit" class="btndangky">Đăng ký</button>
								</form>
							</div>
						</div>
						<div class="chitiet">
							<div class="p1">
								<div class="ten">
									<h3>Mùa hè xanh</h3>
								</div>
								<div class="post">Người đăng: Đoàn thanh niên</div>
								<div class="theloai">Thể loại: Tình nguyện</div>
								<div class="thoigian">Diễn ra từ: 1/7/2024 đến 7/7/2024</div>
								<div class="noidung">Phong trào trồng cây xanh, vệ sinh đường phố, tuyên truyền</div>
							</div>
							<div class="p2">
								<div class="soluong">Số lượng còn lại: 100/100</div>
								<div class="timepost">Đăng lúc: 22:42 25/6/2024</div>
							</div>
						</div>
					</div>
					
					<div class="tthoatdong">
						<div class="hoatdong">
							<div class="khung1">
								<div class="images">
									<img src="images/trongcay.png" alt="Image">
								</div>
							</div>
							<div class="dangky">
								<form action="/QUANLYHDNK/activity/dangky.htm" method="POST">
									<input type="hidden" name="title" value="Chào hè 2024">
									<input type="hidden" name="poster" value="Thư ký CLB B1">
									<input type="hidden" name="category" value="Tình nguyện">
									<input type="hidden" name="time" value="1/7/2024 đến 7/7/2024">
									<input type="hidden" name="content"
										value="Phong trào trồng cây xanh, vệ sinh đường phố">
									<input type="hidden" name="slots" value="100/100"> <input
										type="hidden" name="postTime" value="22:42 25/6/2024">
									<input type="hidden" name="imageUrl"
										value="images/trongcay.png">
									<button type="submit" class="btndangky">Đăng ký</button>
								</form>
							</div>
						</div>
						<div class="chitiet">
							<div class="p1">
								<div class="ten">
									<h3>Chào hè 2024</h3>
								</div>
								<div class="post">Người đăng: Thư ký CLB B1</div>
								<div class="theloai">Thể loại: Tình nguyện</div>
								<div class="thoigian">Diễn ra từ: 1/7/2024 đến 7/7/2024</div>
								<div class="noidung">Phong trào trồng cây xanh, vệ sinh đường phố</div>
							</div>
							<div class="p2">
								<div class="soluong">Số lượng còn lại: 100/100</div>
								<div class="timepost">Đăng lúc: 22:42 25/6/2024</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>