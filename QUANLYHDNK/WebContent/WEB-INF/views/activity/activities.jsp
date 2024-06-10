<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Các hoạt động</title>
<link href="<c:url value="/resources/css/activities.css" />"
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
			<div>
				<h2>CÁC HOẠT ĐỘNG NGOẠI KHÓA</h2>
			</div>
			<div class="container-item">
				<div class="body-search">
					<div class="search-container">
						<div class="search-item">
							<i class="fas fa-search"></i> 
							<input type="text" class="search-input" placeholder="Hoạt động">
							<div class="filter-dropdown">
								<label for="hd-filter">Loại hoạt động:</label> <select
									id="hd-filter">
									<option value="all">Tất cả</option>
									<c:forEach var="t" items="${titles}">
										<option value="${t.idTitle}">${t.nameTitle}</option>
									</c:forEach>
								</select>
							</div>
							<button class="search-button">Tìm kiếm</button>
						</div>
					</div>
				</div>
				<c:forEach var="a" items ="${activities}">
					<div class="dshoatdong" data-title-id="${a.title.getIdTitle()}">
						<div class="tthoatdong">
							<div class="hoatdong">
								<div class="khung1">
									<div class="images">
										<img src="${a.avatar}">
									</div>
								</div>
								<div class="dangky">
									<form action="<c:url value='/activity/dangky.htm'/>" method="POST">
										<input type="hidden" name="title" value="${a.nameActivity}">
										<input type="hidden" name="poster" value="${a.posterActi.getUserName()}">
										<input type="hidden" name="category" value="${a.title.getNameTitle()}">
										<input type="hidden" name="time" value="<fmt:formatDate value='${a.startTime}' pattern='yyyy-MM-dd HH:mm:ss'/> đến <fmt:formatDate value='${a.endTime}' pattern='yyyy-MM-dd HH:mm:ss'/>">
										<input type="hidden" name="address" value="${a.address}">
										<input type="hidden" name="content" value="${a.contentActivity}">
										<input type="hidden" name="slots" value="${a.quantity}"> <input
											type="hidden" name="postTime" value="${a.postTime}">
										<input type="hidden" name="imageUrl" value="${a.avatar}">
										<button type="submit" class="btndangky ignore-click" ${a.quantity == 0 ? 'disabled' : ''} ${a.quantity == 0 ? 'style="opacity: 0.5; cursor: not-allowed;"' : ''}>Đăng ký</button>
									</form>
								</div>
							</div>
							<div class="chitiet">
								<div class="p1">
									<div class="ten">
										<h3>${a.nameActivity}</h3>
									</div>
									<div class="post"><b>Người đăng:</b> ${a.posterActi.getUserName()}</div>
									<div class="theloai"><b>Thể loại:</b> ${a.title.getNameTitle()}</div>
									<div class="thoigian"><b>Thời gian đăng ký:</b> ${a.startTime} đến ${a.endTime}</div>
									<div class="diadiem"><b>Địa điểm:</b> ${a.address}</div>
									<div class="noidung"><b>Nội dung:</b> ${a.contentActivity}</div>
								</div>
								<div class="p2">
									<div class="soluong"><b>Số lượng còn lại:</b> ${a.quantity}</div>
									<div class="timepost"><b>Đăng lúc:</b> ${a.postTime}</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="thongbao"><b>${message}</b></div>				
			</div>
		</div>
	</div>
	<div id="activityModal" class="modal">
	    <div class="modal-content">
	        <span class="close-button">&times;</span>
	        <h3 class="tieude">Chi tiết thông tin hoạt động</h3>
	        <div class="modal-body">
	            <!-- Nội dung chi tiết của hoạt động -->
	        </div>
	    </div>
	</div>
	<script>
		document.querySelector('.search-button').addEventListener('click', function() {
		    // Lấy giá trị tìm kiếm và loại bỏ khoảng trắng, chuyển đổi thành chữ thường
		    var searchValue = document.querySelector('.search-input').value.replace(/\s+/g, ' ').trim().toLowerCase();
		    var searchTerms = searchValue.split(' ');
		    var selectedValue = document.getElementById('hd-filter').value;
		    var activities = document.querySelectorAll('.dshoatdong');
		    
		    activities.forEach(function(activity) {
		        var titleId = activity.getAttribute('data-title-id');
		        var activityName = activity.querySelector('.ten h3').textContent.replace(/\s+/g, ' ').trim().toLowerCase();
		        var activityContent = activity.querySelector('.noidung').textContent.replace(/\s+/g, ' ').trim().toLowerCase();
		        var activityCategory = activity.querySelector('.theloai').textContent.replace(/\s+/g, ' ').trim().toLowerCase();
		        var matchName = searchTerms.every(function(term) {
		            return activityName.includes(term);
		        });
		        var matchContent = searchTerms.every(function(term) {
		            return activityContent.includes(term);
		        });
		        var matchCategory = searchTerms.every(function(term) {
		            return activityCategory.includes(term);
		        });

		        if ((selectedValue === 'all' || titleId === selectedValue) && (searchValue === '' || (matchName || matchContent || matchCategory))) {
		            activity.style.display = 'flex';
		        } else {
		            activity.style.display = 'none';
		        }
		    });
		});
		document.querySelector('.search-input').addEventListener('keypress', function(event) {
		    if (event.key === 'Enter') {
		        event.preventDefault();  // Ngăn chặn form gửi đi nếu có
		        document.querySelector('.search-button').click();  // Kích hoạt sự kiện click của nút tìm kiếm
		    }
		});
		
		// Lắng nghe sự kiện click trên các phần tử .tthoatdong
		document.querySelectorAll('.tthoatdong').forEach(function(element) {
		    element.addEventListener('click', function(event) {
		        // Kiểm tra xem sự kiện click có xuất phát từ nút đăng ký hay không
		        if (!event.target.classList.contains('ignore-click')) {
		            // Hiển thị modal khi click vào .tthoatdong
		            var modal = document.getElementById('activityModal');
		            modal.style.display = 'block';
		
		            // Hiển thị nội dung chi tiết của hoạt động trong modal
		            var modalBody = document.querySelector('.modal-body');
		            modalBody.innerHTML = element.innerHTML;
		        }
		    });
		});

		// Đóng modal khi click vào nút đóng hoặc ngoài modal
		document.querySelector('.close-button').addEventListener('click', function() {
		    var modal = document.getElementById('activityModal');
		    modal.style.display = 'none';
		});

		window.addEventListener('click', function(event) {
		    var modal = document.getElementById('activityModal');
		    if (event.target === modal) {
		        modal.style.display = 'none';
		    }
		});

	</script>
</body>
</html>