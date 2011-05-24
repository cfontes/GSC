<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Criar Topico</title>
	<LINK REL=StyleSheet HREF="/GSC/css/style.css" TYPE="text/css" MEDIA=screen>
	<tab:tabConfig/>
</head>
<body>
	<div id="bar_top">
		<div id="bar_top_content">
			<div id="title-site">
				<h2>GSC<br/><span>Page</span></h2>
			</div>
			<div id="menu">
				<div class="menu_left"></div>
				<div class="menu_middle">
					<ul>						
						<li><a href="<c:url value="/user/index.html"/>">Login</a></li>
						<li><a href="<c:url value="cadastro.html"/>">Cadastro</a></li>
						<li><a href="<c:url value="/user/topic/addtopic.html"/>">Add Topic</a></li>
						<li><a href="<c:url value="/admin/index.html"/>">Área adminstrativa</a></li>
					</ul>
				</div>
				<div class="menu_right"></div>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div id="col-left">
		<form:form action="/GSC/user/topic/addtopic.html" modelAttribute="topic" method="post">
			<input id="Tab" name="TabSelected" type="hidden"/>
			<tab:tabContainer id="principal-selector" jsTabListener="myListener">
					<tab:tabPane id="question"  tabTitle="Pergunta" >
						<form:input path="topicTitle" type="text" class="login_field" size="81"  />
						<form:textarea path="topicContent" type="text" class="login_field" cols="62" rows="3" />
						<input name="topicType" type="hidden" value="QUESTION"/>
					</tab:tabPane>
					<tab:tabPane id="sugestion" tabTitle="Sugestão">
						<form:input path="topicTitle" type="text" class="login_field" size="81"  />
						<form:textarea path="topicContent" type="text" class="login_field" cols="62" rows="3" />
						<input name="topicType" type="hidden" value="IDEA"/>
					</tab:tabPane>
					<tab:tabPane id="complain"  tabTitle="Reclamação">
						<form:input path="topicTitle" type="text" class="login_field" size="81"  />
						<form:textarea path="topicContent" type="text" class="login_field" cols="62" rows="3" />
						<input name="topicType" type="hidden" value="PROBLEM"/>
					</tab:tabPane>
					<tab:tabPane id="opnion"    tabTitle="Opnião">
						<form:input path="topicTitle" type="text" class="login_field" size="81"  />
						<form:textarea path="topicContent" type="text" class="login_field" cols="62" rows="3" />
						<input name="topicType" type="hidden" value="PRAISE"/>
					</tab:tabPane>
<!-- 				<a class="button" href="/GSC/user/addtopic.html" onclick="this.blur();" method="post" ><span> Postar </span></a> -->
					<input type="submit" class="button" value="Postar" align="right"/>
				<br>
			</tab:tabContainer>
		</form:form>
</body>
</html>