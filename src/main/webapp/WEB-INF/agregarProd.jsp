<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar categoria y agregar productos</title>
</head>
<body>
	<form:form action="/categories/${categoriaID.id}" method="post" modelAttribute="prodValido">
	<h1><c:out value="${categoriaID.name}"/></h1>
		<form:label path="name">ADD Product: </form:label>
					<form:select path="id">
						<c:forEach items="${productos}" var="productos">
							<option value="<c:out value="${productos.id}"/>"> <c:out value="${productos.name }"/>  </option>
						</c:forEach>
					</form:select>   
	<input type="submit" value="Add">
	
	
		<h1 >Products : </h1>
			<c:forEach items="${categoria.products}" var="asociados">
				<h3><c:out value="${asociados.name}"/></h3>			
			
			</c:forEach>
	


</form:form>
	

</body>
</html>