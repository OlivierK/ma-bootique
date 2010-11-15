<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Collection, java.util.Iterator, fr.modelBootique.Categorie" %>
    
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion</title>
</head>
<body>

<table width="100%">
<tr>
<td id="Connexion" width="50%" colspan="2">
<h2>Connectez-vous</h2></td>
<td width="50%" id="NouvelleConnexion" colspan="2">
<h2>Nouveaux Client ? Inscrivez-vous</h2>
</td>
</tr>	
	<tr>
	<td>Login:</td>
	<td><INPUT type=text name="login" size="15"></td>
	<td>Nom:</td>
	<td><INPUT type=text name="nom" size="15"></td>
	</tr>
	<tr>

	<td>Mot de passe:</td>
	<td><INPUT type=text name="mdp" size="15"></td>
	
	<td>Pr&eacute;nom:</td>
	<td><INPUT type=text name="Prenom" size="15"></td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>Login:</td>
	<td><INPUT type=text name="nouveauLogin" size="15"></td>
	</tr>	
	<tr>
	<td><INPUT type=button name="valider" value="Login"></td>
	<td>&nbsp;</td>
	<td>Mot de passe:</td>
	<td><INPUT type=text name="nouveauMdp" size="15"></td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td><INPUT type=button name="creer" value="Inscription"></td>
	<td>&nbsp;</td>
	</tr>
	
</table>
</body>
</html>