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
		 	<h3>재고 확인</h3>
			<hr>
			<p>
				드롭다운으로 수정하기 !! 1
				<a href="#animalGoods">애완용품</a>&nbsp;|&nbsp;
				<a href="#book">책</a>&nbsp;|&nbsp;
				<a href="#cosmetic">화장품</a>&nbsp;|&nbsp;
				<a href="#fruit">과일</a>&nbsp;|&nbsp;
				<a href="#homeAppliances">가전제품</a></p>
			<hr>	
			
			<!-- ============================================================================== -->

		  	<div class="col-md-11" >
				<hr>
		 		<h4 id="animalGoods">애완용품</h4>
				<hr><br>
		 		<c:set var="pListAnimalGoods" value="${requestScope.pListAnimalGoods}"/>
		 		<c:set var="count" value="0" />
				<c:forEach var="p" items="${pListAnimalGoods}">
					<c:if test="${count % 5 == 0}">
						<div class="col-md-1"></div>
					</c:if>	
					<div class="col-md-3">
						<div class="thumbnail">
							<a href="/FulfillmentService/ProductProc?action=showItemsDetail&pId=${p.pId}">
								<img src="${pageContext.request.contextPath}/admin/img/${p.pImg}" alt="${p.pName}">
							</a>
							<div class="caption" style="text-align: center;">
								<h5>${p.pName}</h5>
								<p>가격: ${p.pPrice}원<p>
							</div>
						</div>
					</div>			
					<c:if test="${(count+1) % 5 == 4}">
						<div class="col-md-1"></div>
						<div class="col-md-11"><hr></div>
					</c:if>			
		  		</c:forEach>
		  	</div>
		  			
			<!-- ============================================================================== -->

			<div class="col-md-11" >
				<hr>
		 		<h4 id="book">책</h4>
				<hr><br>
		 		<c:set var="pListBook" value="${requestScope.pListBook}"/>
		 		<c:set var="count" value="0" />
				<c:forEach var="p" items="${pListBook}">
					<c:if test="${count % 5 == 0}">
						<div class="col-md-1"></div>
					</c:if>	
					<div class="col-md-3">
						<div class="thumbnail">
							<a href="/FulfillmentService/ProductProc?action=showItemsDetail&pId=${p.pId}">
								<img src="${pageContext.request.contextPath}/admin/img/${p.pImg}" alt="${p.pName}">
							</a>
							<div class="caption" style="text-align: center;">
								<h5>${p.pName}</h5>
								<p>가격: ${p.pPrice}원<p>
							</div>
						</div>
					</div>			
					<c:if test="${(count+1) % 5 == 4}">
						<div class="col-md-1"></div>
						<div class="col-md-11"><hr></div>
					</c:if>			
		  		</c:forEach>
		  	</div>
		  	 
			<!-- ============================================================================== -->
		  	
			<div class="col-md-11" >
		 		<hr>
		 		<h4 id="cosmetic">화장품</h4>
				<hr><br>
		 		<c:set var="pListCosmetic" value="${requestScope.pListCosmetic}"/>
		 		<c:set var="count" value="0" />
				<c:forEach var="p" items="${pListCosmetic}">
					<c:if test="${count % 5 == 0}">
						<div class="col-md-1"></div>
					</c:if>	
					<div class="col-md-3">
						<div class="thumbnail">
							<a href="/FulfillmentService/ProductProc?action=showItemsDetail&pId=${p.pId}">
								<img src="${pageContext.request.contextPath}/admin/img/${p.pImg}" alt="${p.pName}">
							</a>
							<div class="caption" style="text-align: center;">
								<h5>${p.pName}</h5>
								<p>가격: ${p.pPrice}원<p>
							</div>
						</div>
					</div>			
					<c:if test="${(count+1) % 5 == 4}">
						<div class="col-md-1"></div>
						<div class="col-md-11"><hr></div>
					</c:if>			
		  		</c:forEach>
		  	</div>
		  	 
			<!-- ============================================================================== -->
		  	
			<div class="col-md-11" >
		 		<hr>
		 		<h4 id="fruit">과일</h4>
				<hr><br>
		 		<c:set var="pListFruit" value="${requestScope.pListFruit}"/>
		 		<c:set var="count" value="0" />
				<c:forEach var="p" items="${pListFruit}">
					<c:if test="${count % 5 == 0}">
						<div class="col-md-1"></div>
					</c:if>	
					<div class="col-md-3">
						<div class="thumbnail">
							<a href="/FulfillmentService/ProductProc?action=showItemsDetail&pId=${p.pId}">
								<img src="${pageContext.request.contextPath}/admin/img/${p.pImg}" alt="${p.pName}">
							</a>
							<div class="caption" style="text-align: center;">
								<h5>${p.pName}</h5>
								<p>가격: ${p.pPrice}원<p>
							</div>
						</div>
					</div>			
					<c:if test="${(count+1) % 5 == 4}">
						<div class="col-md-1"></div>
						<div class="col-md-11"><hr></div>
					</c:if>			
		  		</c:forEach>
		  	</div>
		  	 
			<!-- ============================================================================== -->
			 
			<div class="col-md-11" >
				<hr>
		 		<h4 id="homeAppliances">가전제품</h4>
				<hr><br>
		 		<c:set var="pListHomeAppliances" value="${requestScope.pListHomeAppliances}"/>
		 		<c:set var="count" value="0" />
				<c:forEach var="p" items="${pListHomeAppliances}">
					<c:if test="${count % 5 == 0}">
						<div class="col-md-1"></div>
					</c:if>	
					<div class="col-md-3">
						<div class="thumbnail">
							<a href="/FulfillmentService/ProductProc?action=showItemsDetail&pId=${p.pId}">
								<img src="${pageContext.request.contextPath}/admin/img/${p.pImg}" alt="${p.pName}">
							</a>
							<div class="caption" style="text-align: center;">
								<h5>${p.pName}</h5>
								<p>가격: ${p.pPrice}원<p>
							</div>
						</div>
					</div>			
					<c:if test="${(count+1) % 5 == 4}">
						<div class="col-md-1"></div>
						<div class="col-md-11"><hr></div>
					</c:if>			
		  		</c:forEach>
		  	</div>

			<!-- ============================================================================== -->
			 
 		</div>
	 </div>
	 <br><br><br>
 
<jsp:include page="/admin/common/footer.jsp" />
	

<!-- ==================================================================== -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="Resources/js/bootstrap.min.js"></script>
</body>
</html>