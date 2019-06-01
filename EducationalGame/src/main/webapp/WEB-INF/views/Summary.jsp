<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="img/css/bootstrap.css" rel="stylesheet" media="screen">
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

<script type="text/javascript">  
	function RemoveButtons() {
		if ("${UserName}" == "Guest") {
			document.getElementById("score").innerHTML='My Highest Score: <input type="submit" id="signup" value="Signup to save score" name="signup" class="btn btn-default" style="background-color: #D8FFFF;">';
			/* document.getElementById("form").style.display="block"; */ 
		} else {
			document.getElementById("score").innerHTML="My Highest Score: ${HighestScore}";
			/* document.getElementById("form").style.display="none"; */
		}
		
	}
	setTimeout("RemoveButtons()", 0); 
	
	
</script>
<style>

#score {

    display: inline;
}
<style>
body {height: 100%;
font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

html,
body,
header,
#intro {
    height: 100%;
}
 #intro{
 background: url("/img/summary-background.png")no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
}
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}
h1, h2, {

    display: inline;
}
form {
	font-family: "Comic Sans MS","Comic Sans", cursive;
    margin-left: 25%;
    margin-right:25%;
    width: 50%;
}
form {
    display: inline-block;
    text-align: center;
    font-size:40px;
    
}
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

</style>

<title>Summary Page</title>
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
    <div class="modal" id="logoutModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"></span></button>
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
<div id="intro" class="view hm-black-strong" style="position:relative;left:0px;top:-19px; height:766px;">

   
	<form:form method= "POST" id="form" commandName="EnglishQuestionPair" action="/summary/signup" style="padding-top:15px;">
	<h2> Well done ${UserName}</h2>
<h3>You have completed your Mini Mission</h3>
<font size="6"><p>
    <hr> 
	<table align = "center" style="text-align:left">

	<tr>
	<td id="score"></td>
	
	<tr>
	<td>English Score: ${EnglishScore}/8</td>
	</tr>
	<tr>
	<td>Maths Score: ${MathsScore}/8</td>
	</tr>
	<tr>
	<td>Time Bonus: ${bonus}</td>
	</tr>
	
	<tr>
	<td>Overall Score: ${MathsScore+EnglishScore+bonus}</td>
	</tr>
	<tr>
	</tr>
	
	</tr>
	<tr>
	<td><br></td>
	</tr>
	<td>Highest Score to Beat: ${HighestScoreEver}</td>
	</tr>
	
	<tr>
  <td> <div style="text-align:center"><a href = "/"><input type = "button" value = "Want to play again ? " class="btn btn-success"></a></div></td>
	
	</tr>
	</table>
</p>		</font>
	</form:form>
	
	</div>
	
	<footer class="page-footer center-on-small-only  pt-0">
<div class="footer-copyright">
            <div class="container-fluid">
                ©Copyright 2018: Group 16 Team
            </div>
            </div>
</footer>
</body>
</html>