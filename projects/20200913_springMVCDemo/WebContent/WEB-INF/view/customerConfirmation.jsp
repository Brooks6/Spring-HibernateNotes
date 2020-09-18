<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer confirmation</title>
</head>
<body>
	the customer is confirmed: ${customer.firstName} ${customer.lastName}
	<hr/>
	the freePasses number is: ${customer.freePasses}
	<hr/>
	postal code is: ${customer.postalCode}
	<hr/>
	course code is: ${customer.courseCode}
</body>
</html>