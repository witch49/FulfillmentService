<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="Resources/css/bootstrap.min.css" rel="stylesheet">
<link href="Resources/css/jquery-ui.min.css" rel="stylesheet">

<title>Fulfillment Service</title>
</head>
<body>
<jsp:include page="/admin/common/header.jsp" />

<div class="container-fluid">
	<div class="row">
		<jsp:include page="/admin/common/navigator.jsp"/>
	
		<div class="col-sm-9 col-md-10  main">
		 	<div class="col-md-7">
		 		<h3>관리자 - 발주 요청 출력하는 화면</h3>
			</div>
		 	<div class="col-md-5">
				<form action="../control/adminControl.jsp?action=dailySales" class="form-horizontal" method="post">
					
				</form>
			</div>

			<br><hr><br>
		 	참고해야 하는 사이트<br>
		 	http://bootstrapk.com/components/#navbar
		 	<br><br>
		 	<div class="col-xs-11" >
		 	<table class="table table-bordered table table-hover">
  				<tr><th>물품ID</th><th>물품명</th><th>사진</th><th>개별가격</th><th>재고수량</th><th>구매처ID</th><th>발주요청</th></tr>
  				<tr><td>gg</td><td>gg</td><td>gg</td><td>gg</td><td>gg</td><td>gg</td>
  					<td><button type="button" class="btn btn-default" style="float: center;">송장처리</button></td>
  				</tr>
  				<tr><td>gg</td><td>gg</td><td>gg</td><td>gg</td><td>gg</td><td>gg</td><td>gg</td></tr>
			</table>
		 	</div>
		 </div>
 	</div>
 </div>
 
<jsp:include page="/admin/common/footer.jsp" />

<!-- ==================================================================== -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="Resources/js/bootstrap.min.js"></script>
	<script src="Resources/js/jquery-ui.min.js"></script>

</body>
</html>