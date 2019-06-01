<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="x-ua-compatible" content="ie=edge">
 
   
    <!-- Bootstrap core CSS -->
    
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Moving to ${Destination}</title>

<script type="text/javascript">  
	function timer(i) {
		if (i == 1) {
			document.getElementById("timer").innerHTML = "0";
			if (${Destination == "Maths"}) {
				setTimeout("window.location.replace('/progress-maths')", 100);
			} else {
				setTimeout("window.location.replace('/progress-english')", 100);
			}
			
		} else {
			document.getElementById("timer").innerHTML = ""+(i-1)+"...";
			setTimeout("timer("+(i-1)+")", 1000);
		}
	}
	
	setTimeout("timer(3)", 1000);
</script>
<style>
html,
body,
header,
#intro {
    height: 100%;
}
 
 #intro{
 background: url("http://www.powerpointhintergrund.com/uploads/2017/07/kids-background-kids-background-hd-ol-kids-backgrounds-kids--html--15.png")no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
	font-family: "Comic Sans MS","Comic Sans", cursive;
}
h1, h2 {
    display: inline;
}
form {
    margin-left: 25%;
    margin-right:25%;
    width: 50%;
}
form {
    display: inline-block;
    text-align: center;
    font-size:40px;
    
}



 #timer {
  background-image: -webkit-gradient( linear, left top, right top, color-stop(0, #f22), color-stop(0.15, #f2f), color-stop(0.3, #22f), color-stop(0.45, #2ff), color-stop(0.6, #2f2),color-stop(0.75, #2f2), color-stop(0.9, #ff2), color-stop(1, #f22) );
  background-image: gradient( linear, left top, right top, color-stop(0, #f22), color-stop(0.15, #f2f), color-stop(0.3, #22f), color-stop(0.45, #2ff), color-stop(0.6, #2f2),color-stop(0.75, #2f2), color-stop(0.9, #ff2), color-stop(1, #f22) );
  color:green;
  -webkit-background-clip: text;
  background-clip: text;
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
	          <li>
	          	<a href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
	          </li>
          </ul>
        </div>
        
      </div>
    </nav>
     <div id="intro" class="view hm-black-strong">
     <div class="container">
  <div class="text-center" style="padding-top:200px;">
    
    <h2 >Want to Continue ?</h2>
  </div>
</div>
<div class="modal" id="logoutModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">Ã</span></button>
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

    <form>
	<table style="width:90%" align="center">
		<tr>
			<td>
				<h1>Moving to ${Destination} mode in:</h1>
			</td>
		</tr>
		<tr>
			<td>
				<h3 id="timer">3...</h3>
			</td>
		</tr>
		<tr>
			<td>
	
				<a href = "/"><input type = "button" style="position:relative;left:10px;top:2px;" value = "Exit to Main Menu" class="btn btn-default"></a>
			</td>
		</tr>
</table>
</form>
	</div>
	
	<footer class="page-footer center-on-small-only unique-color-dark pt-0">
<div class="footer-copyright">
            <div class="container-fluid">
                ©Copyright 2018: Group 16 Team
            </div>
</footer>
	
	
</body>
</html>