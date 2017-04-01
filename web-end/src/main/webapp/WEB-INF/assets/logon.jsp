<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:logon><body>
	<div id="wrap2">
	<div id="nav" class="tabs">
		<a class="active" rel="nofollow" href="secured">Login</a>
		<a class="" rel="nofollow" href="register">Register</a>
		<a class="" rel="nofollow" href="resetpassword">Reset Password</a>
	</div>
	<form id="frm" action="j_security_check" method="post">
		<ul>
		<li><label>User Name:</label><input id="j_username" name="j_username" type="text" placeholder="email address" /></li>
		<li><label>Password:</label><input id="j_password" name="j_password" type="password" placeholder="secret password" /></li>
		<li><p><input value="Login" type="submit" /></p></li>
		</ul>
	</form>
	</div>
</t:logon>