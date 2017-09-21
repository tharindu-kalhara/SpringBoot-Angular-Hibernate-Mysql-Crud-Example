<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Document   : Index
    Created on : Sep 21, 2017, 9:13:33 PM
    Author     : k0712
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>


<!DOCTYPE>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Index</title>

</head>
<body>

<div class="container">
    <center>
        <h1 class="text-success">Welcome to  Angular+SpringBoot+Hibernate+Mysql Sample application </h1>
        <label>@Author - Tharindu Kalhara</label>
        <br>
        <a class="btn btn-warning" href="user/view">Start >> </a>

        <img src="${context}/resources/static/angular.svg">
    </center>
</div>

</body>
</html>

