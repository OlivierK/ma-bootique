<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Collection,java.util.Iterator,fr.modelBootique.Produit"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon panier</title>
</head>
<body>

<%

Collection<Produit> ProduitPanier = (Collection<Produit>) request.getAttribute("ProdPanier");

//String ProduitPanier=(String)request.getAttribute("ProdPanier");
out.println("Produit dans le panier: " + ProduitPanier);

%>

</body>
</html>