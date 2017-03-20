<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-us">
<head>
<meta charset="utf-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache, no-store" />
<meta name="viewport" content="width=device-width" />
<title>demo</title>
<link href="assets/style/layout.css" type="text/css" rel="stylesheet" />
<link href="assets/style/logon.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="wrap1">
	<div id="wrap2">
	<div id="nav" class="tabs">
		<a class="" rel="nofollow" href="secured">Login</a>
		<a class="active" rel="nofollow" href="register">Register</a>
		<a class="" rel="nofollow" href="resetpassword">Reset Password</a>
	</div>
	<form id="frm" action="j_security_check" method="post">
		<ul>
			<li><label>User Name:</label><input id="j_username" type="text"
				placeholder="email address" /></li>
			<li><label>Phone Number:</label><input id="j_phone"	type="text" 
				placeholder="Phone Number" /></li>
			<li><label>Postal Code:</label><input id="j_postalcode" type="text" 
				placeholder="Postal Code" /></li>
			<li><p><input value="Login" type="submit" /></p></li>
		</ul>
	</form>
	</div>
	</div>
	<script type="text/javascript" src="assets/js/logon.js"></script>
</body>
</html>