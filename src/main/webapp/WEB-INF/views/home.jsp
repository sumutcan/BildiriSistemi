<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Kullanici Girisi
</h1>
<form:form action="login">
<table>
<tr>
<td>Eposta:</td>
<td><form:input path="email"/></td>
<tr>
<tr>
<td>Sifre:</td>
<td><form:password path="sifre"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Giris Yap"></td>
</tr>
<tr>
<td>Yeni Kullanici?<td>
<td><a href="registeration">Kaydol</a></td>
<tr>
</table>
</form:form>

</body>
</html>
