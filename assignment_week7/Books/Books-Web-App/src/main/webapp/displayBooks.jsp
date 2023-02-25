
<%@page import="com.booksmanagement.service.BooksService"%>
<%@page import="com.booksmanagement.service.LogInService"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.booksmanagement.bean.Books"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>



<style type="text/css">


 body{
            font-family: "Arial";
      }
       tr{
       
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

<%Object objName= session.getAttribute("objectName");
	Object objNumb=session.getAttribute("objNumber");
	//Object objLikedBookResult= session.getAttribute("objLikedBookResult");
	//Object objReadLaterBookResult= session.getAttribute("objReadLaterBookResult");
	//Object rd= session.getAttribute("objReadLaterBookResult");
	//if(objLikedBookResult!= null){
	//	out.print("<br/>"+objLikedBookResult);
	//}
	
	//else if(objReadLaterBookResult!= null){
	//	out.print("<br/>"+objReadLaterBookResult);	
	//}	
%>

<%
	//Object obj = session.getAttribute("objBooks");
	//List<Books> listOfBooks = (List<Books>)obj;
	BooksService books= new BooksService();
	
	List<Books> listOfBooks = books.getAllBooks();
	if(listOfBooks.isEmpty()){
		%>
		<h3> No book to display </h3>
		<%
	}
	else{
	Iterator<Books> ii = listOfBooks.iterator();
	
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
			<form action="LogInController" method="post">
					<input type="hidden" name="likedBookId" value="<%= book.getBookId()%>" >
					<input type="hidden" name="userNumber" value="<%=objNumb %>" >
					<input type ="submit" value = "Like" name = "like" class ="btn">			
			</form>
			
		</div>
<br/>
		 <div align="center">
				<form action="LogInController" method="post">
						 <input type="hidden" name="readLaterBookId" value="<%= book.getBookId()%>" >
						 <input type="hidden" name="userNumber" value="<%=objNumb %>" >
						 <input type ="submit" value = "Read Later" name = "readLater" class ="btn">
				</form>
				
		 </div>
	
		  
<%  } %>
</div>
	</section>
	
<%	
	}}
%>



</body>
</html>
