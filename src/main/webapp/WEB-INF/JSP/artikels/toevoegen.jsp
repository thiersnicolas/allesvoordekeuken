<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@taglib uri="http://vdab.be/tags" prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Artikel toevoegen"/>
</head>
<body>
<h1>Artikel toevoegen</h1>
<form method="post">
	<label>Naam: <span>${fouten.naam}</span>
		<input type="text" name="naam" required></label>
	<label>Aankoopprijs: <span>${fouten.aankoopprijs}</span>
		<input type="number" min="0.01" step="0.01" name="aankoopprijs"></label>
	<label>Verkoopprijs: <span>${fouten.verkoopprijs}</span>
		<input type="number" min="0.01" step="0.01" name="verkoopprijs" required></label>
		<input type="submit">
</form>
</body>
</html>