<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.List"%>
<%@page import="br.com.gsc.model.tableMapping.Topic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%-- <jsp:useBean id="topics" scope="request" type="java.util.List" /> --%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Product</title>
</head>
<body>
	
	<%
		List<Topic> topics = (List<Topic>) request.getAttribute("topics");
		for(Topic topic : topics){
			out.println(topic.getTopicTitle());
			out.println(topic.getPerson().getUserName());
			out.println("<br>");
		}
	%>

<%-- 	<c:forEach items="topics" var="topic"> --%>
<%-- 		${topic.} ${topic.getTopicContent} --%>
<%-- 	</c:forEach> --%>
</body>
</html>