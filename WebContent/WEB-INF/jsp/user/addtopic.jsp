<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Criar Topico</title>
	<LINK REL=StyleSheet HREF="/GSC/css/style.css" TYPE="text/css" MEDIA=screen>
	<script type="text/javascript" src="js/jquery.js"></script>
	<tab:tabConfig/>
</head>
<body>
	<div id="bar_top"></div>
		<form:form action="/GSC/user/addtopic.html" modelAttribute="topic" method="post">
			<tab:tabContainer id="form-post-selector">
				<tab:tabPane id="Question1"  tabTitle="Pergunta">
					<form:input path="topicTitle" type="text" class="login_field"/>
					<form:input path="topicContent" type="text" class="login_field"/>
				</tab:tabPane>
				<tab:tabPane id="Sugestion1" tabTitle="Sugestão">
					<form:input path="topicTitle" type="text" class="login_field"/>
				</tab:tabPane>
				<tab:tabPane id="Complain1"  tabTitle="Reclamação">
					<form:input path="topicTitle" type="text" class="login_field"/>
				</tab:tabPane>
				<tab:tabPane id="Opnion1"    tabTitle="Opnião">
					<form:input path="topicTitle" type="text" class="login_field"/>
				</tab:tabPane>
			</tab:tabContainer>
			<input type="submit" value="Adicionar Topico"/>
		</form:form>
</body>
</html>