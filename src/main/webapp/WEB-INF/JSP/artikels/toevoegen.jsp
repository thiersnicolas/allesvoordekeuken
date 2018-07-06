<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@taglib uri="http://vdab.be/tags" prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Artikel toevoegen" />
</head>
<body>
	<v:menu />
	<h1>Artikel toevoegen</h1>
	<form method="post">
		<label>Naam: <span>${fouten.naam}</span> <input type="text"
			name="naam" required></label> <label>Aankoopprijs: <span>${fouten.aankoopprijs}</span>
			<input type="number" min="0.01" step="0.01" name="aankoopprijs"></label>
		<label>Verkoopprijs: <span>${fouten.verkoopprijs}</span> <input
			type="number" min="0.01" step="0.01" name="verkoopprijs" required></label>

		<div>
			<span>${fouten.soort}</span><label> <input name='soort'
				value='F' type='radio' id='food'
				${param.soort == "F" ? "checked" : "" }>Food
			</label>
		</div>
		<label>Houdbaarheid: <span>${fouten.houdbaarheid}</span> <input
			name='houdbaarheid' value='${param.houdbaarheid}' type='number'
			min='1' id='houdbaarheid'></label>
		<div>
			<label><input name='soort' value='NF' type='radio'
				id='nonfood' ${param.soort == "NF" ? "checked" : ""}>Non-Food</label>
		</div>
		<label>Garantie: <span>${fouten.garantie}</span> <input
			name='garantie' value='${param.garantie}' type='number' min='0'
			id='garantie'></label> 
			
		<input type="submit">
	</form>
</body>
<script>
	document.getElementById('food').addEventListener('click', function(){enableDisableInputs()});
	document.getElementById('nonfood').addEventListener('click', function(){enableDisableInputs()});
	enableDisableInputs();
	function enableDisableInputs() {
		if (document.getElementById('food').checked) {
			document.getElementById('garantie').setAttribute("disabled", true);
			document.getElementById('houdbaarheid').disabled = false;
		}
		if (document.getElementById('nonfood').checked) {
			document.getElementById('houdbaarheid').disabled = true;
			document.getElementById('garantie').disabled = false;
		}
	}
</script>
</html>