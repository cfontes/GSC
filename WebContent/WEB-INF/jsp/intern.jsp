<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="br.com.gsc.model.tableMapping.Topic"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
						<li><a href="user">Login</a></li>
						<li><a href="/GSC/cadastro.html">Cadastro</a></li>
						<li><a href="/GSC/listTopics.html">test</a></li>
						<li><a href="admin">Área adminstrativa</a></li>
					</ul>
				</div>
				<div class="menu_right"></div>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div id="col-left">
		<%
			List<Topic> topics = (List<Topic>) request.getAttribute("topics");
			for(Topic topic : topics){
				out.println("<h4 class=\"title\">"+topic.getTopicTitle()+"</h4>");
				out.println("<h5 class=\"sub-title\">"+topic.getTopicContent()+"</h5>");
				out.println("<a href=\"#\" class=\"link_medium\">"+topic.getPerson().getUserName()+"</a>");
				out.println("<p>teste conteudo</p>");
				out.println("<img class=\"profile_pic\" src=\"img/img_perfil.jpg\" border=\"0\"/>");
				out.println("<br>");
			}
		%>	
		</div>
	</div>
</body>
</html>