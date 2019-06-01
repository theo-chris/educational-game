<!DOCTYPE HTML>
<%@page import="eduGameApp.controllers.indexValidator"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Educational game</title>
   
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     <style type="text/css" >
 
html,
body,
header,
#intro {
    height: 100%;
}
 
 #intro{
 background: url("http://www.powerpointhintergrund.com/uploads/children-kids-background-image-3.jpg")no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
	font-family: "Comic Sans MS","Comic Sans", cursive;
}

</style>
    
</head>
<body>
<nav class="navbar navbar navbar-inverse navbar-fixed fluid-top " style="margin-bottom:0px; font-weight:bolder;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Educational game</a>
    </div>

    <ul class="nav navbar-nav navbar-right">
       <li><a href="/leaderboard/"><span class="glyphicon glyphicon-stats"></span> Leaderboards</a></li>
       <li><a href="/signup/"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
       <li><a href="/login/"><span class="glyphicon  glyphicon-log-in "></span> Login</a></li> 
    </ul>
  </div>
</nav> 
    <!-- Start your project here-->
     <div id="intro" "class="view hm-black-strong">
   
    <div class="container-fluid full-bg-img d-flex 
     justify-content-center align-items-center">
     <div class="row d-flex justify-content-center">
     

            <div class="col-md-12 text-center">
    
    <!-- Heading -->
    <h2 class="display-3 font-bold white-text mb-2">Mini Missions</h2>
    <!-- Divider -->
    <hr class="hr-light">
    <!-- Description -->
    <h4 class="white-text my-4">Amazing game for preschoolers</h4>
    <a role ="button" href="/guest"  class="btn btn-outline-white">Play As Guest<i class="fa fa-gamepad ml-4"></i></a>
</div>
</div>
</div>
</div>

	


<main class="mt-5">
 <!--Section: Contact-->
            <section id="contact">

                <!-- Heading -->
                <h2 class="mb-5 font-weight-bold text-center">Contact us</h2>

                <!--Grid row-->
                <div class="row">

                    <!--Grid column-->
                    <div class="col-lg-5 col-md-12">

                        <!-- Form contact -->
                        <form class="p-5" action="http://www.newnavy.co.uk/email.php" method="post">

                            <div class="md-form form-sm">
                                <i class="fa fa-user prefix grey-text"></i>
                                <input type="text" id="form3" class="form-control" name="first_name">
                                <label for="form3">Your name</label>
                            </div>

                            <div class="md-form form-sm">
                                <i class="fa fa-envelope prefix grey-text"></i>
                                <input type="text" id="form2" class="form-control" name="email">
                                <label for="form2">Your email</label>
                            </div>

                            <div class="md-form form-sm">
                                <i class="fa fa-tag prefix grey-text"></i>
                                <input type="text" id="form32" class="form-control" name="subject">
                                <label for="form34">Subject</label>
                            </div>

                            <div class="md-form form-sm">
                                <i class="fa fa-pencil prefix grey-text"></i>
                                <textarea type="text" id="form8" class="md-textarea" style="height: 100px" name="message"></textarea>
                                <label for="form8">Your message</label>
                            </div>

                            <div class="text-center">
                                <input type="submit" name="submit" value="Send" class="btn btn-primary">
                                    <i class="fa fa-paper-plane-o ml-1"></i>
                            </div>

                        </form>
                        <!-- Form contact -->

                    </div>
                   

                </div>
                <!--Grid row-->

            </section>
            <!--Section: Contact-->

        </div>
</main>
<footer class="page-footer center-on-small-only unique-color-dark pt-0">
<div class="footer-copyright">
            <div class="container-fluid">
               ©Copyright 2018: Group 16 Team
            </div>
            </div>
</footer>

<!-- SCRIPTS -->


    <!-- JQuery -->
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
    
   <script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
   
 <script>

</script>
    
</body>
</html>
