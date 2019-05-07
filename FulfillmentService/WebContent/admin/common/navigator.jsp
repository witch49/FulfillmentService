<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
	<c:if test="${id.equals('admin') }">
		<li><a href="/FulfillmentService/CalculateCostProc?action=calculate">월단위 판매내역<br>(쇼핑몰)</a></li>
        <li><a href="/FulfillmentService/CalculateCostProc?action=calculate">월단위 발주내역<br>(구매처)</a></li>
        <li><a href="#">월단위 운송내역<br>(운송 회사)</a></li>
        <hr>
        <li><a href="#">매출 총이익</a></li>
        <li><a href="/FulfillmentService/CalculateCostProc?action=invoiceCheck">재고 목록</a></li>
        <li><a href="#">발주 요청</a></li>
        <li><a href="/FulfillmentService/CalculateCostProc?action=invoiceCheck">송장 처리</a></li>
	</c:if>
	</ul>
</div>
        