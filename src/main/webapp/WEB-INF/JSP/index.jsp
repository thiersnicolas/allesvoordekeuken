<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="v" uri='http://vdab.be/tags'%>
<!doctype html>
<html>
<v:head title='Alles voor de keuken'/>
<body>
<header>
<v:menu/>
<h1>Alles voor de keuken</h1>
<img id="hoofd" src="<c:url value="/images/logo${randomnummer}.jpg"/>" alt="foto"/>
</header>
</body>
</html>