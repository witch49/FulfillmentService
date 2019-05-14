<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
	<c:if test="${id.equals('admin')}">
		<li><a href="/FulfillmentService/CalculateCostProc?action=shoppingList&page=1">월단위 판매내역<br>(쇼핑몰)</a></li>
		<li><a href="/FulfillmentService/CalculateCostProc?action=orderList&page=1">월단위 발주내역<br>(구매처)</a></li>
        <li><a href="/FulfillmentService/CalculateCostProc?action=transitList&page=1">월단위 발주내역<br>(운송 회사)</a></li>
        <hr>
        <li><a href="/FulfillmentService/CalculateCostProc?action=totalSales_2019">매출 총이익</a></li>
     </c:if>
        <li><a href="/FulfillmentService/ProductProc?action=showItems">재고 목록</a></li>
     <c:if test="${id.equals('admin')}">
        <li>
        	<a href="/FulfillmentService/ProductProc?action=requestItems">발주 요청
	       		<c:if test="${alertCount != 0}">
	       			<span class="badge badge-warning" style="background:red;">${alertCount}</span>
	       		</c:if>
       		</a>
        </li>
        <li><a href="/FulfillmentService/CalculateCostProc?action=invoiceCheck">송장 처리</a></li>
	</c:if>
	</ul>
</div>
        
        