<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:logon><body>
	<div id="wrap2">
	<div id="nav" class="tabs">
		<a class="" rel="nofollow" href="home">Login</a>
		<a class="" rel="nofollow" href="register">Register</a>
		<a class="active" rel="nofollow" href=".">Reset Password</a>
	</div>
	<form id="frm" action="j_security_check" method="post">
		<ul>
			<li><label>User Name:</label><input id="j_username" type="text"
				placeholder="email address" /></li>
			<li><p><input value="Reset Password" type="submit" /></p></li>
		</ul>
	</form>
	</div>
		<hr />
 	<d:debugsection />
 	</body>
</t:logon>