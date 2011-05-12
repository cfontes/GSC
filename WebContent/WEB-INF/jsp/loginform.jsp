<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>.:HOME:.</title>
	<LINK REL=StyleSheet HREF="css/style.css" TYPE="text/css" MEDIA=screen>
</head>
<body>
	<div id="bar_top"></div>
	<div class="login">
		<h2>Login</h2>
		<form:form action="loginform.html" modelAttribute="loginForm">
			<table>
			<tr>
				<td>Usuario:<FONT color="red"><form:errors path="userName"/></FONT></td>
				<td><form:input path="userName" class="login_field" type="text" /></td>
			</tr>
			<tr>
				<td>Senha:<FONT color="red"><form:errors path="password"/></FONT></td>
				<td><form:password path="password" class="login_field" type="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="" class="btn_entra"/></td>
			</tr>
			</table>
		</form:form>
	</div>
</body>
</html>