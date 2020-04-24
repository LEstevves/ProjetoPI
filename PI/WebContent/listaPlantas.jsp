<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page import="model.Estufa" %>
 <%@page import="java.util.List" %>
  <%@page import="java.util.Iterator" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plantas</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<c:import url="Menu.jsp"/>
	
	<fieldset>
		<legend>Plantas cadastradas:</legend>
		<table border="1" >
			<tr>
			 <th> ID </th>
			 <th>Nome</th>
			 <th>Temperatura Mínima</th>
			 <th>Temperatura Máxima</th>
			 <th>Umidade do Ar Mínima</th>
			 <th>Umidade do Ar Máxima</th>
			 <th>Umidade do Solo Mínima</th>
			 <th>Umidade do Solo Máxima</th>
			</tr>	
			
			<c:forEach	var="planta" items="${lista}">
			
			<tr>
			
		    <td> <c:out value="${planta.id}"/> </td>
			<td> <c:out value="${planta.nome}"/> </td>
			<td> <c:out value="${planta.tempMin}"/> </td>
			<td> <c:out value="${planta.tempMax}"/> </td>
			<td> <c:out value="${planta.umidArMin}"/> </td>
			<td> <c:out value="${planta.umidArMax}"/> </td>
			<td> <c:out value="${planta.umidSoloMin}"/> </td>
			<td> <c:out value="${planta.umidSoloMax}"/> </td> 
			
			</tr>
			</c:forEach> 
	
		</table>
	</fieldset>

</body>
</html>