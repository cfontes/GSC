<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<LINK REL=StyleSheet HREF="/GSC/css/style1.css" TYPE="text/css" MEDIA=screen>
	<script type="text/javascript" src="/GSC/js/jquery.js"></script>
	<title>Topic</title>
</head>
<body>
	<div id="bar_top">
		<div class="login">
		<sec:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN,ROLE_OPER">
				<ul>
					<li><a href="<c:url value="/user/index.html"/>">Login</a></li>
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
						<li><a href="<c:url value="#"/>">Empresa</a></li>
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
				<div class="post_viewed">
					<h1 class="title"><c:out value="${topic.topicTitle}"/></h1>
					<div class="infos_post">criado em :<span>${topic.createdIn}</span></div>
					<p><c:out value="${topic.topicContent}"/></p>	
					<p><img src="/GSC/img/star.png"><c:out value="${topic.person.username}"/></p>		
				</div>
				<div class="post-under-topic">
						<c:forEach items="${topic.listOfPosts}" var="post">
						<div class="post">
							<div class="avatar"><img src="/GSC/img/avatar_default.png" border="0" /></div>
							<div class="c-post">
								<ul>
									<li class="sub-title">${post.postTitle}
										<ul class="icons_actions">
<!-- 									<li><a href="#"><img src="/GSC/img/edit_post.png" border="0" /></a></li> -->
											<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
												<c:set value="true" var="admin"/>
											</sec:authorize>
											<c:if test="${post.person.username == logged || admin==true}">
												<li>
													<c:url value="/topic/${topic.id}/post/${post.id}.html" var="urlEditPost"/>
													<form:form action="${urlEditPost}" method="put">
														<input class="btn_edit" type="submit" value="" />
													</form:form>
												</li>																											
												<li>
													<c:url value="/topic/${topic.id}/post/${post.id}.html" var="urlDeletePost"/>
													<form:form action="${urlDeletePost}" method="delete">
														<input class="btn_delete" type="submit" value=""/>
													</form:form>
												</li>	
											</c:if>												
										</ul>
									</li>
									<li class="date-of-post post-title">criado em: <span>${post.createdIn}</span></li>
									<li class="container-post">${post.content}</li>
									<li><img src="/GSC/img/star.png"><c:out value="${post.person.username}"/></li>
								</ul>
							</div>
						</div>
						</c:forEach>
				</div>
			<div class="ut_create_post">
				<c:url value="/topic/${topic.id}/post/addpost.html" var="urlAddPost"/>
					<form:form action="${urlAddPost}" modelAttribute="post" method="post" name="ut_create_post" id="ut_create_post">
						<table>
							<tr><td class="title">Faça seu post</td></tr>
							<tr><td><form:input path="postTitle" type="text" class="ut_titulo_post" id="ut_titulo_post" />
							<tr><td><form:textarea path="content" type="text" class="ut_cont_post"  id="ut_cont_post" />
							<tr><td><input class="btn_post" type="submit" value="" /></td></tr>	
						</table>
					</form:form>	
			</div>			
		</div>
		<div id="col-right">
		</div>
	</div>
</body>
</html>