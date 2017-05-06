<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table>
<tbody>
<tr>
<td>Nazwa</td><td>Aktywny?</td><td>Dostęp</td></tr>
<tr>

<c:forEach var="username" items="${users}" >
<td>	<c:out value="${username.username}"></c:out></td>
<td>	<c:out value="${username.enabled}"></c:out></td>
<td>	<c:out value="${username.authority}"></c:out></td></tr>
	
</c:forEach>
</tbody></table>
