<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page import="br.com.gsc.model.tableMapping.Topic"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>.:HOME:.</title>
	<LINK REL=StyleSheet HREF="<c:url value="/css/style1.css"/>" TYPE="text/css" MEDIA=screen>
	<LINK REL=StyleSheet HREF="<c:url value="/css/login.css"/>" TYPE="text/css" MEDIA=screen>
	<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.simplemodal.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/login.js"/>"></script>
	<script>
	  function seta_type(obj){
		document.getElementById('topicType').value = obj;		
	  }
	</script>
</head>
<body>
	<div id="bar_top">
		<div class="login">
			<ul>
				<sec:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN,ROLE_OPER">
					<li><a href="<c:url value="/user/index.html"/>">Login</a></li>
				</sec:authorize>
				<li>Ainda não é cadastrado? <a href="<c:url value="/cadastro.html"/>" class="cadastre_form">Clique aqui</a></li>				
			</ul>
		</div>
		<div class="quick-search">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td><input class="criteria_qs_text" value="Pesquisa rapida" type="text" name="criteria_qs" id="criteria_qs" /></td>
					<td><input class="criteria_qs_btn teste" type="submit" value="" class="btn_q_search" /></td>
				</tr>
				<tr>
					<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_OPER')">
						<td><a href="<c:url value="/j_spring_security_logout"/>" class="logout">Logout</a></td>
					</sec:authorize>
				</tr>
			</table>
		</div>
		<div id="bar_top_content">
			<div id="title-site">
				<h2></h2>
			</div>
			<div id="menu">
				<div class="menu_left"></div>
				<div class="menu_middle">
					<ul>						
						<li><a href="<c:url value="/intern.html"/>">Home</a></li>
						<li><a href="<c:url value="/user/index.html"/>">Login</a></li>
						<li><a href="<c:url value="/cadastro.html"/>">Cadastro</a></li>
						<li><a href="<c:url value="/admin/index.html"/>">Área adminstrativa</a></li>
					</ul>
				</div>
				<div class="menu_right"></div>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div id="col-left">
		<c:url value="/topic/addtopic.html" var="linkPost"/>
		
			<form:form action="${linkPost}" modelAttribute="topic" method="post">
				<div class="area_post_form">
					<div class="option">
						<ul>
							<li><a href="#" onclick="seta_type('QUESTION')">Perguntas</a></li>
							<li><a href="#" onclick="seta_type('IDEA')">Sugestões</a></li>
							<li><a href="#" onclick="seta_type('PROBLEM')">Reclamações</a></li>
							<li><a href="#" onclick="seta_type('PRAISE')">Opniões</a></li>
						</ul>
					</div>
						<input name="topicType" type="hidden" id="topicType" value="QUESTION"/>
						<H4 class="sub-title">Titulo :</H4>
							<form:errors path="topicTitle" type="text" class="title_post"/> 
							<form:input path="topicTitle" type="text" class="title_post" name="title_post" id="title_post" />
						<H4 class="sub-title">Conteudo :</H4>
							<form:errors path="topicContent" type="text" class="cont_post"/> 
							<form:textarea path="topicContent" class="cont_post" name="content_post" id="content_post"/>
<%-- 							<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">					 --%>
							<input type="submit" class="btn_post" value="" />
<%-- 							</sec:authorize>				 --%>
				</div>			
			</form:form>
			<ul class="list_posts">
				<c:forEach items="${topics}" var="topic">
					<li>
						<c:url value="/img/img_perfil.jpg" var="imgPath"/>
						<div class="list_thumb"><img class="profile_pic" src="${imgPath}" border="0" alt="img"/></div>
						<div class="list_cont">
							<ul>
								<li class="list_title_post">
									<h4 class="title"><a href="<c:url value="/topic/${topic.id}.html"/>">${topic.topicTitle}</a></h4>
									<h5>Criado em : ${topic.createdIn}</h5>									
								</li>
								<li><p><h5 class="sub-title"><c:out value="${topic.topicContent}"/></h5></p></li>
								<li><img src="/GSC/img/star.png"><c:out value="${topic.person.username}"/></li>
							</ul>
						</div>
					</li>
				</c:forEach>																								
			</ul>
		</div>
		<div id="col-right">
			<img class="middle" src="${imgPath}" border="0" alt="img"/>
		</div>
	</div>
</body>
</html>