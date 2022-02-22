<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>

<style type="text/css">
 body{
            background-image: url("https://media.gettyimages.com/photos/open-book-picture-id200536189-001?k=20&m=200536189-001&s=612x612&w=0&h=8xD79lLCc3n8_vO8T3ZxWykSTcTP6cXnJ_JoIfpE6HE=");
            background-repeat:inherit;
            font-family: "Arial";
            height: 100%;
   		
        }
 .body{
 text-align: center;} 
 .btn {
    white-space: normal !important;
     border-radius: 5px;
    background-color:rgb(69, 128, 238);
    padding :5px;
}      
        
</style>

</head>
<body>
<div align="center">
<hr size="5px" color="black">
		<h1 >BOOKS COLLECTIONS</h1>
		<hr size="5px" color="black">
<h2 > Create A New Account </h2>
<h3 > Sign In</h3>
<form  action ="signin.spring" method = "post" >
<label class = "login"> Phone Number</label>
<input type ="text" name = "phone_number" required minlenght ="10"> <br/><br>
<label class = "login"> E-mail ID&emsp;</label>
<input type ="email" name = "email" required> <br/><br>
<label class = "login"> UserName&emsp;</label>
<input type ="text" name = "name" required> <br/><br>
<label class = "login"> Password&emsp;</label>
<input type ="password" name = "password" id ="password"  required minlength="5"> <br/><br>

<input type= "submit" value = "CREATE" id ="submit" class ="btn">
<input type= "reset" value = "RESET"class ="btn" >

</form>
</div>
</body>
</html>