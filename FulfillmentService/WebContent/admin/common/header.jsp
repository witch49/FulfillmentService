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
        <a class="navbar-brand" href="#" style="color:white">[일조 Trillion] Fulfillment Service</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
          <c:if test="${id == null }">
          <li><a style="background: #FFF; border-radius: 5px; padding: 5px;" href="login.jsp">로그인</a></li>
          </c:if>
          <c:if test="${id.equals('admin') }">
         	 <p class="navbar-text">관리자님 환영합니다</p>
          	<li><a style="background: #FFF; border-radius: 5px; right-padding: 5px; text-align:center;" href="/FulfillmentService/LoginProc?action=logout">로그아웃</a></li>
          </c:if>
           <c:if test="${id != null && !id.equals('admin')}">
          	<li><a style="background: #FFF; border-radius: 5px; right-padding: 5px; text-align:center;" href="/FulfillmentService/LoginProc?action=logout">로그아웃</a></li>
          </c:if>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>