<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="pat" items="${patient}">
<table>
<tbody>
<tr>
<td>Faktura nr.= <c:out value="${pat.idOrder}"></c:out>/2017</td>
</tr>
</tbody>


</table>
<table>
<tbody>
<tr>
<td>Sprzedający</td>
<td>Kupujący</td>
</tr>
<tr>
<td>RCKiK</td>
<td><c:out value="${pat.nameHosp}"></c:out></td>
</tr>
<tr>
<td>ul. Masarnicza 19 Tynorowo 99-123</td>
<td>${pat.addressHosp};</td>
</tr>
</tbody>
</table>
<hr>
<br>
</c:forEach>
<c:forEach var="pat" items="${patient}">
<table>
<tbody>
  <tr><td>Dane Pacjenta</td>
    </tr>
<tr><td>Imię:</td><td><c:out value="${pat.namePat}"></c:out></td><td>Nazwisko:</td><td><c:out value="${pat.surnamePat}"></c:out></td><td>PESEL:</td><td><c:out value="${pat.peselPat}"></c:out></td></tr></c:forEach>
<br>
<c:forEach var="ord" items="${ordersShow}">
<tr><td>Zamówienie</td></tr>
<tr><td>Składnik:</td><td>KKCz</td><td>Ilość:</td><td><c:out value="${ord.KKCZqty}"></c:out></td><td>Usługa:</td><td>
<c:if test="${ord.KKCZEC2==1}">Napromieniowany</c:if></td><td><c:if test="${ord.KKCZED5==1}">Ubogoleukocytarny</c:if></td></tr>
<tr><td>Składnik:</td><td>FFP</td><td>Ilość:</td><td><c:out value="${ord.FFPqty}"></c:out></td><td>Usługa:</td><td>
<c:if test="${ord.FFPEK6==1}">Inaktywowano Ryboflawiną</c:if></td><td><c:if test="${ord.FFPEGB==1}">Powtórnie zbadano >=112 dni</c:if></td></tr>
<tr><td>Składnik:</td><td>KKP zlewane</td><td>Ilość:</td><td><c:out value="${ord.KKPqty}"></c:out></td><td>Usługa:</td><td>
<c:if test="${ord.KKPEC2==1}">Napromieniowany</c:if></td><td><c:if test="${ord.KKPED5==1}">Ubogoleukocytarny</c:if></td></tr>
<tr><td>Składnik:</td><td>KKP afereza</td><td>Ilość:</td><td><c:out value="${ord.KKPafqty}"></c:out></td><td>Usługa:</td><td>
<c:if test="${ord.KKPafEC2==1}">Napromieniowany</c:if></td><td><c:if test="${ord.KKPafED5==1}">Ubogoleukocytarny</c:if></td></tr>
<tr></tr></c:forEach>
<tr><td>Koszt zamówienia:</td></tr><c:forEach var="price" items="${order}">
<tr><td>Kwota Netto</td><td><c:out value="${price.netPrice}"></c:out></td><td>Vat</td><td>8%</td><td>Łącznie do zapłaty</td><td><c:out value="${1.08*price.netPrice}"></c:out></td><td>PLN</td></tr>
</c:forEach>
</tbody> 
</table>
<hr>
<br><br>
<table>
<tbody>
<tr><td>...............</td><td>...............</td></tr>
<tr><td>Sprzedający</td><td>Kupujący</td></tr>

</tbody>
</table>
<hr>
<br>
Kwota do zapłaty w terminie do 90 dni. <br>Nr IBAN: PL 99 1020 1234 1234 0000 0000 0007
