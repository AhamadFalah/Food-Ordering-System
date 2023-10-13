<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Your JSP Page</title>
</head>
<body>
    <!-- Your JSTL code goes here -->
    <c:forEach var="i" begin="1" end="5" step="1">
        <c:out value="${i}"/><br>
    </c:forEach>
</body>
</html>