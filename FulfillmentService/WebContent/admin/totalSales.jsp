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
		 		<h3>관리자 - 매출 총이익 출력하는 화면</h3>
			</div>
		 	<div class="col-md-5">
				<form action="../control/adminControl.jsp?action=dailySales" class="form-horizontal" method="post">
					<label for="startDate">
					Date :
					</label>
					<input name="startDate" id="startDate" class="date-picker" />
				</form>
			</div>


			<br><hr><br>
		 	참고해야 하는 사이트<br>
		 	http://bootstrapk.com/components/#navbar
		 	<br><br>
		 	<div class="col-xs-11" >
		 	<table class="table table-bordered table table-hover">
  				<tr><th>쇼핑몰(+)</th><th>구매처(-)</th><th>운송회사(-)</th><th>금액</th></tr>
  				<tr><td>gg</td><td>gg</td><td>gg</td><td>10000</td></tr>
  				<tr><td>gg</td><td>gg</td><td>gg</td><td>gg</td></tr>
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
	
	<script>
		$(function(){
			$('.date-picker').datepicker({
				changeYear: true,
				showButtonPanel: true,
				dateFormat: 'yy',
				onClose: function(dateText, inst){
				var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
				//날짜 초기값
				$(this).datepicker('setDate', new Date(year, 1));
				}
	    	});
		});
	</script>
	<style>
		.ui-datepicker-calendar {
			display: none;
		}
		.ui-datepicker-months {
			display: none ;
		}
	</style>
</body>
</html>