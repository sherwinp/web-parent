<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-us">
<head>
<meta charset="utf-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>demo</title>
<link href="assets/style/layout.css" type="text/css" rel="stylesheet" />
<link href="assets/style/logon.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="wrap1">
	<div id="wrap2">
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
			<li><p><input value="Login" type="submit" /><a id="register" href="register">Register</a></p></li>
		</ul>
	</form>
	</div>
	</div>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/ajax.js"></script>
<script type="text/javascript" src="assets/js/app.js"></script>
</body>
</html>