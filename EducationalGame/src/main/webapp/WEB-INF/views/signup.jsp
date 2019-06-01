<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

       <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="shortcut icon" href="/images/favicon.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Educational game</title>
  
   <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Pontano+Sans" rel="stylesheet">
      
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

body,{
    height: 100%;
}
html,
header,
#intro {
    height: 100%;
	font-family: "Comic Sans MS","Comic Sans", cursive;
}
 
 #intro{
 background: url("http://www.powerpointhintergrund.com/uploads/children-kids-background-frame-33.jpg")no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}


</style>
</head>
<body>
<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top " style="margin-bottom:0px;" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Educational game</a>
    </div>

    <ul class="nav navbar-nav navbar-right">
      <li><a href="/signup/"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/login/"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav> 
<div id="intro" class="view hm-black-strong" style=" height:766px;" align="center">

<form:form method="POST" commandName="user" action="/signup/add" style="border:1px solid #ccc" align="center">
		 
		 <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
		<table align="center">
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="username">User name</form:label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input type="password" path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password2">Password (verification)</form:label></td>
				<td><form:input type="password" path="password2" /></td>
				<td><form:errors path="password2" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="securityQuestion">Security Question</form:label></td>
				<td><form:select path="securityQuestion">
						<c:forEach var="securityQuestion" items="${questionsList}">
							<c:if test="${securityQuestion == selectedQuestion}">
								<option value="${securityQuestion}" selected="selected">${securityQuestion}</option>
							</c:if>
							<c:if test="${securityQuestion != selectedQuestion}">
								<option value="${securityQuestion}">${securityQuestion}</option>
							</c:if>
						</c:forEach>
					</form:select>
				<td><form:errors path="securityQuestion" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:input path="securityAnswer" /></td>
				<td><form:errors path="securityAnswer" cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Sign up" name="add"
					class="btn btn-primary" /></td>
				<td><input type="submit" value="Cancel" name="cancel"
					class="btn btn-default" /></td>
			</tr>
			<tr>
				<td>
					<form:input path="HighScore" value="${score}" style="visibility: hidden;"/>
				</td>
			</tr>
		</table>
		<p style="position:relative;left:0px;top:-80px;"><small class="text-white mr-2">Already have an account ?</small> <a href="/login/" class="text-white font-weight-bold text-capitalize">Log In</a></p>
		
	</form:form>

	
	<footer class="page-footer center-on-small-only unique-color-dark pt-0">
<div class="footer-copyright">
            <div class="container-fluid">
                ©Copyright 2018: Group 16 Team
            </div>
</footer>
</div>
</body>
</html>