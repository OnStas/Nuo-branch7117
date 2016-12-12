<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
        <title>Example :: Spring Application</title>
        <spring:url value="/res/simple.css" var="mainCss" />
        <spring:url value="/res/indexPage/index.gif" var="mainGif" />
        <link href="${mainCss}" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <div class="contentblock">
        <h1>Example - Spring Application</h1>
        <h2><%@include file="/WEB-INF/jsp/includes/greeting.jsp" %><h2>
        <a href="login.html">Hillel IT School</a>
        <br>
    </div>

        <form action="login" method="post">
        <input type="text" name="login" value="login"><br>
        <input type="text" name="password" value="password"><br>
        <input type="submit">
    </body>
</html>