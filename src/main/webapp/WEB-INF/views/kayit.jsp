<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kullanici Kaydi</title>
</head>
<body>
	<form:form action="register">
		<table>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Sifre:</td>
				<td><form:input path="sifre" /></td>
			</tr>
			<tr>
				<td>Ad Soyad:</td>
				<td><form:input path="adSoyad" /></td>
			</tr>
			<tr>
				<td>Adres:</td>
				<td><input type="text" name="adres" /></td>
			</tr>
			<tr>
				<td>Kurum:</td>
				<td><input type="text" name="kurum" /></td>
			</tr>
			<tr>
				<td>Tip:</td>
				<td><select name="tip">
						<option value="hakem">Hakem</option>
						<option value="yazar">Yazar</option>
						<option value="yonetici">Yonetici</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Kaydol"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>