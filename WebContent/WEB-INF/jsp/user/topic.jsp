<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<div id="bar_top_content">
			<div id="title-site">
				<h2></h2>
			</div>
			<div id="menu">
				<div class="menu_left"></div>
				<div class="menu_middle">
					<ul>						
						<li><a href="<c:url value="/user/index.html"/>">Login</a></li>
						<li><a href="<c:url value="/cadastro.html"/>">Cadastro</a></li>
						<li><a href="<c:url value="/user/addtopic.html"/>">Add Topic</a></li>
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
					<div class="infos_post">criado em :<span>16/01/2011</span><br/>modificado em: <span>16/01/2011</span></div>
					<p><c:out value="${topic.topicContent}"/></p>			
				</div>
				<div class="post-under-topic">
						<c:forEach items="${topic.listOfPosts}" var="post">
						<div class="post">
							<div class="avatar"><img src="/GSC/img/avatar_default.png" border="0" /></div>
							<div class="c-post">
								<ul>
									<li class="sub-title">${post.postTitle}
										/<ul class="icons_actions">
												<li><a href="#"><img src="/GSC/img/edit_post.png" border="0" /></a></li>
												<li><a href="#"><img src="/GSC/img/delete_post.png" border="0" /></a></li>
												<li class="date-of-post post-title">criado em: <span>16/01/2011</span></li>
												<li class="container-post">${post.content}</li>
										</ul>
									</li>
								</ul>
							</div>
						</div>
						</c:forEach>
				</div>
			<div class="ut_create_post">
				<c:url value="/user/topic/${topic.id}/post/addpost.html" var="urlPost"/>
					<form:form action="${urlPost}" modelAttribute="post" method="post" name="ut_create_post" id="ut_create_post">
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
			<h3 class="title">fafafa</h3>
		</div>
	</div>
</body>
</html>