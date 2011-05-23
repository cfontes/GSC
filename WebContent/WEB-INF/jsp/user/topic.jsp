<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tab" uri="http://ditchnet.org/jsp-tabs-taglib" %>
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
						<li><a href="<c:url value="cadastro.html"/>">Cadastro</a></li>
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
				<br>
				<br>
				<form:form action="/GSC/user/addpost.html" modelAttribute="post" method="post">
						<input id="Tab" name="TabSelected" type="hidden"/>
						<tab:tabContainer id="principal-selector">
								<tab:tabPane id="question"  tabTitle="Pergunta" >
									<form:input path="postTitle" type="text" class="login_field" size="81"  />
									<form:textarea path="content" type="text" class="login_field" cols="62" rows="3" />
									<input name="topicType" type="hidden" value="QUESTION"/>
								</tab:tabPane>
								<tab:tabPane id="sugestion" tabTitle="Sugestão">
									<form:input path="postTitle" type="text" class="login_field" size="81"  />
									<form:textarea path="content" type="text" class="login_field" cols="62" rows="3" />
									<input name="topicType" type="hidden" value="IDEA"/>
								</tab:tabPane>
								<tab:tabPane id="complain"  tabTitle="Reclamação">
									<form:input path="postTitle" type="text" class="login_field" size="81"  />
									<form:textarea path="content" type="text" class="login_field" cols="62" rows="3" />
									<input name="topicType" type="hidden" value="PROBLEM"/>
								</tab:tabPane>
								<tab:tabPane id="opnion"    tabTitle="Opnião">
									<form:input path="postTitle" type="text" class="login_field" size="81"  />
									<form:textarea path="content" type="text" class="login_field" cols="62" rows="3" />
									<input name="topicType" type="hidden" value="PRAISE"/>
								</tab:tabPane>
			<!-- 				<a class="button" href="/GSC/user/addtopic.html" onclick="this.blur();" method="post" ><span> Postar </span></a> -->
								<input type="submit" class="button" value="Postar" align="right"/>
							<br>
						</tab:tabContainer>
					</form:form>
				<h3>Posts</h3>
				<c:forEach items="${topic.listOfPosts}" var="post">
					<h4>$post.postTitle</h4>
					<h5>$post.content</h5>
				</c:forEach>
			</div>
		</div>
</body>
</html>