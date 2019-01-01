<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>

<body>

Welcome!


<br><br>

Student name: ${student.firstName} ${student.lastName }
<br>
Origin country: ${student.country}
<br>
Favorite programming language: ${student.favLanguage }
<br>
Operating System: 
<ul>
	<c:forEach var="temp" items="${student.favOS}">
		<li> ${temp} </li>
	</c:forEach>
</ul>

</body>

</html>