<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />	
	<title>Cadastro</title>
	<LINK REL=StyleSheet HREF="css/style.css" TYPE="text/css" MEDIA=screen>
</head>
<body>
<div id="bar_top"></div>
	<div class="login">
	<h2>Cadastro</h2>
		<form:form action="/GSC/cadastro.html" modelAttribute="CadastroUser" method="post">
		<table>
			<tr>
				<td>Nome</td>
				<td><form:input path="userName" type="text"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password"  type="password" /></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><form:input path="email"  type="text" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Cadastrar" /></td>
			</tr>
		</table>
		</form:form>
</body>
</html>