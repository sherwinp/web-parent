<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logon</title>
</head>
<body>
	<ul class="tabs">
		<li><a class="active" rel="nofollow" href="#login">Login</a></li>
		<li><a class="" rel="nofollow" href="#register">Register</a></li>
		<li><a class="" rel="nofollow" href="#reset">Reset Password</a></li>
	</ul>
	<form id="frm" action="j_security_check">
		<ul>
			<li><label>User:</label><input id="j_username" type="text"
				placeholder="email" /></li>
			<li><label>Password:</label><input id="j_password"
				type="password" placeholder="secret password" /></li>
			<li><input value="Login" type="submit" /></li>
		</ul>
		<li><div>
			<a id="register" href="register">Register</a>
		</div></li>
		</ul>
	</form>
</body>
</html>