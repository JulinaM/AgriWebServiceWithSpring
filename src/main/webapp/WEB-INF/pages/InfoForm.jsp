<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link href="rs/bootstrap/css/bootstrap.css" rel="stylesheet">
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
        body { padding-top: 70px; }

    </style>
</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">
                <img alt="KrishiGhar" src="/rs/images/favicon.ico">
            </a>
        </div>
    </div>
</nav>


<div class="container">
    <div class="page-header">
        <h2>Update Info</h2>
    </div>
<form:form method="POST" class="form-horizontal" commandName="info">

    <form:errors path="*" cssClass="errorblock" element="div"/>
    <div class="row">
        <div class="col-sm-6 col-md-4">
            <h3>Information</h3>
            <div class="form-group">
                <label for="intputTitle" class="col-sm-4 control-label">InfoTitle</label>

                <div class="col-sm-6">
                    <form:input path="title" class="form-control" type="text" id="intputTitle"
                                placeholder="InfoTitle"/><form:errors path="title" cssClass="error"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputBody" class="col-sm-4 control-label">InfoBody</label>

                <div class="col-sm-6">
                    <form:textarea path="body" class="form-control" id="inputBody" placeholder="Info Body"/><form:errors path="body" cssClass="error"/>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-md-4">
            <form:errors path="locationPojoList" cssClass="error"/>
            <h3>Locations</h3>
            <c:forEach items="${info.locationPojoList}" var="location">
                <div class="checkbox">
                    <label>
                        <form:checkbox path="locationIds" value="${location.locationId}"/>${location.locationNameEn}
                    </label>
                </div>
            </c:forEach>
        </div>
        <div class="col-sm-6 col-md-4">
            <form:errors path="cropPojos" cssClass="error"/>
            <h3>Crops</h3>
            <c:forEach var="crop" items="${info.cropPojos}">
            <div class="checkbox">
                <label><form:checkbox path="cropIds" value="${crop.cropId}"/>${crop.cropNameEn}
                </label>
            </div>
            </c:forEach>
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