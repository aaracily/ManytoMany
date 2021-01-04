<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<h1>NEW PRODUCT</h1>
<form:form action="/products/new" method="post" modelAttribute="producto">
<p>
<form:label path="name"> Name: </form:label>
<form:input path="name"/>
</p>
<p>
<form:label path="description"> Description: </form:label>
<form:input path="description"/>
</p>
<p>
<form:label path="price"> Price: </form:label>
<form:input path="price"/>
</p>

<input type="submit" value="Create">
</form:form>
</body>
</html>