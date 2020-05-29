<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Alerta</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="hello.js"></script>
    
</head>
<body>
<c:import url="Menu.jsp"/>
	
        ${tempMin} <br>
        ${tempMax} <br>
        ${temp}
	
	<script type="text/javascript">
	setTimeout(function(){window.top.location="ThingspeakController?tempMin=${tempMin}&tempMax=${tempMax }"} , 5000);
	</script>

</body>
</html>