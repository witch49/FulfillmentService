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
<title>Fulfillment Service</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />

<div class="container-fluid">
	<div class="row">
		<jsp:include page="../common/navigator.jsp"/>
	
		<div class="col-sm-9 col-md-10  main">
		 	<h3>물품 상세보기</h3>
			<hr>
		 		<div class="col-md-6 col-md-offset-3">
	  				<c:set var="pListItemDetail" value="${requestScope.pListItemDetail}"/>
		  				<c:forEach var="p" items="${pListItemDetail}">
		  				<c:if test="${p.pId == requestScope.pId }">

							<div class="panel panel-primary">
							  <div class="panel-heading">
							    <h3 class="panel-title"><strong>&emsp;물품 id</strong>&emsp;<strong>${p.pId}</strong></h3>
							  </div>
							  <div class="panel-body">
							  <div class="col-md-11">
								  <table class="table table-hover">
								  	<tr>
								  		<th>물품명</th>
								  		<td>${p.pName}</td>
								  	</tr>
								  	<tr>
								  		<th>개당 가격</th>
								  		<td><fmt:formatNumber value="${p.pPrice}" pattern="#,###" />원</td>
								  	</tr>
								  	<tr>
								  		<th>재고량</th>
								  		<td>${p.pAmount}</td>
								  	</tr>
								  	<tr>
								  		<th>구매처id</th>
								  		<td>${p.p_oId}</td>
								  	</tr>
								  	<tr>
								  		<th>구매처 이름</th>
								  		<td>${p.p_oName}</td>
								  	</tr>
								  	<tr>
								  		<th>이미지</th>
								  		<td><img src="${pageContext.request.contextPath}/Resources/img/${p.pImg}" alt="${p.pName}"></td>
								  	</tr>
								  </table>
							  </div>
							  </div>
							</div>
		  				</c:if>
	  				</c:forEach>
				<br>
				<div class="col-md-6 col-md-offset-5">
					<button type="button" class="btn btn-info" onclick="history.back()">목록으로</button>
				</div>
			</div>
			
			</div>
 		</div>
 	</div>
 <hr><hr>
<jsp:include page="../common/footer.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="Resources/js/bootstrap.min.js"></script>
</body>
</html>