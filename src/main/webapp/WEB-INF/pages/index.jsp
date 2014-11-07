<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@page session="true"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/rs/images/favicon.ico">

    <title>KrishiGhar Home</title>
    <style>
        body {
            padding-top: 50px;
        }
        .starter-template {
            padding: 40px 15px;
            text-align: center;
        }
    </style>
    <!-- Bootstrap core CSS -->
    <link href="/rs/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="/rs/js/d3.v3.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Krishi Ghar</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        <security:authorize access="hasRole('IS_AUTHENTICATED_ANONYMOUSLY')">
        <form:form method="POST" class="navbar-form navbar-right" role="form" commandName="login" action="/j_spring_security_check">
                <div class="form-group">
                    <form:input path="username" type="text" placeholder="Username" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:input path="password" type="password" placeholder="Password" class="form-control"/>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-success">Sign in</button>
        </form:form>
        </security:authorize>
        <security:authorize access="hasRole('ROLE_USER')">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/form/info">Enter Data</a> </li>
                <li class="active"><a href="#"><security:authentication property="principal.username"/></a></li>
                <li><form class="navbar-form navbar-right" action="<c:url value="/j_spring_security_logout"/>" method="post">
                        <button type="submit" class="btn btn-login">Logout</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </li>
            </ul>
        </security:authorize>
        </div><!--/.navbar-collapse -->
    </div>
</nav>

<div class="container">
    <div class="starter-template">
        <h1>Krishi Ghar</h1>
        <div class="row">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img data-src="holder.js/300x300" alt="Location Icon" src="/rs/images/location.png">
                    <div class="caption">
                        <h3>${locationCount} Locations</h3>
                     </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img data-src="holder.js/300x300" alt="Subscribers Icon" src="/rs/images/users.png">
                    <div class="caption">
                        <h3>${subscriberCount} Subscribers</h3>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img data-src="holder.js/300x300" alt="Info Providers Icon" src="/rs/images/cp.png">
                    <div class="caption">
                        <h3>${contentProviderCount} Information Providers</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/rs/bootstrap/js/jquery-1.11.1.min.js"></script>
<script src="/rs/bootstrap/js/bootbox.min.js"></script>
</body>
</html>
