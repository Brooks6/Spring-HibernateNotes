<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>student registration form</title>
	</head>
	<body>
		<form:form action = "processForm" modelAttribute = "student">
			First name: <form:input path = "firstName"/> getFirstName() 
			<br><br>
			
			Last name: <form:input path = "lastName"/> getLastName()
			<br><br>
			
			<form:select path = "country">
				<!--
				<form:option value = "CN" label = "China"></form:option>
				<form:option value = "AU" label = "Australia"></form:option>
				<form:option value = "JP" label = "Japan"></form:option>
				-->
				<form:options items = "${student.countryOptions}"></form:options>
				<br><br>
				
				favorite Language:
				Java <form:radiobutton path = "favoriteLanguage" value = "Java"></form:radiobutton>
				C++ <form:radiobutton path = "favoriteLanguage" value = "Java"></form:radiobutton>
				C# <form:radiobutton path = "favoriteLanguage" value = "Java"></form:radiobutton>
				Python <form:radiobutton path = "favoriteLanguage" value = "Java"></form:radiobutton>
				C <form:radiobutton path = "favoriteLanguage" value = "Java"></form:radiobutton>
				<br><br>
				
				Operating Systems:
				Linux <form:checkbox path = "operatingSystems" value = "linux"></form:checkbox>
				Mac OS <form:checkbox path = "operatingSystems" value = "Mac OS"></form:checkbox>
				MS Windows <form:checkbox path = "operatingSystems" value = "MS Windows"></form:checkbox>
				<br><br>
			</form:select>
			
			<br><br>
			<input type = "submit" value = "Submit"> setFirstName(), setLastName
		</form:form>
	</body>
</html>