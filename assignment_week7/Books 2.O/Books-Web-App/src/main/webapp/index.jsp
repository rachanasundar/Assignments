<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>

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
<body >
<div class="body">
<header>
<div align="right">
<%

	Object objName= session.getAttribute("objectName");
	Object objLogInResult= session.getAttribute("objLogInResult") ;
	

	if(objName==null){
%>
	
		<h4> Log In to Enjoy More Features</h4>
		<a href ="login.jsp" ><button class ="btn">LOG IN</button></a> 
	
<%	 }
	else {
			%>
			<a href ="logout.jsp"><button class ="btn" >LOG OUT</button></a>  
<%			}
		if(objLogInResult!=null){
			out.print("<br/>"+objLogInResult);	
		}
		
			
%>	</div>
		<hr size="5px" color="black">
		<h1 >BOOKS COLLECTIONS</h1>
		<hr size="5px" color="black">
		<h3  > If you don't like to read, you haven't found the right book. Find a book to read from our collections</h3>
<%  
		if(objName!=null){
		out.print("<h3>Welcome "+objName+ ", enhance your knowledge by reading these book! </h3>");
		}
%>
</header>

<br/>
<div>
	<ul> 
<a href ="displayBooks.jsp"><button class ="btn">View Books</button> </a><br/><br>
	</ul>
 </div>

<%
if(objName!=null){
	%>
	<div> 
	<a href ="like.jsp"><button class ="btn">Liked Books</button> </a><br/><br>
	<a href ="readLater.jsp"><button class ="btn">Read Later Books</button></a>
	</div>
	
	<%
}
%>

</div> 
</body>
</html>