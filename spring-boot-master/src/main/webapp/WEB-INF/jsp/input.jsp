<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello ${name}!</title>
</head>
<body>
	<h2 class="hello-title">Mathematical Calculator</h2>
	<form:form action="submitForm" modelAttribute="expression" id="form">
		<div class="row">
			<span style="color: red">*</span>Question:
			<form:input path="expressionQuestion" />
			<span style="color: red; display: none" id="errMsg"></span>
		</div>
		<br>
		<br>
		<div>
			Answer:
			<form:input path="expressionAnswer" readonly="true" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>
	<br>
	<br> History
	<br>
	<c:forEach items="${list}" var="item">
	    ${item.expressionQuestion}=${item.expressionAnswer}<br>
	</c:forEach>
	<script src="/js/jquery.min.js"></script>
	<script src="/js/input.js"></script>
</body>
</html>
