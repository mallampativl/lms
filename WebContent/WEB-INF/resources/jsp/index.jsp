<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>LeavePortal</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

<script type="text/javascript" src="resources/js/leave.js"></script>
</head>
<body>
	<form method="POST" action="save">
		Name:<input type="text" name="name"> 
			<br><br>
		Start Date:<input type="text" id="fromDate" name="fromDate" autocomplete="off"> 
		End Date:<input  type="text" id="toDate" name="toDate" autocomplete="off">
		Number Of Days:<input type="text" class='calculated' name="no_of_days"  readonly="readonly"/>
		<input type="submit" value="submit">
	
	</form>
</body>
</html>