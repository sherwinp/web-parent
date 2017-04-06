<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:wrapper>
	<body>

		<div class="row">
			<form:form name="pform" id="pform" action="." method="get">
				<a href="${url}">here</a>
				<a href="logoff">logout</a>
				<div class="col-3 menu">
					<ul id="navMenu">
						<li class="" id="1001">The Flight</li>
						<li class="active" id="2002">The City</li>
						<li class="" id="3003">The Island</li>
						<li class="" id="4004">The Food</li>
					</ul>
					<div class="tree" id="core">
						<ul>
							<li>Root node
								<ul>
									<li>Child node 1</li>
									<li>Child node 2</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-9">
					<h1 id="category">
						<a href="2002">The City - [2002]</a>
					</h1>
					<p>Chania is the capital of the Chania region on the island of
						Crete. The city can be divided in two parts, the old town and the
						modern city.</p>
					<p>Resize the browser window to see how the content respond to
						the resizing.</p>
				</div>
				<form:hidden path="indx" />
			</form:form>
		</div>
		<div></div>
		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script type="text/javascript" src="assets/js/jstree/jstree.min.js"></script>
		<script type="text/javascript" src="assets/js/app.js"></script>
		<hr />
		<h3>Request Scope (key==values)</h3>
		<%
		java.util.Enumeration<String> reqEnum = request.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement();
			out.print(s);
			out.println("==" + request.getAttribute(s));
		%><br />
		<%
		}
		%>
	</body>
</t:wrapper>