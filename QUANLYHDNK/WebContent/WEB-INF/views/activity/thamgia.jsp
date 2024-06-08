<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Đã tham gia</title>
	<link href="<c:url value="/resources/css/dathamgia.css" />" rel="stylesheet">
	<base href = "${pageContext.servletContext.contextPath}/">
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
                    <a href="#" class="btntk">Tài khoản</a>
                </div>
            </div>
        </div>
    </header>
    <div class="container-body">
    	<div class="sider">
    		<div id="menu"> 
		 		<ul>
		 			<li>
		 				<a href="activity/activities.htm" class="home"><i class="fas fa-home"></i> Trang chủ</a>
		 			</li>
					<li>
						<a href="activity/dangky.htm" class="dadky"><i class="fas fa-check-square"></i> Đã đăng ký</a>
					</li>
					<li>
						<a href="activity/thamgia.htm" class="thamgia"><i class="fas fa-thumbs-up"></i> Đã tham gia</a>
					</li>
					<li>
						<a href="" class="logout"><i class="fas fa-sign-out"></i> Đăng xuất</a>
					</li>
				</ul>
	    	</div>
		</div>
		<div class="main">
			<div>
				<h2>CÁC HOẠT ĐỘNG ĐÃ THAM GIA</h2>
			</div>
			<div class="container-item">
			    <div class="filter-dropdown">
					<label for="hd-filter">Sắp xếp theo:</label>
				    	<select id="hd-filter">
				        	<option value="all">Tất cả</option>
				        	<option value="theoten">Theo tên</option>
				        	<option value="theongay">Theo ngày</option>
				        </select>
				</div>   	
			    <div class="dshoatdong">
			    	<div class="tthoatdong">
			    		<div class="hoatdong">
						    <div class="khung1">
					 			<div class="images"><img src="images/ptithcm.png"></div>
					 		</div>
						    <div class="btntg">
						    	<button class="btnthamgia">Đã tham gia</button>
						    	<span class="tooltip">Bạn đã tham gia</span>
						    </div>
						</div>
						<div class="chitiet">
							<div class="p1">
						        <div class="ten"><h3>Chào hè 2024</h3></div>
						       	<div class="post">Người đăng: Thư ký CLB B1</div>
						        <div class="theloai">Thể loại: Tình nguyện</div>
						        <div class="thoigian">Diễn ra từ: 1/7/2024 đến 7/7/2024</div>
						        <div class="noidung">Phong trào trồng cây xanh, vệ sinh đường phố</div>
						    </div>
						</div>
			    	</div>  
			    	<div class="tthoatdong">
			    		<div class="hoatdong">
						    <div class="khung1">
					 			<div class="images"><img src="images/ptithcm.png"></div>
					 		</div>
						    <div class="btntg">
						    	<button class="btnthamgia">Đã tham gia</button>
						    	<span class="tooltip">Bạn đã tham gia</span>
						    </div>
						</div>
						<div class="chitiet">
							<div class="p1">
						        <div class="ten"><h3>Chào hè 2024</h3></div>
						       	<div class="post">Người đăng: Thư ký CLB B1</div>
						        <div class="theloai">Thể loại: Tình nguyện</div>
						        <div class="thoigian">Diễn ra từ: 1/7/2024 đến 7/7/2024</div>
						        <div class="noidung">Phong trào trồng cây xanh, vệ sinh đường phố</div>
						    </div>
						</div>
			    	</div>  
			    	<div class="tthoatdong">
			    		<div class="hoatdong">
						    <div class="khung1">
					 			<div class="images"><img src="images/ptithcm.png"></div>
					 		</div>
						    <div class="btntg">
						    	<button class="btnthamgia">Đã tham gia</button>
						    	<span class="tooltip">Bạn đã tham gia</span>
						    </div>
						</div>
						<div class="chitiet">
							<div class="p1">
						        <div class="ten"><h3>Chào hè 2024</h3></div>
						       	<div class="post">Người đăng: Thư ký CLB B1</div>
						        <div class="theloai">Thể loại: Tình nguyện</div>
						        <div class="thoigian">Diễn ra từ: 1/7/2024 đến 7/7/2024</div>
						        <div class="noidung">Phong trào trồng cây xanh, vệ sinh đường phố</div>
						    </div>
						</div>
			    	</div>  	
				</div>
			</div>    
		</div>
    </div>
</body>
</html>