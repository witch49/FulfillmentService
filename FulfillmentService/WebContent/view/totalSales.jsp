<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="Resources/css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="Resources/css/Chart.css" rel="stylesheet">  -->

<title>Fulfillment Service</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />

<div class="container-fluid">
<div class="row">
	<jsp:include page="../common/navigator.jsp"/>
	
	<div class="col-sm-9 col-md-10  main">
		 <div class="col-md-7">
		 	<h3>매출 총 이익</h3>
		</div>
		 	
		<div class="col-md-11" >
		 	<hr>
			<div class="dropdown">
				<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				연도<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="/FulfillmentService/CalculateCostProc?action=totalSales_2017">2017</a></li>
					<li><a href="/FulfillmentService/CalculateCostProc?action=totalSales_2018">2018</a></li>
					<li><a href="/FulfillmentService/CalculateCostProc?action=totalSales_2019">2019</a></li>
				</ul>
			</div>
			<br>
			<p>${year}년도 총 매출액 : <fmt:formatNumber value="${totalSalesYear}" pattern="#,###" />원</p>
			<br>
			<div style="width:75%;">
				<canvas id="myChart"></canvas>
			</div>
		</div>
	</div>
</div>
</div>
<hr><hr>
<jsp:include page="../common/footer.jsp" />

<!-- ==================================================================== -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="Resources/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
	<script>
		$(".dropdown-menu li a").click(function(){
			//$(this).parents(".dropdown").find('.btn').html('${year}' + ' <span class="caret"></span>');
		  	$(this).parents(".dropdown").find('.btn').html($(this).text() + ' <span class="caret"></span>');
		 	$(this).parents(".dropdown").find('.btn').val($(this).data('value'));
		});
	</script>
	<script type="text/javascript">
		var ctx = document.getElementById("myChart");
		var myChart = new Chart(ctx, {
		    type : "line",
		    data : {
		          labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
		        , datasets : [{
		              label: "#LineChart"
		            , data: ['${Jan}', '${Feb}', '${Mar}', '${Apr}', '${May}', '${Jun}', '${Jul}', '${Aug}', '${Sep}', '${Oct}', '${Nov}', '${Dec}']
		            , backgroundColor : [
		                  "rgba(255, 99, 132, 0.2)"
		            ]
		            , borderColor: [
		                  "rgba(255, 99, 132, 1)"
		            ]
		            , borderWidth : 1
		        }]
		    }
		    , options : {
		        scales : {
		            yAxes : [{
		                ticks : { beginAtZero : true }
		            }]
		        }
		    }
		});
	</script>
</body>
</html>