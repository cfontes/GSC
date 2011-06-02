<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<LINK REL=StyleSheet HREF="/GSC/css/style.css" TYPE="text/css" MEDIA=screen>
	<script type="text/javascript" src="js/jquery.js"></script>
	<title>Topic</title>
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
				<h2><c:out value="${topic.topicTitle}"/></h4>
				<h3 class="sub-title"><c:out value="${topic.topicContent}"/></h5>			
				<a href="<c:url value="/user/${topic.person.username}.html"/>">${topic.person.username}</a>
				<form:form method="delete">
					<input type="submit" class="button" value="Delete" />
				</form:form>
				<form:form method="put">
					<input type="submit" class="button" value="Edit" />
				</form:form>
				<br>
				<h3>Posts</h3>
				<c:forEach items="${topic.listOfPosts}" var="post">
					<h4>${post.postTitle}</h4>
					<h5>${post.content}</h5>
				</c:forEach>
				<br>
				
				<c:url value="/user/topic/${topic.id}/post/addpost.html" var="urlPost"/>
				<form:form action="${urlPost}" modelAttribute="post" method="post">
					<form:input path="postTitle" type="text" class="login_field" size="82"  />
					<form:textarea path="content" type="text" class="login_field" cols="62" rows="3" />
					<input type="submit" class="button" value="Postar" float="right"/>
				</form:form>				
			</div>
		</div>
</body>
</html>