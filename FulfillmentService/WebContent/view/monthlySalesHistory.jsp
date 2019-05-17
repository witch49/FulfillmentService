<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<jsp:include page="../common/header.jsp" />

<div class="container-fluid">
	<div class="row">
		<jsp:include page="../common/navigator.jsp"/>
	
		<div class="col-sm-9 col-md-10  main">
		 	<div class="col-md-7">
		 		<h3>월단위 판매내역(쇼핑몰)</h3>
			</div>
		 	<div class="col-md-5">
				<form action="/FulfillmentService/CalculateCostProc?action=pickMonthForSalesList&page=1" class="form-horizontal" method="post" name="form">
					<label for="selectMonth">
					Date : 
					</label>&nbsp;
					<input name="selectMonth" id="selectMonth" class="date-picker" autocomplete="off" />&nbsp;
					<input type="submit" name="submintMonthSales" id="datepicker" class="btn btn-info" value="확인">
				</form>
			</div>
		
			<br><br>
			<hr>
			<p>쇼핑몰 대금 청구액을 확인하는 화면입니다.</p>
			<br>
		 	<div class="col-xs-11" >
		 	<table class="table table-hover">
  				<tr><th>쇼핑몰 id</th><th>쇼핑몰 이름</th><th>쇼핑몰 대금 청구 금액(원)</th><th>주문자 전화번호</th><th>주문날짜</th></tr>
  				<c:set var="ccList" value="${requestScope.ipList}"/>
				<c:forEach var="cc" items="${ccList}">
  					<tr>
  						<td>${cc.c_comId}</td>
	  					<td>${cc.c_comName}</td>
	  					<td><fmt:formatNumber value="${cc.c_sCost}" pattern="#,###" /></td>
	  					<td>${cc.c_iTel}</td>
	  					<td>${cc.c_iDate}</td>
  					</tr>
  				</c:forEach>
			</table>
			<div class="col-md-6 col-md-offset-5">
				<c:set var="pageList" value="${requestScope.pageList}"/>
				<c:forEach var="pageNo" items="${pageList}">
					${pageNo}
				</c:forEach>
			</div>
			
		 	</div>
		 </div>
 	</div>
 </div>
 <hr><hr>
<jsp:include page="../common/footer.jsp" />

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
				dateFormat: 'yy-mm',
				onClose: function(dateText, inst){
				var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
				var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
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