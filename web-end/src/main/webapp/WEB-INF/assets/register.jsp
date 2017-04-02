<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:logon><body>
	<div id="wrap2">
	<div id="nav" class="tabs">
		<a class="" rel="nofollow" href="index">Login</a>
		<a class="active" rel="nofollow" href="register">Register</a>
		<a class="" rel="nofollow" href="resetpassword">Reset Password</a>
	</div>
	<form:form name="pform" id="pform" action="register" method="post">
		<ul>
			<li><label>User Name:</label><form:input path="Email_address" type="text"
				placeholder="Email Address" /></li>
			<li><label>Phone Number:</label><form:input path="Phone_number" type="text" 
				placeholder="Phone Number" /></li>
			<li><label>Postal Code:</label><form:input path="Postal_code" type="text" 
				placeholder="Postal Code" /></li>
			<li><p><input value="Register" type="submit" /></p></li>
		</ul>
	</form:form>
	</div>
</t:logon>