<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:wrapper><body>

<div class="row">
<form name="pform" id="pform" action="." method="post">
<a href="${url}">here</a>
<div class="col-3 menu">
  <ul id="navMenu">
    <li id="1001">The Flight</li>
    <li id="2002">The City</li>
    <li id="3003">The Island</li>
    <li id="4004">The Food</li>
  </ul>
</div>
</form>
<div class="col-9">
  <h1 id="category">The City</h1>
  <p>Chania is the capital of the Chania region on the island of Crete. The city can be divided in two parts, the old town and the modern city.</p>
  <p>Resize the browser window to see how the content respond to the resizing.</p>
</div>
</div>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/ajax.js"></script>
<script type="text/javascript" src="assets/js/app.js"></script>
</body></t:wrapper>