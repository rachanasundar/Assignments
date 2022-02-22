<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Log In</title>

<style type="text/css">
 body{
            background-image: url("https://media.gettyimages.com/photos/open-book-picture-id200536189-001?k=20&m=200536189-001&s=612x612&w=0&h=8xD79lLCc3n8_vO8T3ZxWykSTcTP6cXnJ_JoIfpE6HE=");
            background-repeat:inherit;
             background-repeat:inherit;
            height: 100%;
    text-align: center;
        }
        
   .login{
    font-family: "Arial";
    color:black;
    font-size: 20px;
    font-weight: 500;
    
    
}   

.btn {
    white-space: normal !important;
     border-radius: 5px;
    background-color:rgb(69, 128, 238);
    padding :5px;
}  
</style>
</head>
<body class = login>
<hr size="5px" color="black">
<h1>BOOKS COLLECTIONS</h1>
<hr size="5px" color="black">
<h2> Welcome!<br></h2>
<h3> Please Log in to Proceed</h3>
<form action ="LogInController" method = "post"> 
		<h3> Log In</h3>
		<label > Phone Number</label>
		<input type ="text" name = "phoneNumber" required minlenght ="10"> <br/>
		<label> Password &emsp;</label>
		<input type ="password" name = "pass"  required minlength="5" > <br/><br>
		<input type= "submit" value = "SUBMIT" class = "btn" >
		<input type= "reset" value = "RESET"  class = "btn" > <br/>
		
</form>
<br>
<a href ="signin.jsp"><button class = "btn" >Click here to SIGN IN</button>  </a>
</body>
</html>