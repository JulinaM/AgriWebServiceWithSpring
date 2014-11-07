<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link href="/rs/bootstrap/css/bootstrap.css" rel="stylesheet">
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

    </style>
</head>

<body>
<div class="well">
    <div class="page-header">
        <h2>Login</h2>
    </div>
    <c:url var="loginUrl" value="/j_spring_security_check"></c:url>
    <form:form method="POST" class="form-horizontal" commandName="login" action="${loginUrl}">

        <form:errors path="*" cssClass="errorblock" element="div"/>
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">Username</label>

            <div class="col-sm-2">
                <form:input path="username" class="form-control" type="text" id="username"
                           placeholder="Username" /><form:errors path="username" cssClass="error"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password</label>

            <div class="col-sm-2">
                <form:password path="password" class="form-control" id="password" placeholder="Password"/><form:errors path="password" cssClass="error"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default"/>
            </div>
        </div>


    </form:form>
</div>
</body>
</html>