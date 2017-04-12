<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>testing one two tree</title>
</head>
<body>

<c:out value="${idHosp}"></c:out>
<c:out value="${nameHosp}"></c:out>
<c:forEach var="row" items="${hospitals}">
    id ${row.idHosp}<br/>
    name ${row.nameHosp}<br/>
    
</c:forEach>
<p><a href="${pageContext.request.contextPath}/orderForm">Formularz</a></p>
</body>
</html>