<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript">   
	function Redirect() 
	{  
		alert("You ran out of time!\nProgress onto the next question.");
		window.location.replace("/maths/skip");
		
	} 
	
	var timerRemaining = ${timerRemaining}+1;
	function UpdateTimer(i) {  
		if (${easyMode == true}) {
			if (i == 0) {
			
				document.getElementById("timer").textContent='0';
				document.getElementById("timer1").value='0';
				setTimeout('Redirect()', 100); 
				
			} else {
				
				${timerStart = ''+(timerDisplay-1)}
				document.getElementById("timer").textContent=i;
				document.getElementById("timer1").value=i;
				setTimeout('UpdateTimer('+(i-1)+')', 1000); 
			}
		} else {
			if (i == 0 && timerRemaining <= 0) {
				
				document.getElementById("timer").textContent='0';
				document.getElementById("timer1").value='0';
				document.getElementById("timerRemaining").textContent='0';
				document.getElementById("timerRemaining1").value='0';
				
				setTimeout('Redirect()', 100); 
				
			} else if (i > 0) {
				
				${timerStart = ''+(timerDisplay-1)}
				document.getElementById("timer").textContent=i;
				document.getElementById("timer1").value=i;
				setTimeout('UpdateTimer('+(i-1)+')', 1000); 
				
			} else {
				document.getElementById("defaultTimer").style.opacity = 0.4; 
				document.getElementById("timer").style.opacity = 0.4; 
				document.getElementById("defaultTimer").style.color = "#000";
				document.getElementById("timer").style.color = "#000";
				document.getElementById("reserve").style.opacity = 1.0;
				document.getElementById("timerRemaining").style.opacity = 1.0;
				document.getElementById("reserve").style.color = "#33cc33";
				document.getElementById("timerRemaining").style.color = "#33cc33";
				timerRemaining=timerRemaining-1;
				document.getElementById("timer").textContent=i;
				document.getElementById("timer1").value=i;
				document.getElementById("timerRemaining").textContent=timerRemaining;
				document.getElementById("timerRemaining1").value=timerRemaining;
				setTimeout('UpdateTimer(0)', 1000); 
			}
		}
		
	}
	
	function checkAnswer(button,userAnswer,answer) { 
		document.getElementById("opt1").disabled = true;
		document.getElementById("opt2").disabled = true;
		document.getElementById("opt3").disabled = true;
		document.getElementById("opt4").disabled = true;
		button.disabled = false;
		if (userAnswer == answer) {
			// Make the button green
			document.getElementById("testing").style.color = "#33cc33";
			document.getElementById("testing").innerHTML= "Well done, correct!";
			document.getElementById("result").style.color = "#33cc33";
			document.getElementById("result").innerHTML = userAnswer;
			button.style.background = "#33cc33";
			
		} else {
			// Make the button red
			document.getElementById("testing").style.color ="red";
			document.getElementById("testing").innerHTML= "Oops, wrong!";
			document.getElementById("result").style.color ="red";
			document.getElementById("result").innerHTML = userAnswer;
			
			button.style.background = "red";
			
		}
	}
	
	 setTimeout("UpdateTimer(${timerStart})", 1000); 
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
}
h1, h2, h3, h4 {
	font-family: "Comic Sans MS","Comic Sans", cursive;
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



 #timer {color: #33cc33;
 }
 #defaultTimer{ color: #33cc33;
 }
 #reserve{ color: #000;
 			opacity:0.4;
 }
 #timerRemaining{ color: #000;
 				opacity: 0.4;
 }

</style>
<title>Maths Page</title>
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
	          	<a href="#" data-toggle="modal" data-target="#logoutModal"> <span class="glyphicon glyphicon-log-out"></span>Logout</a>
	          </li>
          </ul>
        </div>
        
      </div>
    </nav>
 <table style="width:95%;" align="center">
 	<tr>
 		<td>
 			 <div align="left">
				<h2 id="defaultTimer">Time Remaining: </h2>
				<h2 id="timer">${timerDisplay}</h2><br>
				<h2>Score: ${score}</h2>
			</div>
 		</td>
 		<td>
 			 <div align="right">
				<h2 id="reserve"style="position:relative;left:0px;top:-10px;" >Reserve time Remaining: </h2>
				<h2 id="timerRemaining" style="position:relative;left:0px;top:-10px;">${timerRemaining}</h2>
			</div>
 		</td>
 	</tr>
 </table>



<div id="intro" class="view hm-black-strong">
<div class="container">
  
  <div class="text-center">
    
    <h2 >Maths</h2>
  </div>
</div>
<!-- /.container -->
<div class="modal" id="logoutModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">Ã—</span></button>
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
<div style="position:relative;left:0px;top:-200px;"> 
<form:form method= "POST" commandName="MathsQuestions" action="/maths/answer" style="padding-top:90px;">
<input id="timer1" name="timer" type="text" value="${timerDisplay}" style="visibility: hidden;"/>
<input id="timerRemaining1" name="timerRemaining" type="text" value="${timerRemaining}" style="visibility: hidden;"/>

	<table align="center">
	<tr><td><p> </p></td></tr>
	<h4>${title} Question: ${questionNum}/4</h4>
	<tr><td style="padding-top:40px;"><h2>Work out this Question:</h2></td></tr>
	     <tr>
	   		<td><h1>${x}   </h1><h2>${operator}   </h2><h1>${y}   </h1><h2> = </h2><h1 id="result"> ? </h1></td> 
	   </tr>
     </table>
     <br>
     <table align="center">
     	<tr>
     		<td><input type="submit" id="opt1" value="${opt1}" name="opt1" onClick="checkAnswer(opt1,${opt1},${answer})" class="btn btn-default" style="width:60px; height:60px;"></td>
	     	<td><input type="submit" id="opt2" value="${opt2}" name="opt2" onClick="checkAnswer(opt2,${opt2},${answer})" class="btn btn-default" style="width:60px; height:60px;"></td>
	     	<td><input type="submit" id="opt3" value="${opt3}" name="opt3" onClick="checkAnswer(opt3,${opt3},${answer})" class="btn btn-default" style="width:60px; height:60px;"></td>
	     	<td><input type="submit" id="opt4" value="${opt4}" name="opt4" onClick="checkAnswer(opt4,${opt4},${answer})" class="btn btn-default" style="width:60px; height:60px;"></td>
     	</tr>
   <tr><td><p> </p></td></tr>
   <tr><td><p> </p></td></tr>
     	<tr>
     	<td colspan="2"> <a href = "/"><input type = "button" style="position:relative;left:60px;top:2px;" value = "Exit Game" class="btn btn-default"></a></td>
     	</tr>
     </table>
</form:form>
<div align="center" style="padding-top:30px;"> 
	<h3 id="testing"></h3>
</div>
</div>
</div>
<footer class="page-footer center-on-small-only unique-color-dark pt-0">
<div class="footer-copyright">
            <div class="container-fluid">
                ©Copyright 2018: Group 16 Team
            </div>
            </div>
</footer>
</body>
</html>