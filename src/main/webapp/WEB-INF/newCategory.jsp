<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>NEW CATEGORY</h1>
<form:form action="/categories/new" method="post" modelAttribute="categoria">
<p>
<form:label path="name"> Name: </form:label>
<form:input path="name"/>
</p>
<input type="submit" value="Create">
</form:form>
</body>
</html>