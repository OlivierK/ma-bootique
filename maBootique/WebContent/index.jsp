<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
<meta name="description" content="description"/>
<meta name="keywords" content="keywords"/> 
<meta name="author" content="author"/> 
<link rel="stylesheet" type="text/css" href="default.css" media="screen"/>
<title>Ma Bootique</title>
<script type="text/javascript" src="ajax.js"></script>
</head>

<body>

<div class="container">
	
	<div class="main">

		<div class="header">
		
			<div class="title">
				<h1>Ma Bootique</h1>
			</div>

		</div>
		
		<div class="content">
	
			<div class="item" id="centre">

				<h1>Accueil</h1>
				<p>Bienvenue dans notre boutique</p>

			</div>

		</div>

		<div class="sidenav">

			<h1>Menu</h1>
			<ul>
				<li><a href="">Accueil</a></li>
				<li><a onClick='JavaScript:envoieRequete("Categorie","centre")'>Catégoriesss</a></li>
				<li><a onClick='JavaScript:envoieRequete("Panier","centre")'>Mon panier</a></li>
			</ul>

		</div>
	
		<div class="clearer"><span></span></div>

	</div>

	<div class="footer">&copy; 2010 <a href="">maBootique</a>. Valid <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> &amp; <a href="http://validator.w3.org/check?uri=referer">XHTML</a>. Template design by <a href="http://arcsin.se">Arcsin</a>
	</div>

</div>

</body>

</html>