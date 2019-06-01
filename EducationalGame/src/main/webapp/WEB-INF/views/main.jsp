<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang ="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="x-ua-compatible" content="ie=edge">
   <title>Main Page</title>
    <!-- Bootstrap core CSS -->
    
    
    <!-- Material Design Bootstrap -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">
   
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
	function pause() {
		document.getElementById("video").pause();
	}


</script>
<style type="text/css" >
html,
body,
header,
#intro {
    height: 100%;
}
 
 #intro{
 background: url("http://www.powerpointhintergrund.com/uploads/children-kids-background-frame-33.jpg")no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
	font-family: "Comic Sans MS","Comic Sans", cursive;
}
.card {
        margin: 0 auto; 
        float: none; 
        margin-bottom: 10px; 
}

</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top" style="margin-bottom:0px;" role="navigation">
      <div class="container">
      
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="/">Educational Game</a>
	        </div>
	        
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active">
            	<a href="/">Home</a>
            </li>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
          <li><a href="/leaderboard/"><span class="glyphicon glyphicon-stats"></span> Leaderboards</a></li>
	          <li>
	          
	          	<a href="#" data-toggle="modal" data-target="#logoutModal"> <span class="glyphicon glyphicon-log-out"></span>Logout</a>
	          </li>
          </ul>
        </div>
        
      </div>
    </nav>

<div id="intro" class="view hm-black-strong">
<div class="container">
  
  <div class="text-center">
    <h1>Mini Missions</h1>
    <h4>Welcome ${username}</h4>
    <p class="lead">Choose a game </p>
  </div>
  
</div><!-- /.container -->


<!-- Small modal -->
<div class="modal" id="logoutModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
        <h4>Log Out <i class="fa fa-lock"></i></h4>
      </div>
      <div class="modal-body">
        <p><i class="fa fa-question-circle"></i> Are you sure you want to logout? <br /></p>
        
        <div class="actionsBtns">
            <form:form method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" name="logout" value="Logout" class="btn btn-primary btn-block"/>
	            <button class="btn btn-default" data-dismiss="modal">Cancel</button>
            </form:form>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="modal" id="logoutModal1" tabindex="-1" role="dialog" aria-hidden="true" onClick="pause()">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    	  <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onClick="pause()"><span aria-hidden="true">×</span></button>
      </div>
      <div class="modal-body" style="height:430px;margin-top:0px;padding-top:0px;" align="center">
        <video width="667" height="400" id="video" controls>
		  <source src="/img/tutorial.mp4" type="video/mp4">
		Your browser does not support the video tag.
		</video>
      </div>
    </div>
  </div>
</div>

<br></br>
<br></br>
<div class="container" style = "margin:auto; ">
    <!--Grid row-->
    <div class="row">
        <!--Grid column-->
        <div class="col-lg-4 col-md-5" >

			<div class="card card-cascade narrower">

        			<!--Card image-->
        			<div class="view overlay">
            			<a href="/main/start-english/">
            				<img style = "height:300px" src="http://www.powerpointhintergrund.com/uploads/2017/07/-school-for-kids-backgrounds-for-powerpoint-education-ppt-templates-26.jpeg" class="img-fluid" alt=""  action="/main/english">
           			</a>
        			</div>

		        <!--Card content-->
		        <div class="card-body" align="center">
		            <!--Title-->
		            <h4 class="card-title">English Game</h4>
		            <!--Text-->
		            <p class="card-text">Play our English game</p>
           		</div>


        		</div>

        </div>

        <!--Grid column-->
		<div class="col-lg-4 col-md-5">


			<div class="card card-cascade narrower">

        			<!--Card image-->
      			<div class="view overlay">
          			<a href="/main/start-maths/">
          				<img src="http://www.powerpointhintergrund.com/uploads/math-wallpaper-hd-12.jpeg" class="img-fluid" alt="" style = "height:300px" >
          
         			 </a>
      			</div>

		        <!--Card content-->
		        <div class="card-body" align="center">
		            <!--Title-->
		            <h4 class="card-title">Maths Game</h4>
		            <!--Text-->
		            <p class="card-text">Play our Maths game</p>
		           
		        </div>
        	</div>
        
        </div>
  
        <!--Grid column-->
        <div class="col-lg-3 col-md-5" style="padding-top:60px;" >

			<div class="card card-cascade narrower">

        			<!--Card image-->
        			<div class="view overlay">
            			<a data-toggle="modal" data-target="#logoutModal1">
            				<img style = "height:170px;width:288px;" src="/img/images.png" class="img-fluid" alt="">
           			</a>
        			</div>

		        <!--Card content-->
		        <div class="card-body" align="center">
		            <!--Title-->
		            <h4 class="card-title">Tutorial</h4>
		            <!--Text-->
		            <p class="card-text">Watch How To Play</p>
           		</div>
       		</div>
        </div>
    <!--Grid row-->

</div>
</div>
</div>
<footer class="page-footer center-on-small-only unique-color-dark pt-0">
<div class="footer-copyright">
            <div class="container-fluid">
                ©Copyright 2018: Group 16 Team
            </div>
</footer>
</body>
</html>