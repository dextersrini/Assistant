<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to assistant</title>
</head>
<script type="text/javascript">
function getWeather(){
var city = document.getElementById("city").value;
alert(city);
alert(document.forms[0].action);
document.forms[0].action+="weatherapi/"+city;
document.forms[0].submit;
}
</script>
<body>
<form id="weather" action="weatherapi/chennai">
<label>City name</label>
<p><input type="text" id="city">
<input type="submit" value="Get Weather Details">
</form>
</body>
</html>