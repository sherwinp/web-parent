<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="mySection" prefix="d" %>
<t:wrapper>
	<body>

		<div class="row">
			<form:form name="pform" id="pform" action="." method="get">
				<a href="${url}">here</a>
				<a href="4004/9">and here</a>
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
							<li>Root node 1
								<ul>
									<li id="2">Child node 1</li>
									<li id="3">Child node 2</li>
									<li id="4">Child node 3</li>
									<li id="5">Child node 4</li>
								</ul>
							</li>
							<li class="jstree-open">Root node 2
								<ul>
									<li id="7">Child node 5</li>
									<li id="8">Child node 6</li>
									<li id="9">Child node 7</li>
									<li id="10">Child node 8</li>
								</ul>
							</li>
							<li>Root node 3
								<ul>
									<li id="12">Child node 9</li>
									<li id="14">Child node 10</li>
									<li id="17">Child node 11</li>
									<li id="19">Child node 12</li>
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
				<form:hidden path="tselector" />
			</form:form>
		</div>
		<div></div>
		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script type="text/javascript" src="assets/js/jstree/jstree.min.js"></script>
		<script type="text/javascript" src="assets/js/app.js"></script>
		<hr />
		<d:debugsection />

	</body>
</t:wrapper>