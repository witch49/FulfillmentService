<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
	<c:if test="${id > 30000 && id < 80000 }">
		<li><a href="#">일별 주문내역</a></li>
		<li><a href="#">월별 주문내역</a></li>
	</c:if>
	</ul>
</div>