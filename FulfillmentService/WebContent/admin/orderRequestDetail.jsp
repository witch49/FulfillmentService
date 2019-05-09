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
		 	<h3>발주 요청 상세보기</h3>
			<hr>
		 		<div class="col-md-11"> 		
	  				<c:set var="pList" value="${requestScope.pList}"/>
		  				<c:forEach var="p" items="${pList}">
		  				<c:if test="${p.pId == requestScope.pId }">

							<div class="panel panel-primary">
							 	<div class="panel-heading">
							    	<h3 class="panel-title"><strong>&emsp;물품 id</strong>&emsp;&emsp;&emsp;<strong>${p.pId}</strong></h3>
							  	</div>
								<div class="panel-body">
								<div class="col-md-4">
								<table class="table table-hover">
									<tr>
								  		<th>물품명</th>
								  		<td>${p.pName}</td>
								  	</tr>
								  	<tr>
								  		<th>물품 가격</th>
								  		<td>${p.pPrice}원</td>
								  	</tr>
								  	<tr>
								  		<th>재고량</th>
								  		<td>${p.pAmount}</td>
								  	</tr>
								  	<tr>
								  		<th>구매처 아이디</th>
								  		<td>${p.p_oId}</td>
								  	</tr>
								  	<tr>
								  		<th>구매처 이름</th>
								  		<td>${p.p_oName}</td>
								  	</tr>
								</table>
								  
								<br><br>
								<form name="form1" action="/FulfillmentService/ProductProc?action=requestItemsToOrder&pId=${p.pId}" method="POST">
									발주 요청 개수를 입력하세요.<br>
									<input type="text" name="orderAmount" /><br><br><br>
				   					<input type="submit" value="발주하기" name="submit" class="btn btn-info" />
								</form>
								<br>							    
								 
							  </div>
							  
							  </div>
							</div>
		  				</c:if>
	  				</c:forEach>
				<br>
				<div class="col-md-6">
					<button type="button" class="btn btn-info" onclick="location.href='ProductProc?action=requestItems'">목록으로</button>
				</div>
			</div>
			</div>
 		</div>
 	</div>
 
<jsp:include page="/admin/common/footer.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="Resources/js/bootstrap.min.js"></script>
</body>
</html>