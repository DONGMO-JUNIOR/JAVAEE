<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="assets/css/style.css"/>
</head>

<style>

.error{
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
		background-color: rgb(255, 255, 250);
	flex-direction: column

	
}
a{
  font-size:20px;
  color:white;
  
  text-decoration:none;
}
.text-error{
	color: red;
	font-size: 40px;
	font-family: Georgia, 'Times New Roman', Times, serif;
}
.a{
width:200px;
height:30px;
background-color: blue;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius:10px;
	margin-top:100px;
}


</style>
<body>

<div class="error"> 
  
  <div class="text-error">
    erreur de connexion <strong>mot de passe</strong> ou  <strong> adresse email</strong>  incorrect!
  
  </div>
  <div class="a">
   <a href="connection.jsp">retour</a>
   </div>
   
</div>
</body>
</html>