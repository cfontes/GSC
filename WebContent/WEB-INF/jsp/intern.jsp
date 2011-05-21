<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page import="br.com.gsc.model.tableMapping.Topic"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>.:HOME:.</title>
	<LINK REL=StyleSheet HREF="css/style.css" TYPE="text/css" MEDIA=screen>
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
						<li><a href="<c:url value="/user/addtopic.html"/>">test</a></li>
						<li><a href="<c:url value="/admin/index.html"/>">Área adminstrativa</a></li>
					</ul>
				</div>
				<div class="menu_right"></div>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div id="col-left">
<%-- 		<%
			List<Topic> topics = (List<Topic>) request.getAttribute("topics");
			for(Topic topic : topics){
				out.println("<h4 class=\"title\">"+topic.getTopicTitle()+"</h4>");
				out.println("<h5 class=\"sub-title\">"+topic.getTopicContent()+"</h5>");
				out.println("<a href=\"#\" class=\"link_medium\">"+topic.getPerson().getUserName()+"</a>");
				out.println("<p>teste conteudo</p>");
// 				out.println("<img class=\"profile_pic\" src=\"img/img_perfil.jpg\" border=\"0\"/>");
				out.println("<br>");
			}
		%> --%>
			<br>
			<c:forEach items="${topics}" var="topic">
				<br>
				<h4 class="title"><a href="<c:url value="/topic/${topic.topicTitle}.html"/>">${topic.topicTitle}</a></h4>
				<h5 class="sub-title"><c:out value="${topic.topicContent}"/></h5>
				<c:out value="${topic.person.username}"></c:out>
				<input type="button" value="Add Post">
			</c:forEach>
		</div>
	</div>
</body>
</html>