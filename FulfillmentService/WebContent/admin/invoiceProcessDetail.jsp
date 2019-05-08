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
	<link href="Resources/css/invoiceProcessDetail.css" rel="stylesheet">
	<title>Fulfillment Service</title>
</head>
<body>
<jsp:include page="/admin/common/header.jsp" />

<div class="container-fluid">
	<div class="row">
		<jsp:include page="/admin/common/navigator.jsp"/>
	
		<div class="col-sm-9 col-md-10  main">
		 	<h3>송장 처리 상세화면</h3>
			<hr>
		 		<div class="col-xs-11">
		 		<br><br>
		 		
	  				<c:set var="iDetailList" value="${requestScope.invoiceDetailList}"/>
		  				<c:forEach var="i" items="${iDetailList}">
		  				<c:if test="${i.iId == requestScope.iId }">

							<div class="panel panel-primary">
							  <div class="panel-heading">
							    <h3 class="panel-title"><strong>&emsp;&emsp;송장id</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&thinsp;<strong>${i.iId}</strong></h3>
							  </div>
							  <div class="panel-body">
							    <strong>&emsp;&emsp;수신인 성함</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span>${i.iConsigneeName}</span><br>
			  					<strong>&emsp;&emsp;수신인 연락처</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span>${i.iConsigneeTel}</span><br>
			  					<strong>&emsp;&emsp;수신인 주소</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span>${i.iConsigneeAddr}</span><br>
			  					<strong>&emsp;&emsp;제품 코드</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span>${i.i_pId}</span><br>
			  					<strong>&emsp;&emsp;제품명</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&thinsp;<span>${i.i_pName}</span><br>
			  					<strong>&emsp;&emsp;제품 수량</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span>${i.iAmount}</span><br>
			  					<strong>&emsp;&emsp;주문 날짜</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span>${i.iOrderDate}</span><br>
			  					<strong>&emsp;&emsp;쇼핑몰 id</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span>${i.i_sId}</span><br>
			  					<strong>&emsp;&emsp;운송 회사 id</strong>&emsp;&emsp;&ensp;&emsp;&ensp;&emsp;&emsp;&emsp;&ensp;<span>${i.i_tId}</span><br>
			  					<strong>&emsp;&emsp;송장 처리</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<span>${i.iCheck}</span>
							  </div>
							</div>
		  				</c:if>
	  				</c:forEach>
				<br>
				<div class="col-xs-6">
					<button type="button" class="btn btn-info" 
					onclick="location.href='CalculateCostProc?action=invoiceCheck'">목록으로</button>
				</div>
			</div>
			</div>
 		</div>
 	</div>
 
<jsp:include page="/admin/common/footer.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" type="text/javascript"></script>
<script src="Resources/js/bootstrap.min.js"></script>

</body>
</html>