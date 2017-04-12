<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formularz zamówień składników krwi</title>
</head>
<body>
<p>Formularz zam&oacute;wień produkt&oacute;w krwiopochodnych</p>
<table style="margin-right: auto; margin-left: auto;" width="100%">

<tr>
<td colspan="5"><strong>Szpital zamawiajšcy</strong><br /><br /><select style="width: 400px;">
<option>Opcja 1</option>
<option>Opcja 2</option>
<option>Opcja 3</option>
<option>Opcja 4</option>
<option>Opcja 5</option>
</select></td>
</tr>
<tr><th>Dane pacjenta</th><th colspan="4">Zam&oacute;wienie</th></tr>
<tr>
<td><form>Imię:<br /> <input name="name" type="text" /></form></td>
<td>KKCz</td>
<td><form><input name="iloscKKCz" size="1" type="text" /> jednostek.</form></td>
<td><form><input name="ED5" type="checkbox" value="86" /> Ubogoleukocytarny</form></td>
<td><form><input name="EC2" type="checkbox" value="26" /> Napromieniowany</form></td>
</tr>
<tr>
<td><form>Nazwisko:<br /> <input name="surname" type="text" /></form></td>
<td>PLT</td>
<td><form><input name="iloscPLT" size="1" type="text" /> jednostek.</form></td>
<td><form><input name="ED5" type="checkbox" value="86" /> Ubogoleukocytarny</form></td>
<td><form><input name="EC2" type="checkbox" value="26" /> Napromieniowany</form></td>
</tr>
<tr>
<td><form>PESEL:<br /> <input name="pesel" type="text" /></form></td>
<td>FFP</td>
<td><form><input name="iloscFFP" size="1" type="text" /> jednostek.</form></td>
<td><form><input name="EK6" type="checkbox" value="123" /> Inaktywowany</form></td>
<td><form><input name="EGB" type="checkbox" value="112" /> Karencja</form></td>
</tr>
<tr>
<td><form action="/action_page.php" method="post"><input type="submit" value="Generuj Raport" /></form></td>
</tr>
</table>

</body>
</html>