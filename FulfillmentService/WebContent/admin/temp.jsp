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
	<div style="display: flex;">
	
	<div class="row">
	<jsp:include page="/admin/common/navigator.jsp"/>
	
		<div class="col-xs-10">
			<p><a href="#animalGoods">animalGoods</a>&nbsp;|&nbsp;<a href="#book">book</a>&nbsp;|&nbsp;<a href="#cosmetic">cosmetic</a>&nbsp;|&nbsp;<a href="#fruit">fruit</a>&nbsp;|&nbsp;<a href="#homeAppliances">homeAppliances</a></p>
				


			<h3 id="animalGoods">animalGoods</h3>
			<hr>

				<div class="ani-goods" style="display: flex;">
				<div class="thumbnail" style="float:left;">
					
		        	<img src="img/bag.jpg" alt="bag" data-toggle="modal" data-target="#Modal0">
		  		</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/can.jpg" alt="can" data-toggle="modal" data-target="#Modal1">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/cushion.jpg" alt="cushion" data-toggle="modal" data-target="#Modal2">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/pad.jpg" alt="pad" data-toggle="modal" data-target="#Modal3">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/snack.jpg" alt="snack" data-toggle="modal" data-target="#Modal4">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/toy.jpg" alt="toy" data-toggle="modal" data-target="#Modal5">
				</div>
				</div>
		</div>
		
		<!-- animalGoods Modal -->
		<!-- Modal0~Modal5 -->
		<div class="modal fade" id="Modal0" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <img src="img/bag.jpg" alt="bag" >
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal1" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <img src="img/can.jpg" alt="can" >
		        &nbsp; ..
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		
		<div class="modal fade" id="Modal2" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <img src="img/cushion.jpg" alt="cushion">
		        &nbsp; ..
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		
	<div class="modal fade" id="Modal3" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <img src="img/pad.jpg" alt="pad">
		        &nbsp; ..
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		
		<div class="modal fade" id="Modal4" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       	<img src="img/snack.jpg" alt="snack" >
		        &nbsp; ..
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal5" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       	<img src="img/toy.jpg" alt="toy" >
		        &nbsp; ..
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		
		<div class="col-xs-10">
				<h3 id="book">book</h3>
				<hr>
		
				<div class="thumbnail" style="float:left;">
		        	<img src="img/book1.jpg" alt="book1" data-toggle="modal" data-target="#Modal6">
		  		</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/book2.jpg" alt="book2" data-toggle="modal" data-target="#Modal7">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/book3.jpg" alt="book3" data-toggle="modal" data-target="#Modal8">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/book4.jpg" alt="book4" data-toggle="modal" data-target="#Modal9">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/book5.jpg" alt="book5" data-toggle="modal" data-target="#Modal10">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/book6.jpg" alt="book6" data-toggle="modal" data-target="#Modal11">
				</div>
				<div class="thumbnail" style="float:left;">
		        	<img src="img/book7.jpg" alt="book7" data-toggle="modal" data-target="#Modal12">
				</div>
	    </div>
	    
	    <!-- book Modal -->
		<!-- Modal6~Modal12 -->
		<div class="modal fade" id="Modal6" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <img src="img/book1.jpg" alt="book1">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal7" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <img src="img/book2.jpg" alt="book2">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal8" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <img src="img/book3.jpg" alt="book3">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal9" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <img src="img/book4.jpg" alt="book4">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal10" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <img src="img/book5.jpg" alt="book5">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal11" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <img src="img/book6.jpg" alt="book6">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal12" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <img src="img/book7.jpg" alt="book7">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
	    
	    <div class="col-xs-10">
				<h3 id="cosmetic">cosmetic</h3>
				<hr>
		
				<div class="thumbnail" style="float:left;">
		        	<img src="img/ample.jpg" alt="ample" data-toggle="modal" data-target="#Modal13">
		  		</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/cream.jpg" alt="cream" data-toggle="modal" data-target="#Modal14">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/lipbalm.jpg" alt="lipbalm" data-toggle="modal" data-target="#Modal15">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/lotion.jpg" alt="lotion" data-toggle="modal" data-target="#Modal16">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/mask.jpg" alt="mask" data-toggle="modal" data-target="#Modal17">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/suncream.jpg" alt="suncream" data-toggle="modal" data-target="#Modal18">
				</div>
				<div class="thumbnail" style="float:left;">
		        	<img src="img/toner.jpg" alt="toner" data-toggle="modal" data-target="#Modal19">
				</div>
	    </div>
	    
	    <!-- cosmetic Modal -->
		<!-- Modal13~Modal19 -->
		<div class="modal fade" id="Modal13" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      <img src="img/ample.jpg" alt="ample">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal14" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		    	  <img src="img/cream.jpg" alt="cream">
		    	    &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal15" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		  	   <img src="img/lipbalm.jpg" alt="lipbalm">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal16" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		  		 <img src="img/lotion.jpg" alt="lotion">
		       	 &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>

		<div class="modal fade" id="Modal17" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		  		 <img src="img/mask.jpg" alt="mask">
		       	 &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal18" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		  		 <img src="img/suncream.jpg" alt="suncream">
		       	 &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal19" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		  		 <img src="img/toner.jpg" alt="toner" >
		       	 &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
	    
	    	    <div class="col-xs-10">
				<h3 id="fruit">fruit</h3>
				<hr>
		
				<div class="thumbnail" style="float:left;">
		        	<img src="img/avocado.jpg" alt="avocado" data-toggle="modal" data-target="#Modal20">
		  		</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/coconut.jpg" alt="coconut" data-toggle="modal" data-target="#Modal21">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/drogon.jpg" alt="drogon" data-toggle="modal" data-target="#Modal22">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/kiwi.jpg" alt="kiwi" data-toggle="modal" data-target="#Modal23">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/lemon.jpg" alt="lemon" data-toggle="modal" data-target="#Modal24">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/lime.jpg" alt="lime" data-toggle="modal" data-target="#Modal25">
				</div>
				<div class="thumbnail" style="float:left;">
		        	<img src="img/orange.jpg" alt="orange" data-toggle="modal" data-target="#Modal26">
				</div>
	    </div>
	    
	    <!-- fruit Modal -->
		<!-- Modal20~Modal26 -->
		<div class="modal fade" id="Modal20" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <img src="img/avocado.jpg" alt="avocado" data-toggle="modal" data-target="#Modal20">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal21" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      	<img src="img/coconut.jpg" alt="coconut" data-toggle="modal" data-target="#Modal21">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal22" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		    	<img src="img/drogon.jpg" alt="drogon" data-toggle="modal" data-target="#Modal22">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal23" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		     	<img src="img/kiwi.jpg" alt="kiwi" data-toggle="modal" data-target="#Modal23">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal24" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		     	<img src="img/lemon.jpg" alt="lemon" data-toggle="modal" data-target="#Modal24">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal25" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		   	   <img src="img/lime.jpg" alt="lime" data-toggle="modal" data-target="#Modal25">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal26" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		  	   <img src="img/orange.jpg" alt="orange" data-toggle="modal" data-target="#Modal26">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
	    <div class="col-xs-10">
				<h3 id="homeAppliances">homeAppliances</h3>
				<hr>
		
				<div class="thumbnail" style="float:left;">
		        	<img src="img/Airfryer.jpg" alt="Airfryer" data-toggle="modal" data-target="#Modal27">
		  		</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/curlingiron.jpg" alt="curlingiron" data-toggle="modal" data-target="#Modal28">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/Hairdryer.jpg" alt="Hairdryer" data-toggle="modal" data-target="#Modal29">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/Massage.jpg" alt="Massage" data-toggle="modal" data-target="#Modal30">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/Steamiron.jpg" alt="Steamiron" data-toggle="modal" data-target="#Modal31">
				</div>
				<div class="thumbnail" style="float:left; margin-left: 40px;">
		        	<img src="img/vacuumcleaner.jpg" alt="vacuumcleaner" data-toggle="modal" data-target="#Modal32">
				</div>
				<div class="thumbnail" style="float:left;">
		        	<img src="img/waterpurifier.jpg" alt="waterpurifier" data-toggle="modal" data-target="#Modal33">
				</div>
	    </div>
	    
	    <!-- homeAppliances Modal -->
		<!-- Modal27~Modal33 -->
		<div class="modal fade" id="Modal27" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <img src="img/Airfryer.jpg" alt="Airfryer">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal28" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <img src="img/curlingiron.jpg">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal29" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <img src="img/Hairdryer.jpg">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal30" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <img src="img/Massage.jpg">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal31" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <img src="img/Steamiron.jpg">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal32" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <img src="img/vacuumcleaner.jpg">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="Modal33" tabindex="-1" role="dialog" aria-labelledby="Modal0Label" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">상세 내역</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <img src="img/waterpurifier.jpg">
		        &nbsp; 가방
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>

	</div>
	</div> 
<jsp:include page="/admin/common/footer.jsp" />
<!-- ==================================================================== -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="Resources/js/bootstrap.min.js"></script>
</body>
</html>