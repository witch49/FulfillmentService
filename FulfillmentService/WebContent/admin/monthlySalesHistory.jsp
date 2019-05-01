<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../Resources/css/bootstrap.min.css" rel="stylesheet">
<link href="../Resources/css/jquery-ui.min.css" rel="stylesheet">
<title>Fulfillment Service</title>
</head>
<body>
<jsp:include page="/admin/common/header.jsp" />

<div class="container-fluid">
	<div class="row">
		<jsp:include page="/admin/common/navigator.jsp"/>
	
		<div class="col-sm-9 col-md-10  main">
		<div class="col-md-7">
		 	<h3>관리자 - 월단위 판매내역 출력하는 화면</h3>
		</div>
		 	<div class="col-md-5">
				<form action="../control/adminControl.jsp?action=dailySales" class="form-horizontal" method="post">
					<div class="form-group">
						<label class="control-label">날짜:&nbsp;&nbsp;</label>
						<input type="text" name="dateCustomer" id="datepicker1">&nbsp;&nbsp;
						<input class="btn btn-primary btn-sm" type="submit" value="검색">
					</div>
				</form>
			</div>
		
			<br><hr><br>
		 	참고해야 하는 사이트<br>
		 	http://bootstrapk.com/components/#navbar
		 	<br><br>
		 	<div class="col-xs-11" >
		 	<table class="table table-bordered">
  				<tr><th>송장ID</th><th>전화번호</th><th>주문날짜</th><th>쇼핑몰ID</th><th>금액</th></tr>
  				<tr><td>0000</td><td>010-1234-4567</td><td>2019-04-20</td><td>30001</td><td>12000</td></tr>
  				<tr><td>gg</td><td>gg</td><td>gg</td><td>gg</td><td>gg</td></tr>
			</table>
		 	</div>
		 </div>
 	</div>
 </div>
 
<jsp:include page="/admin/common/footer.jsp" />
	<!-- ==================================================================== -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../Resources/js/bootstrap.min.js"></script>
	<script src="../Resources/js/jquery-ui.min.js"></script>
	<script>
	    $.datepicker.setDefaults({
	        dateFormat: 'yy-mm-dd',
	        prevText: '이전 달',
	        nextText: '다음 달',
	        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	        showMonthAfterYear: true,
	        yearSuffix: '년'
	    });
	    $(function() {
	        $("#datepicker1").datepicker();
	    });
	</script>

</body>
</html>