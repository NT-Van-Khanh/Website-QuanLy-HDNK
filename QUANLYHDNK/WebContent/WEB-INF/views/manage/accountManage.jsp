<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8">
	<title>Quản lý tài khoản</title>
	<link href="<c:url value="/resources/css/manage.css" />" rel="stylesheet">
	<base href = "${pageContext.servletContext.contextPath}/">
</head>
<body>
 	<div id="menu"> 
 		<ul>
			<li>
				<a href="manage/accountManage.htm">Quản lý tài khoản </a>
			</li>
			<li>
				<a href="manage/activityManage.htm">Quản lý hoạt động </a>
			</li>
		
		</ul> 
	</div>
</body>
</html>