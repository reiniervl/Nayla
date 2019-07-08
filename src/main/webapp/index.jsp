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
				<li><a href="registreer.jsp">registreer</a></li>
			</ul>
		</nav>
		<div class="account_menu">
		<%
		Object usernameObj = session.getAttribute("username");
		String username = "parent";
		if(usernameObj != null) {
			username = (String)usernameObj;
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
	<p>Hello, <%=username%>
</body>

</html>