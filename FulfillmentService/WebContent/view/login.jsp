<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../Resources/css/login.css" rel="stylesheet">
<link href="../Resources/css/bootstrap.min.css" rel="stylesheet">

<title>Fulfillment Service</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />

	<div class="form-box">
	<div class="head" style="background:#3F8BC9;">회원 로그인</div>
	<form id="login-form" action="/FulfillmentService/LoginProc?action=login" method=post>
		<div class="form-group">
			<label class="label-control">
				아이디<span class="label-text"></span>
			</label>
			<input type="text" name="id" class="form-control" />
		</div>
		<div class="form-group">
			<label class="label-control">
				비밀번호<span class="label-text"></span>
			</label>
			<input type="password" name="password" class="form-control" />
		</div>
		<input type="submit" value="로그인" name="B1" class="form-control"/>
	</form>
	</div>

<jsp:include page="../common/footer.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../Resources/js/bootstrap.min.js"></script>
</body>
</html>