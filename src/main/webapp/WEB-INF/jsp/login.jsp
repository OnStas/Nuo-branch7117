<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Spring Security </title>
    </head>
    <body>
    	<c:url value = "/login" var = "loginProcessingUrl" />
    

        
        
        <form action="${loginProcessingUrl}" method="post">
        <fieldset>
        <legend>Please Login</legend>
        <c:if test="${param.error !=null}" >
        	<div>
        	Failed to login
        	<c:if test="${SPRING_SECURITY_LAST_EXCEPTION } !=null">
        	Reason <c:out
        	value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
        	</c:if>
        	</div>
        </c:if>
        <c:if test="${param.logout !=null}">
        	<div>You have been logged out</div>
        </c:if>	
          <p>
        <label for="user">User</label>
        <input type="text" id="user" name="user"/>
        </p>
        <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>
        </p>
        <p>
        <label for="remember-me">Remember Me?</label>
        <input type="checkbox"id="remember-me"name="remember-me" />
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <p>
        <div>
        <button type="submit" class="btn">LOG IN</button>
        </div>
        </fieldset>
        
         </form>
    </body>
</html>