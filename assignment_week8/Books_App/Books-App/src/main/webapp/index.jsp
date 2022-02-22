<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>

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

<body>
<div >

<%
Object objName= session.getAttribute("objectName");
Object objLogin= session.getAttribute("objLogInResult");
Object objLikebook= request.getAttribute("objStoreBookResult");
if(objLikebook!=null){
out.print(objLikebook+"<br>");
}


if(objName==null){
	if(objLogin!=null){ 
	out.print(objLogin);
	}
	
%>
	<div align="right">
	<h4> Log In to Enjoy More Features</h4>
	<a href ="loginbtn.spring" ><button class ="btn">LOG IN</button></a> </div>

<%	 }
else {out.print(objLogin +"<br>");
		%><div align="right">
		<a href ="logout.spring"><button class ="btn" >LOG OUT</button></a>  
<%			}%>
</div>
<div align="center">
<hr size="5px" color="black">
		<h1 >BOOKS COLLECTIONS</h1>
		<hr size="5px" color="black">
		<h3  > If you don't like to read, you haven't found the right book. Find a book to read from our collections</h3>


<%

if(objName!=null){
	out.print("<h3>Welcome "+objName+ ", enhance your knowledge by reading these books! </h3>");
	}
%>

<a href="books.spring"><button class = "btn">View All Books----></button> </a><br/><br>
<%
if(objName!=null){
	%>
	<div> 
	<a href ="like.spring"><button class ="btn">Liked Books-----></button> </a><br/><br>
	<a href ="readlater.spring"><button class ="btn">Read Later Books-----></button></a>
	</div>
	
	<%
}
%>
</div>
</body>
</html>