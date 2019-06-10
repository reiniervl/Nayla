<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Inloggen</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<header>
	<div class="ribbon">
		<div class="brand">
			<span>Nayla</span>
		</div>
		<nav>
			<ul>
				<li><a href="#">home</a></li>
				<li><a href="#">overzicht</a></li>
				<li><a href="#">vandaag</a></li>
			</ul>
		</nav>
		<div class="account_menu">
		<%
		Object usernameObj = session.getAttribute("username");
		if(usernameObj != null) {
			String username = (String)usernameObj;
		%>
			<a href="app/account/uitloggen"><%=username%></a>
		<%
		} else {
		%>
			<a href="inloggen.jsp">inloggen</a>
		<%
		}
		%>
		</div>
	</div>
</header>

<body>
	<form id="inloggen" action="app/registreer" method="POST">
		<div>
			<input name="username" id="username" type="text" minlength="4" placeholder="username">
		</div>
		<div>
			<input name="voornaam" id="voornaam" type="text" minlength="4" placeholder="voornaam">
		</div>
		<div>
			<input name="achternaam" id="achternaam" type="text" minlength="4" placeholder="achternaam">
		</div>
		<div>
			<input name="email" id="email" type="email" placeholder="email">
		</div>
		<div>
			<input name="password" id="password" type="password" minlength="4" placeholder="password">
		</div>
		<input type="submit" value="registreer">
	</form>
</body>

</html>