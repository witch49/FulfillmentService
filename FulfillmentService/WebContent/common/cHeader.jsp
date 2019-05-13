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
      	 onclick="javascript:location.href='${pageContext.request.contextPath}/view/cLoginMain.jsp'">&nbsp;&nbsp;&nbsp;
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<br>
        <ul class="nav navbar-nav navbar-right"> 	
			<p class="navbar-text">${memberName}님 환영합니다</p>
          	<li>
          		<form action="/FulfillmentService/LoginProc?action=logout" method="post">
          		<button type="submit" class="btn" style="color:#337AB7; background:white;">로그아웃</button>
          		</form>
         	</li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>