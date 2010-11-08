<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Collection, java.util.Iterator, fr.modelBootique.Categorie" %>
    
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table width="100%"><tr>
<td id="tabCategories" width="20%" >
<br><h2>Catégories</h2>
<%
Collection<Categorie> liste=(Collection<Categorie>)request.getAttribute("listeCat");
	
	if (liste != null){
		Iterator<Categorie> it = liste.iterator();
		while(it.hasNext()){
			Categorie aCat = it.next();
			%>
			<a onClick='JavaScript:envoieRequete("Produit?cat=<%= aCat.getId()%>&nomCat=<%= aCat.getLibelle() %>","tabProduits")'><%= aCat.getLibelle() %></a><br>
			<%
		}
	}
	%>
	</td>
	<td width="80%" id="tabProduits"><center>Sélectionnez une catégorie de produits</center></td></tr>
</table>
</body>
</html>