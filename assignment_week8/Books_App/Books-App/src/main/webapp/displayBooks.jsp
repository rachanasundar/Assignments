<%@page import="java.util.Iterator"%>
<%@page import="com.booksmanagement.bean.Books"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>

<style type="text/css">
 body{
            background-image: url("https://media.gettyimages.com/photos/open-book-picture-id200536189-001?k=20&m=200536189-001&s=612x612&w=0&h=8xD79lLCc3n8_vO8T3ZxWykSTcTP6cXnJ_JoIfpE6HE=");
            background-repeat:inherit;
            font-family: "Arial";
            height: 100%;
   		
        }
       
  .btn {
    white-space: normal !important;
     border-radius: 5px;
    background-color:rgb(69, 128, 238);
    padding :5px;
}      
.conatiner{
            
            
            display: flex;
            justify-content: inherit;
            
        }

        .card{
            width : 250px;
             margin:10px;
             background: gray;
        }
        .card-image{
            background-size: cover;
        }    
        
</style>

</head>
<body>

<%
Object objName= session.getAttribute("objectName");
Object objNumb=session.getAttribute("objNumber");
Object obj = session.getAttribute("objBooks");

List<Books> listOfBooks = (List<Books>)obj;
Iterator<Books> ii = listOfBooks.iterator();

if(objName==null){
%>
<div align="right">
	<h4> Log In to Enjoy More Features</h4>
	<a href ="loginbtn.spring" ><button class ="btn">LOG IN</button></a> </div>

<%	 }
else {
		%><div align="right">
		<a href ="logout.spring"><button class ="btn" >LOG OUT</button></a>  </div>
<%			}%>

<div align="center">
<hr size="5px" color="black">
		<h1 >BOOKS COLLECTIONS</h1>
		<hr size="5px" color="black">
<% 
if(objName!=null){
	out.print("<h3>Welcome "+objName+ ", enhance your knowledge by reading these books! </h3>");
	}
%>

	
	<section class =" container">
	
	<%	while(ii.hasNext()){
		Books book = ii.next();
	%>
	<div class="card">
		
			<div class ="card-image">
			<img src="<%= book.getBookImageUrl() %>" alt="book_image" align="middle" border="px" width="150px" height="200px">
			</div>
				<p align="left">	Book ID     	: <%=book.getBookId() %><br/>
					Book Title  	:<%= book.getBookName()%><br/>
					Authour     	: <%=book.getAuthor() %><br/>
					Genre       	: <%=book.getBookGenre() %><br/>
					Rating      	: <%=book.getBookRating() %>/5<br/>
					Publisher   	:<%=book.getBookPublisher()%>
				</p>
	
<% 
//only when the user logins
if(objName!=null){ %>		
		
		<div align="center"> 
			<form action="likebook.spring" method="post">
					<input type="hidden" name="likedBookId" value="<%= book.getBookId()%>" >
					<input type="hidden" name="userNumber" value="<%=objNumb %>" >
					<input type ="submit" value = "Like" name = "like" class ="btn">			
			</form>
			
		</div>
<br/>
		 <div align="center">
				<form action="readbook.spring" method="post">
						 <input type="hidden" name="readLaterBookId" value="<%= book.getBookId()%>" >
						 <input type="hidden" name="userNumber" value="<%=objNumb %>" >
						 <input type ="submit" value = "Read Later" name = "readLater" class ="btn">
				</form>
				
		 </div>
	
		  
<%  } %>
</div>
	</section>
	
<%	
	}
%>
<%
if(objName!=null){
	%>
	<div> 
	<a href ="like.spring"><button class ="btn">Liked Books-----></button> </a><br/><br>
	<a href ="readlater.spring"><button class ="btn">Read Later Books-----></button></a><br/><br>
	
	</div>
	
	<%
}
%>
<a href ="home.spring"><button class ="btn">Home -----></button></a><br/>
</div>
</body>
</html>