<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../Resources/css/bootstrap.min.css" rel="stylesheet">
<title>Fulfillment Service</title>
</head>
<body>
<jsp:include page="../common/cHeader.jsp" />

<div class="container-fluid">
	<div class="row">
		<jsp:include page="../common/cNavigator.jsp"/>
	
		<div class="col-sm-9 col-md-10  main">
			<div class="jumbotron">
		 		<h2>방문을 환영합니다</h2>
		 		<hr>
		 		<p style="font-size: 1.2em;">
		 			저희 회사는 창고 물류 시스템을 서비스중입니다.
		 			<br>서비스와 관련해 자세한 문의사항은 010-xxxx-xxxx로 연락주세요.</p>
			</div>
			<div class="thumbnail" style="border:0 none;  box-shadow: none;">
		 		<img src="../Resources/img/loginMain.png" alt="loginMain">
			</div>
		 </div>
		
 	</div>
 </div>
 
<jsp:include page="../common/footer.jsp" />

<!-- ==================================================================== -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../Resources/js/bootstrap.min.js"></script>
</body>
</html>