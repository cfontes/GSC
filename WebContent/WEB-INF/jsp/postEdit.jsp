<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<LINK REL=StyleSheet HREF="/GSC/css/style1.css" TYPE="text/css" MEDIA=screen>
<title>Edit Post</title>
</head>
<body>
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
</body>
</html>