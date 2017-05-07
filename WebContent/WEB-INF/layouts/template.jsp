<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> <tiles:insertAttribute name="title"/></title>
<link href="${pageContext.request.contextPath}/static/resources/main.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
<div class="header">
<tiles:insertAttribute name="header"/>
</div>
<div class="content">
<tiles:insertAttribute name="content"/>
</div>
<div class="footer">
<tiles:insertAttribute name="footer"/>
</div>
</body>
</html>