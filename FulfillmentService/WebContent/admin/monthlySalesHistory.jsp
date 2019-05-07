<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		 		<h3>관리자 - 월단위 판매내역 출력하는 화면</h3>
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
		 	<div class="col-xs-11" >
		 	<table class="table table-bordered">
  				<tr><th>송장ID</th><th>전화번호</th><th>주문날짜</th><th>쇼핑몰 대금 청구 금액</th></tr>
  				<c:set var="ccList" value="${requestScope.calList}"/>
				<c:forEach var="cc" items="${ccList}">
  				<tr><td>${cc.c_iId}</td><td>${cc.c_iTel}</td><td>${cc.c_iDate}</td><td>${cc.c_sCost}</td><td></td></tr>
  				</c:forEach>
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
				changeMonth: true,
				changeYear: true,
				showButtonPanel: true,
				dateFormat: 'MM-yy',
				onClose: function(dateText, inst){
				var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
				var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
				$(this).datepicker('setDate', new Date(year, month, 1));
				}
			});
		});
	</script>
	<style>
		.ui-datepicker-calendar {
		display: none;
		}
	</style>
</body>
</html>