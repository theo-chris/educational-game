<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
   <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
 <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
  
  <script type="text/javascript">
  $(document).ready( function () {
	    $('#table_id').DataTable();
	} );
  
  function goBack() {
	    window.history.back();
	}
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
    font-size:20px;
    
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
<title>Leaderboard</title>
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
        </div>
        
      </div>
    </nav>
  
<div id="intro" class="view hm-black-strong" style="position:relative;left:0px;top:-19px; height:766px;">

<form>
<h2>Leaderboards</h2>
    <hr>
    	
    
    <table id="table_id" class="display" style="width:100%" align ="center">
         <thead>
             <tr>
                 <th style="text-align:center">#</th>
                 <th style="text-align:center">Username</th>
                 <th style="text-align:center" >Score</th>
             </tr>
         </thead>
         <tbody>
            <c:forEach  items="${users}" var="u" varStatus="status">
<tr><td width="5">
<c:out value="${num = num + 1}" /></td>
<td>
<c:out value="${u.username}" /></td>
<td>
<c:out value="${scores[status.index]}" /></td>
</tr>
</c:forEach>
</table> 
 			
 </form>                           


   <div style="text-align:center"><a onClick="goBack()"><input type = "button" value = "Go Back" class="btn btn-success"></a></div>
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
