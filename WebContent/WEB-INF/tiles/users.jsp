<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
Dodaj użytkownika

<center><h2>Dodaj Użytkownika</h2>

	<sf:form id="details" method="post"
		action="${pageContext.request.contextPath}/usercreate"
		modelAttribute="users">

		<table class="formtable">
			<tr>
				<td class="label">Nazwa użytkownika</td>
				<td><sf:input class="control" path="${username}" name="username"
						type="text" /><br />
				<div class="error">
						<sf:errors path="username"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label">Hasło:</td>
				<td><sf:input id="password" class="control" path="${password}"
						name="password" type="password" />
					<div class="error">
						<sf:errors path="password"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Dodaj Użytkownika" type="submit" /></td>
			</tr>
		</table>

	</sf:form>
	</center>
