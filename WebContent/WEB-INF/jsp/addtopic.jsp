<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Criar Topico</title>
	<LINK REL=StyleSheet HREF="css/style.css" TYPE="text/css" MEDIA=screen>
</head>
<body>
<br>
<br>
	<form:form action="/GSC/addtopic.html" method="post" modelAttribute="topic">
		<table>
			<tr>
				<td>Topic name</td>
				<td><form:input path="topicTitle"/></td>
			</tr>
			<tr>
				<td>Topic Description</td>
				<td><form:input path="topicContent"/><td>
			</tr>
			<tr>
				<td><input type="submit" value="Adicionar Topico"/></td>
			</tr>
		</table>
	</form:form>

</body>
</html>