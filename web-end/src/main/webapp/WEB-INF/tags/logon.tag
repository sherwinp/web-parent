<%@tag description="logon tab layout tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="url" value="${pageContext.request.contextPath}" />
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-us">
<head>
<meta charset="utf-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache, no-store" />
<meta name="viewport" content="width=device-width" />
<title>demo[${url}]</title>
<link href="assets/style/layout.css" type="text/css" rel="stylesheet" />
<link href="assets/style/logon.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="wrap1">
		<jsp:doBody />
	</div>
	<script type="text/javascript" src="assets/js/logon.js"></script>
</body>
</html>
</html>