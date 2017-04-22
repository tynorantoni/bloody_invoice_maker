<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link href="${pageContext.request.contextPath}/static/main.css"
	rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formularz zamówień składników krwi</title>
</head>
<body>
	<p>Formularz zamówień produktów krwiopochodnych</p>

	<sf:form action="${pageContext.request.contextPath}/create"
		method="post" modelAttribute="combinedCommand">

		<table style="margin-right: auto; margin-left: auto;" width="100%">

			<tr>
				<sf:form modelAttribute="combinedCommand">
					<td colspan="5"><strong>Szpital zamawiający</strong><br /> <br />
						<sf:select path="${getHospitals}" name="nameHosp">
							<sf:option value="NONE"> --Wybierz Szpital--</sf:option>
							<sf:options items="${hospitals}" itemValue="nameHosp"
								itemLabel="nameHosp"></sf:options>
						</sf:select><br>
				</sf:form>
			</tr>
			<tr>
				<th>Dane pacjenta</th>
				<th colspan="4">Zamówienie</th>
			</tr>
			<tr>
				<td>Imię:<br /> <sf:input path="${namePat}" name="namePat"
						type="text" /><br /><sf:errors path="${namePat}" cssClass="error"></sf:errors>
				<br/><sf:errors path="*" cssClass="error"></sf:errors>
				</td>
				<td>KKCz</td>
				<td><sf:input path="${KKCZqty}" name="KKCZqty" size="1"
						type="text" /> jednostek.</td>
				<td><sf:checkbox path="${KKCZED5}" name="KKCZED5" value="86" />
					Ubogoleukocytarny</td>
				<td><sf:checkbox path="${KKCZEC2}" name="KKCZEC2" value="26" />
					Napromieniowany</td>
			</tr>
			<tr>

				<td>Nazwisko:<br /> <sf:input path="${surnamePat}"
						name="surnamePat" type="text" />
				</td>
				<td>PLT</td>
				<td><sf:input path="${KKPqty}" name="KKPqty" size="1"
						type="text" /> jednostek.</td>
				<td><sf:checkbox path="${KKPED5}" name="KKPED5" value="86" />
					Ubogoleukocytarny</td>
				<td><sf:checkbox path="${KKPEC2}" name="KKPEC2" value="26" />
					Napromieniowany</td>
			</tr>
			<tr>
				<td>PESEL:<br /> <sf:input path="${peselPat}" name="peselPat"
						type="text" />
				</td>
				<td>PLT apheresis</td>
				<td><sf:input path="${KKPafqty}" name="KKPafqty" size="1"
						type="text" /> jednostek.</td>
				<td><sf:checkbox path="${KKPafED5}" name="KKPafED5" value="86" />
					Ubogoleukocytarny</td>
				<td><sf:checkbox path="${KKPafEC2}" name="KKPafEC2" value="26" />
					Napromieniowany</td>
			</tr>
			<tr>
				<td><br /></td>
				<td>FFP</td>
				<td><sf:input path="${FFPqty}" name="FFPqty" size="1"
						type="text" /> jednostek.</td>
				<td><sf:checkbox path="${FFPEK6}" name="FFPEK6" value="123" />
					Inaktywowany</td>
				<td><sf:checkbox path="${FFPEGB}" name="FFPEGB" value="112" />
					Karencja</td>

			</tr>
			<tr>
				<td><input type="submit" value="Generuj Raport" /></td>
			</tr>
		</table>
		
	</sf:form>
</body>
</html>