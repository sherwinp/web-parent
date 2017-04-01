<%@tag description="standard layout tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="url" value="${pageContext.request.contextPath}" />
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-us">
<head>
<meta charset="utf-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="pragma" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>demo[${url}]</title>
<link href="assets/style/layout.css" type="text/css" rel="stylesheet" />
<link href="assets/js/jstree/style.min.css" type="text/css" rel="stylesheet" />
</head>
<jsp:doBody />
</html>
