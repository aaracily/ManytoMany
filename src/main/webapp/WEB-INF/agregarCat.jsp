<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar producto y agregar categorias</title>
</head>
<body>
<form:form action="/products/${producto.id}" method="post" modelAttribute="categoriaV">
	<h1><c:out value="${producto.name}"/></h1>
		<form:label path="name">ADD Category: </form:label>
					<form:select path="id">
						<c:forEach items="${categorias}" var="cate">
							<option value="<c:out value="${cate.id}"/>"> <c:out value="${cate.name }"/>  </option>
						</c:forEach>
					</form:select>   
	<input type="submit" value="Add">
	
	
		<h1 >Categories</h1>
			<c:forEach items="${producto.categories}" var="asociadas">
				<h3><c:out value="${asociadas.name}"/></h3>			
			
			</c:forEach>
	


</form:form>

</body>
</html>