<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>customer registration form</title>
		
		<style>
			.error{color: red}
		</style>
	</head>
	<body>
		<form:form action = "processForm" modelAttribute = "customer">
		firstName <form:input path = "firstName"></form:input>
		<br><br>
		
		lastName(*) <form:input path = "lastName"></form:input>
		<form:errors path = "lastName" cssClass = "error"></form:errors>
		<br><br>
		
		freePasses <form:input path = "freePasses"></form:input>
		<form:errors path = "freePasses" cssClass = "error"></form:errors>
		<br><br>
		
		postal code <form:input path = "postalCode"></form:input>
		<form:errors path = "postalCode" cssClass = "error"></form:errors>
		<br><br>
		
		course code <form:input path = "courseCode"></form:input>
		<form:errors path = "courseCode" cssClass = "error"></form:errors>
		<br><br>
		
		<input type = "submit" value = "Submit"></input>
		</form:form>
	</body>
</html>