<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-light bg-primary">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header" style="font-color: white;">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      	<img src="${pageContext.request.contextPath}/Resources/img/trillionlogowhite.png"
      	 onclick="javascript:location.href='${pageContext.request.contextPath}/view/index.jsp'">&nbsp;&nbsp;&nbsp;
      </div>
      
      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      	<br>
	      <ul class="nav navbar-nav navbar-right" >
	      <li><span class="glyphicon glyphicon-list" aria-hidden="true" style="font-size:30px;"
      	  onclick="location='${pageContext.request.contextPath}/view/loginMain.jsp'"></span></li>
      	  <li>&nbsp;&nbsp;</li>
	        <c:if test="${id == null}">
	        <li>
	        	<form action="/FulfillmentService/LoginProc?action=loginView" method="post">
	        	<button type="submit" class="btn" style="color:#337AB7; background:white;">로그인</button>
	        	</form>
	        </li>
	        </c:if>
	        <c:if test="${id.equals('admin') }">
	       	 <p class="navbar-text">관리자님 환영합니다</p>
	        	<li>
	        	 	<form action="/FulfillmentService/LoginProc?action=logout" method="post">
	        		<button type="submit" class="btn" style="color:#337AB7; background:white;">로그아웃</button>
	        		</form>
	        	</li>
	        </c:if>
	      </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>