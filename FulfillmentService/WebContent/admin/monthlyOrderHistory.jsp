<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:include page="/admin/common/header.jsp" />

<div class="container-fluid">
	<div class="row">
		<jsp:include page="/admin/common/navigator.jsp"/>
	
		<div class="col-sm-9 col-md-10  main">
		 	<h3>관리자 - 월단위 발주내역 출력하는 화면</h3>
			<hr>
		 	참고해야 하는 사이트<br>
		 	http://bootstrapk.com/components/#navbar
		 	<br><br>
		 	<div class="col-xs-11" >
		 	<table class="table table-bordered">
  				<tr><th>물품ID</th><th>물품명</th><th>구매처ID</th><th>금액</th></tr>
  				<tr><td>0000</td><td>토너</td><td>50001</td><td>10000</td></tr>
  				<tr><td>gg</td><td>gg</td><td>gg</td><td>gg</td></tr>
			</table>
		 	</div>
		 </div>
 	</div>
 </div>
 
<jsp:include page="/admin/common/footer.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../Resources/js/bootstrap.min.js"></script>
</body>
</html>