<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Customer Registration</title>
	<style>
		.error {color: red}
	</style>
	<i>Fill out the form. Asterisk (*) means required</i>
	<form:form action="processForm" modelAttribute="customer">
	
		First name: <form:input path="firstName"/>
		<br><br>
		Last name (*): <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		<br><br>
		Number of free passes (*):<form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"/>
		<br><br>
		Postal code:<form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		<br><br>
		Course code:<form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>
		<br><br>
		<input type="submit" value="Submit">
	</form:form>

</head>
<body>

</body>
</html>