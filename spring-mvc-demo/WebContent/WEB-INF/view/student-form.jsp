<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
 <title>Student Registration</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName"/>
		<br><br>
		Last name: <form:input path="lastName"/>
		<br><br>
		Country:
		<form:select path="country">
			<form:options items="${student.countryOptions }"/>

		
		</form:select>
		<br><br>
		Favorite language:
		Java <form:radiobutton path="favLanguage" value="Java"/>
		C# <form:radiobutton path="favLanguage" value="C#"/>
		PHP <form:radiobutton path="favLanguage" value="PHP"/>
		Ruby <form:radiobutton path="favLanguage" value="Ruby"/>
		
		<br><br>
		
		Favorite OS:
		Linux <form:checkbox path="favOS" value="Linux"/>
		MAC OS <form:checkbox path="favOS" value="MAC OS"/>

		<br><br>
		<input type="submit" value="Submit">
		
	</form:form>

</body>
</html>