<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page import="br.com.gsc.model.tableMapping.Topic"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>.:HOME:.</title>
	<LINK REL=StyleSheet HREF="css/style.css" TYPE="text/css" MEDIA=screen>
	<script type="text/javascript" src="js/jquery.js"></script>
	<SCRIPT>
			function myListener(evt) {
		    // a tab was clicked, and made visible. take action here
			
		    var selectedTabPane = evt.getTabPane(); // HTMLDivElement reference to 
		                                            // the div containing the tab pane.
		
		    var selectedTab     = evt.getTab();     // HTMLDivElement reference to 
		                                            // the div that is the actual tab
		                                            // at the top of the container with
		                                            // the tab title.
		    if(selectedTab == "Pergunta"){
		    	document.getElementById("Tab").setAttribute("TabSelected", P);
		    }
		
		    var tabContainer    = evt.getTabContainer(); // HTMLDivElement reference to 
		                                                 // the div wrapping the entire	
		                                                 // tab container.
			 doSomethingInteresting(selectedTabPane,selectedTab,tabContainer);
		}
	</SCRIPT>
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
						<form:input path="topicTitle" type="text" class="login_field" size="82"  />
						<form:textarea path="topicContent" type="text" class="login_field" cols="62" rows="3" />
						<input name="topicType" type="hidden" value="QUESTION"/>
					</tab:tabPane>
					<tab:tabPane id="sugestion" tabTitle="Sugestão">
						<form:input path="topicTitle" type="text" class="login_field" size="82"  />
						<form:textarea path="topicContent" type="text" class="login_field" cols="62" rows="3" />
						<input name="topicType" type="hidden" value="IDEA"/>
					</tab:tabPane>
					<tab:tabPane id="complain"  tabTitle="Reclamação">
						<form:input path="topicTitle" type="text" class="login_field" size="82"  />
						<form:textarea path="topicContent" type="text" class="login_field" cols="62" rows="3" />
						<input name="topicType" type="hidden" value="PROBLEM"/>
					</tab:tabPane>
					<tab:tabPane id="opnion"    tabTitle="Opnião">
						<form:input path="topicTitle" type="text" class="login_field" size="82"  />
						<form:textarea path="topicContent" type="text" class="login_field" cols="62" rows="3" />
						<input name="topicType" type="hidden" value="PRAISE"/>
					</tab:tabPane>
<!-- 				<a class="button" href="/GSC/user/addtopic.html" onclick="this.blur();" ><span> Postar </span></a> -->
					<input type="submit" class="button" value="Postar" float="right"/>
				<br>
			</tab:tabContainer>
		</form:form>
			<br>
			<c:forEach items="${topics}" var="topic">
				<br>
				<img src="/GSC/img/img_perfil.jpg" alt="Angry face" />
				<h4 class="title"><a href="<c:url value="/user/topic/${topic.id}.html"/>">${topic.topicTitle}</a></h4>
				<h5 class="sub-title"><c:out value="${topic.topicContent}"/></h5>
				<c:out value="${topic.person.username}"></c:out>				
			</c:forEach>
		</div>
	</div>
</body>
</html>