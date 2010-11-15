<%@ page session="true" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.Collection,java.util.Iterator,fr.modelBootique.Produit"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon panier</title>
</head>
<body>
<h1>Mon panier</h1><br />
<%
Collection<Produit> ProduitPanier = (Collection<Produit>) session.getAttribute("panier");

if (ProduitPanier != null){
	Iterator<Produit> it = ProduitPanier.iterator();
	
	
	
		while(it.hasNext()){
		Produit aProd = it.next();
		%>

<div id="panier" class="item">
<table widht="100%">
<tr>
<td width="50%" align="center">
<%=aProd.getLibelle()%>
</td>
<td width="50%" align="center">
<%=aProd.getPrix()%>&#8364;
</td>
</tr>
</table>
</div>
<%
	}
	%><center><a onClick='JavaScript:envoieRequete("Connexion.jsp","centre")'>Valider la commande</a></center>

	<%
}
else{
	%>Le panier est vide.<%
}
%>


</body>
</html>