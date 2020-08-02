<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello ${name}!</title>
</head>
<body>
	<h2 class="hello-title">Demo of form:hidden form:checkbox</h2>
	<br>
	<form:form action="" modelAttribute="expression" id="form">
		<div class="row">
			<form:hidden path="expressionContent" />
			<form:button id="button">Click to see the hidden value</form:button>
		</div>
		<div class="row">
			<form:checkbox path="" value="" id="checkbox" />
		</div>
		<br>
		<br>
	</form:form>
	<script src="/js/jquery.min.js"></script>
	<script src="/js/input.js"></script>
</body>
</html>
