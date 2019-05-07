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
		 	http://bootstrapk.com/components/#navbar<br>
		 	그외..<br>
		 	https://fooplugins.github.io/FooTable/docs/examples/basic/row-toggle.html<br>
		 	https://embed.plnkr.co/plunk/psPAl0
		 	<br>
		 	
	 	
		 	
		 	<div class="col-xs-11" >
		 		<button type="button" class="btn btn-default" style="float: right;">송장처리</button>
		 		<br><br>
		 		
		 		
		 		<table class="table table-striped">
	  				<tr>
	  					<th>송장id</th>
	  					<th>수신인 성함</th>
	  					<th>주문 날짜</th>
	  					<th>쇼핑몰 id</th>
	  					<th>운송 회사 id</th>
	  					<th>송장 처리</th>
	  				</tr>
	  				<c:set var="iList" value="${requestScope.invoiceList}"/>
					<c:forEach var="i" items="${iList}">
	  					<tr>
	  						<td><a href='/FulfillmentService/CalculateCostProc?action=invoiceCheckDetail&iId=${i.iId}'>${i.iId}</a></td>
	  						<td>${i.iConsigneeName}</td>
	  						<td>${i.iOrderDate}</td>
	  						<td>${i.i_sId}</td>
	  						<td>${i.i_tId}</td>
	  						<td>${i.iCheck}</td>
	  					</tr>
	  				</c:forEach>
				</table> 	
				
			 </div>
 		</div>
	 </div>
	 <br><br><br>
 
<jsp:include page="/admin/common/footer.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" type="text/javascript"></script>
<script src="Resources/js/bootstrap.min.js"></script>


</body>
</html>