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
		 	<h3>관리자 - 송장처리 출력하는 화면</h3>
			<hr>
		 	참고해야 하는 사이트<br>
		 	http://bootstrapk.com/components/#navbar
		 	<br><br>
		 	<div class="col-xs-11" >
		 	<button type="button" class="btn btn-default" style="float: right;">송장처리</button><br><br>
		 	<table class="table table-bordered table table-hover">
  				<tr><th>고객명</th><th>전화번호</th><th>주소</th><th>제품코드</th><th>제품명</th><th>날짜</th><th>수량</th><th>처리여부</th></tr>
  				<tr><td>정정화</td><td>010-1234-4567</td><td>대전시 대덕구 비래동로 00번길 00</td><td>abcd</td><td>패드</td><td>2019-01-30</td><td>20</td><td>20</td></tr>
  				<tr><td>gg</td><td>gg</td><td>gg</td><td>gg</td><td>gg</td><td>gg</td><td>gg</td><td>gg</td></tr>
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