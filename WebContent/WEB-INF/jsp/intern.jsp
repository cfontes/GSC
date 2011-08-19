<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page import="br.com.gsc.model.tableMapping.Topic"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<sec:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN,ROLE_OPER">
					<ul>
						<li><a href="<c:url value="/loginform.html"/>">Login</a></li>
						<li>Ainda não é cadastrado? <a href="<c:url value="/cadastro.html"/>" class="cadastre_form">Clique aqui</a></li>				
					</ul>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
					<ul>						
						<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>						
					</ul>
			</sec:authorize>
		</div>
		<div class="quick-search">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td><input class="criteria_qs_text" value="Pesquisa rapida" type="text" name="criteria_qs" id="criteria_qs" /></td>
					<td><input class="criteria_qs_btn teste" type="submit" value="" class="btn_q_search" /></td>
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
						<li><a class="login_form" href="<c:url value="/login.html"/>">Empresa</a></li>
						<li><a href="<c:url value="#"/>">Produto</a></li>
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
			<ul class="topics">
				<c:forEach items="${topics}" var="topic">
					<li>
						<c:set value="${topic.topicType}" var="imgName"/>
						<c:url value="/img/${imgName}.png" var="imgPath"/>
						<div class="topic_thumb"><img class="profile_pic" src="${imgPath}" border="0" alt="img"/></div>
						<div class="topic">
							<table><td>
								<tr class="list_title_post">
									<ul class="icons_actions">
										<sec:authorize url="/admin/**">
											<c:set value="true" var="admin"/>
										</sec:authorize>
										<c:if test="${topic.person.username == logged || admin==true}">
											<li>
												<c:url value="/topic/${topic.id}.html" var="urlEditPost"/>
												<form:form action="${urlEditPost}" method="put">
													<input class="btn_edit" type="submit" value="" />
												</form:form>
											</li>																											
											<li>
												<c:url value="/topic/${topic.id}.html" var="urlDeletePost"/>
												<form:form action="${urlDeletePost}" method="delete">
													<input class="btn_delete" type="submit" value=""/>
												</form:form>
											</li>	
										</c:if>		
									</ul>
									<div class="title"><a href="<c:url value="/topic/${topic.id}.html"/>">${topic.topicTitle}</a></h4>
									<div class="criadoem">Criado em : ${topic.createdIn}</div>
									<tr><div class="img-user"><img src="/GSC/img/star.png"><c:out value="${topic.person.username}"/></div></tr>							
								</tr>
								<tr>
									<div class="sub-title">
									<c:choose>
										<c:when test="${fn:length(topic.topicContent) > 90}">
											<c:out value="${fn:substring(topic.topicContent,0,90)}"/>...
										</c:when>
										<c:otherwise>
											<c:out value="${topic.topicContent}"/>
										</c:otherwise>
									</c:choose>
									</div>
								</tr>								
							</td></table>
						</div>
					</li>
				</c:forEach>																								
			</ul>
		</div>
		<div id="col-right">
		</div>
	</div>
</body>
</html>