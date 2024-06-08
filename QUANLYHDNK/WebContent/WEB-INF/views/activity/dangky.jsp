<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Đã đăng ký</title>
	<link href="<c:url value="/resources/css/dangky.css" />" rel="stylesheet">
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
				<h2>CÁC HOẠT ĐỘNG ĐÃ ĐĂNG KÝ</h2>
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
					 			<div class="images"><img src="${param.imageUrl}" alt="Activity Image"></div>
					 		</div>
						    <div class="dangky"><button class="btnhuydk">Hủy đăng ký</button></div>
						</div>
						<div class="chitiet">
							<div class="p1">
						        <div class="ten"><h3>${param.title}</h3></div>
						       	<div class="post">Người đăng: ${param.poster}</div>
						        <div class="theloai">Thể loại: ${param.category}</div>
						        <div class="thoigian">Diễn ra từ: ${param.time}</div>
						        <div class="noidung">${param.content}</div>
						    </div>
						    <div class="p2">
						        <div class="soluong">Số lượng còn lại: ${param.slots}</div>
						        <div class="timepost">Đăng lúc: ${param.postTime}</div>
						    </div>
						</div>
			    	</div>  	
				</div>
			</div>    
		</div>
    </div>
</body>
</html>