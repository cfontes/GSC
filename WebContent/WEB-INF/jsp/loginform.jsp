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
		<%
		if(request.getParameter("error") != null){
			if (request.getParameter("error").equals("invalido")){
		%>
		<p>
			<span style="color:red">
			Usuário ou Senha inválidos
			</span>
		</p>
		<%
			} //fim do if equals
		}//fim do if null
		%>
		
		<form action="j_spring_security_check" method="post">
			<table>
			<tr>
				<td>Usuario:<FONT color="red"></FONT></td>
				<td><input name="j_username" class="login_field" type="text" value="${not empty login_error ? SPRING_SECURITY_LAST_USERNAME : ''}"/></td>
			</tr>
			<tr>
				<td>Senha:<FONT color="red"></FONT></td>
				<td><input name="j_password" class="login_field" type="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="" class="btn_entra"/></td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>