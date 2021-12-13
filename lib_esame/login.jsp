<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ page import="beans.User"%>
<%@ page import="beans.Users"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<jsp:useBean id= "users" scope= "application"  class= "beans.Users" >  </jsp:useBean>
  
<% 
if(session.getAttribute("logged")!=null && session.getAttribute("logged").equals(true))request.getRequestDispatcher("/pages/productList.jsp").forward(request,response);
	if(request.getMethod().equals("POST")){
		if(users.getUser(request.getParameter("username")).getPassword().equals(request.getParameter("password")) ){
			
			session.setAttribute("logged", true);
			
			request.getRequestDispatcher("/pages/productList.jsp").forward(request,response);
		
		}
	}

%>
	<fieldset>
	<form action=<%=request.getContextPath()+"/pages/login.jsp" %> method="POST">
		<input type="text" name="username" id="username" placeholder="username">
		<input type="password" name="password" id="password" placeholder="password">
		<input type="submit" id="submit">
	</form>
	</fieldset>
</body>
</html>