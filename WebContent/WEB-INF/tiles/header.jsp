<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 
<a class="title" href="<c:url value='/orderForm'/>">Zlecenia produktów krwiopochodnych RCKiK Tynorowo</a>
<br/>
<sec:authorize access="!isAuthenticated()">
<a class="login" href="<c:url value='/login'/>">Zaloguj</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<a class="login" href="<c:url value='/logout'/>">Wyloguj</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a class="title" href="<c:url value='/users'/>">Dodaj Użytkownika</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a class="title" href="<c:url value='/userlist'/>">Lista Użytkowników</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<a class="title" href="<c:url value='/show'/>">Ostatnie zamówienie</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a class="title" href="<c:url value='/price'/>">Cena ostatniego</a>
</sec:authorize>