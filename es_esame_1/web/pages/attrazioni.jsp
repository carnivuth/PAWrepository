<%@page import="javax.xml.crypto.XMLCryptoContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="beans.AttrazioniUser" %>
    <%@ page import="java.util.*" %>
    <%@ page import="beans.Attrazioni" %>
     <%@ page import="beans.Attrazione" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">

	<jsp:useBean id="ausers" class="java.util.ArrayList" scope="application"></jsp:useBean>
	<jsp:useBean id="attrazioni" class="beans.Attrazioni" scope="application"></jsp:useBean>
	
<%if(session.getAttribute("logged")==null ||
		session.getAttribute("logged").equals(false))
				response.sendRedirect(request.getContextPath()+"/pages/login.jsp"); %>
	<script type="text/javascript" src="../scripts/attrazioniScript.js"></script>
	<title>Insert title here</title>
</head>
<body >
	
	<form id="coordinatesForm" action="/TW_Esame_StartingKit/pages/attrazioni.jsp" method="POST">
		<input name="username" type="text"/>
		<input name="xcoordinate" type="text"/>
		<input name="ycoordinate" type="text"/>
		<input value="send" type="submit"/>
	</form>
	<table id="attrazioniTable">
	<tr><td>name</td> <td>description</td></tr>
	<%
		if(request.getMethod().equals("POST")){
			AttrazioniUser user=new AttrazioniUser(Integer.parseInt(request.getParameter("xcoordinate")),
													Integer.parseInt(request.getParameter("ycoordinate")),
													request.getParameter("username"));
			if(!ausers.contains(user))ausers.add(user);
			for(Attrazione a: attrazioni.getAttrazioni()){
				if(a.getUserDistance(user)<=10){
					int usersIn=0;
					for(Object o :ausers){
						AttrazioniUser u=(AttrazioniUser)o;
						if(a.getUserDistance(u)<=100)usersIn++;
					}
					if(usersIn<=10){
	%>
		<tr><td><%=a.getNome() %></td> <td><%=a.getDescrizione() %></td></tr>	
	<%	
					}
				}
			}
		
		}
	%>
	</table>
	
</body>
</html>