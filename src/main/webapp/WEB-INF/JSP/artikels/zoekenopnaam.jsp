<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://vdab.be/tags" prefix="v"%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Artikels zoeken op naam"/>
</head>
<body>
<v:menu/>
<form>
<label>Naam:<span>${fouten}</span>
<input name="text" type="text" required value="${param.text}" autofocus></label>
<input type="submit" value="zoeken">
</form>
<c:if test="${not empty param and empty fouten and empty artikels}">Geen artikels gevonden</c:if>
<c:if test="${not empty artikels}">
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Naam</th>
			<th>Aankoopprijs</th>
			<th>Verkoopprijs</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${artikels}" var="artikel">
			<tr>
				<td>${artikel.id}</td>
				<td>${artikel.naam}</td>
				<td><fmt:formatNumber type="currency" value="${artikel.aankoopprijs}" minFractionDigits="2" maxFractionDigits="2" currencyCode="EUR"/></td>
				<td><fmt:formatNumber type="currency" value="${artikel.verkoopprijs}" minFractionDigits="2" maxFractionDigits="2" currencyCode="EUR"/></td>
			</tr>
		</c:forEach>
	</tbody>

</table>

</c:if>


</body>
</html>