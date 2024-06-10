<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Đã đăng ký</title>
	<link href="<c:url value="/resources/css/dadangky.css" />" rel="stylesheet">
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
						<a href="login.htm" class="logout"><i class="fas fa-sign-out"></i> Đăng xuất</a>
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
				        </select>
				</div>
				<c:forEach var="r" items = "${registers}">
					<div class="dshoatdong">
				    	<div class="tthoatdong">
				    		<div class="hoatdong">
							    <div class="khung1">
						 			<div class="images"><img src="${r.activityRegis.getAvatar()}"></div>
						 		</div>
							    <div class="dangky"><button class="btnhuydk">Hủy đăng ký</button></div>
							</div>
							<div class="chitiet">
								<div class="p1">
							        <div class="ten"><h3>${r.activityRegis.getNameActivity()}</h3></div>
							       	<div class="post"><b>Người đăng:</b> ${r.activityRegis.getPosterActi().getUserName()}</div>
							        <div class="theloai"><b>Thể loại:</b> ${r.activityRegis.getTitle().getNameTitle()}</div>
							        <div class="thoigian"><b>Thời gian đăng ký:</b> ${r.activityRegis.getStartTime()} đến ${r.activityRegis.getEndTime()}</div>
							        <div class="diadiem"><b>Địa điểm:</b> ${r.activityRegis.getAddress()}</div>
							        <div class="noidung"><b>Nội dung:</b> ${r.activityRegis.getContentActivity()}</div>
							    </div>
							    <div class="p2">
							        <div class="soluong">Số lượng còn lại: ${r.activityRegis.getQuantity()}</div>
							        <div class="timepost">Đăng lúc: ${r.activityRegis.getPostTime()}</div>
							    </div>
							</div>
				    	</div>  	
					</div>
				</c:forEach>
				<div class="thongbao"><b>${message}</b></div>
			</div>    
		</div>
    </div>
</body>
</html>