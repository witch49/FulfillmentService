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
	<link href="Resources/css/invoiceProcessDetail.css" rel="stylesheet">
	<title>Fulfillment Service</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />

<div class="container-fluid">
	<div class="row">
		<jsp:include page="../common/navigator.jsp"/>
	
		<div class="col-sm-9 col-md-10  main">
		 	<h3>송장 처리 상세화면</h3>
			<hr>
		 		<div class="col-md-6 col-md-offset-3">		 		
	  				<c:set var="iDetailList" value="${requestScope.invoiceDetailList}"/>
		  				<c:forEach var="i" items="${iDetailList}">
		  				<c:if test="${i.iId == requestScope.iId }">

							<div class="panel panel-primary">
							  <div class="panel-heading">
							    <h3 class="panel-title"><strong>&emsp;&emsp;송장 번호</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&thinsp;<strong>${i.iId}</strong></h3>
							  </div>
							  <div class="panel-body">
								  <div class="col-md-11">
									  <table class="table table-borderless">
									  	<tr>
									  		<th>수신인 성함</th>
									  		<td>${i.iConsigneeName}</td>
									  	</tr>
									  	<tr>
									  		<th>수신인 연락처</th>
									  		<td>${i.iConsigneeTel}</td>
									  	</tr>
									  	<tr>
									  		<th>수신인 주소</th>
									  		<td>${i.iConsigneeAddr}</td>
									  	</tr>
									  	<tr>
									  		<th>제품 코드</th>
									  		<td>${i.i_pId}</td>
									  	</tr>
									  	<tr>
									  		<th>제품명</th>
									  		<td>${i.i_pName}</td>
									  	</tr>
									  	<tr>
									  		<th>제품 수량</th>
									  		<td>${i.iAmount}</td>
									  	</tr>
									  	<tr>
									  		<th>금액</th>
									  		<td><fmt:formatNumber value="${i.cost}" pattern="#,###" />원</td>
									  	</tr>
									  	<tr>
									  		<th>주문 날짜</th>
									  		<td>${i.iOrderDate}</td>
									  	</tr>
									  	<tr>
									  		<th>쇼핑몰 이름&nbsp;(ID)</th>
									  		<td>${i.i_sName}&nbsp;(${i.i_sId})</td>
									  	</tr>
									  	<tr>
									  		<th>운송 회사 이름&nbsp;(ID)</th>
									  		<td>${i.i_tName}&nbsp;(${i.i_tId})</td>
									  	</tr>
									  	<tr>
									  		<th>송장 처리</th>
									  		<td>${i.iCheck}</td>
									  	</tr>
									  </table>
								  </div>
							  </div>
							</div>
		  				</c:if>
	  				</c:forEach>
				<div class="col-md-6 col-md-offset-5">
					<button type="button" class="btn btn-info" 
					onclick="location.href='CalculateCostProc?action=invoiceCheck'">목록으로</button>
				</div>
				<hr><hr><hr><hr><hr>
			</div>
			</div>
 		</div>
 	</div>
 
<jsp:include page="../common/footer.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" type="text/javascript"></script>
<script src="Resources/js/bootstrap.min.js"></script>

</body>
</html>