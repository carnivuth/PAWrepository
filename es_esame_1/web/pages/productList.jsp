<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.Prodotto"%>
<%@ page import="java.util.*"%>
<%@ page import="beans.Users"%>    
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product list</title>
</head>
<%if(session.getAttribute("logged")==null || session.getAttribute("logged").equals(false))response.sendRedirect(request.getContextPath()+"/pages/login.jsp"); %>
<body>
<% List<Prodotto> prodotti=new ArrayList<Prodotto>();
	prodotti.add(new Prodotto(10,"p1",10.1,1));
	prodotti.add(new Prodotto(20,"p1",10.1,1));
	prodotti.add(new Prodotto(30,"p1",10.1,1));
	prodotti.add(new Prodotto(40,"p1",10.1,1));
	prodotti.add(new Prodotto(50,"p1",10.1,1));
	prodotti.add(new Prodotto(60,"p1",10.1,1));
%>
<table>
<tr><td>id</td><td>nome</td><td>prezzo</td><td>quantita</td></tr>
<%for(Prodotto p: prodotti) { %>
	<tr><td><%=p.getId() %></td><td><%=p.getNome() %></td><td><%=p.getPrezzo()%></td><td><%=p.getDisponibilita()%></td></tr>
<%}%>
</table>
</body>
</html>