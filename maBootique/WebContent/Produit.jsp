<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.Collection,java.util.Iterator,fr.modelBootique.Produit"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%=request.getAttribute("cat")%></h3>
<center>
<table>
	<%
		Collection<Produit> liste = (Collection<Produit>) request
				.getAttribute("listeProd");

		if (liste != null) {
			Iterator<Produit> it = liste.iterator();
			while (it.hasNext()) {
				Produit aProd = it.next();
	%>
	<tr>
		<td><%=aProd.getLibelle()%></td>
		<td width="50px"></td>
		<td><a onClick='JavaScript:envoieRequete("AjoutPanierServlet","centre")'>Ajouter
		au panier</a></td>
	</tr>
	<%
		}
		}
	%>
</table>
</center>
</body>
</html>