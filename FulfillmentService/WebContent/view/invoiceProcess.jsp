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
<jsp:include page="../common/header.jsp" />

<div class="container-fluid">
	<div class="row">
		<jsp:include page="../common/navigator.jsp"/>
	
		<div class="col-sm-9 col-md-10  main">
		 	<h3>송장 처리</h3>
			<hr>
		 	
		 	<div class="col-xs-11" >
		 		<form name="uploadForm" action="/FulfillmentService/FileProc?action=fileUpload" method="POST" enctype="multipart/form-data">
				    <input type="file" name="file" value="" size="10" class="btn btn-info"/><br>
				    <input type="submit" value="파일 업로드" name="submit" class="btn btn-info" />
				</form>
				<br><p style="color:red">업로드하는 파일은 반드시 D:\csv 경로 아래 위치해야 합니다.</p>
				
				<br>
				<form name="from1" action="/FulfillmentService/CalculateCostProc?action=invoiceUpdate" method="POST">
				    <input type="submit" value="송장 처리" name="submit" class="btn btn-info" style="float:right;" />
				</form>
		 		<br><br>
		 		
		 		<table class="table table-hover">
	  				<tr>
	  					<th>송장 번호</th>
	  					<th>수신인 성함</th>
	  					<th>주문 날짜</th>
	  					<th>쇼핑몰 이름&nbsp;(ID)</th>
	  					<th>운송 회사 이름&nbsp;(ID)</th>
	  					<th>송장 처리</th>
	  				</tr>
	  				<c:set var="iList" value="${requestScope.invoiceList}"/>
					<c:forEach var="i" items="${iList}">
	  					<tr>
	  						<td><a href='/FulfillmentService/CalculateCostProc?action=invoiceCheckDetail&iId=${i.iId}'>${i.iId}</a></td>
	  						<td>${i.iConsigneeName}</td>
	  						<td>${i.iOrderDate}</td>
	  						<td>${i.i_sName}&nbsp;(${i.i_sId})</td>
	  						<td>${i.i_tName}&nbsp;(${i.i_tId})</td>
	  						<td>${i.iCheck}</td>
	  					</tr>
	  				</c:forEach>
				</table> 	
				
			 </div>
 		</div>
	 </div>
	 <br><br><br>
 
<jsp:include page="../common/footer.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" type="text/javascript"></script>
<script src="Resources/js/bootstrap.min.js"></script>


</body>
</html>