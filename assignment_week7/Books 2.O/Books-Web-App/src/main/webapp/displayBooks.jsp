
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

<%//Object objName= session.getAttribute("objectName");
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
	}
%>

<%
if(objName!=null){
	%>
	<div> 
	<a href ="like.jsp"><button class ="btn">Liked Books-----></button> </a><br/><br>
	<a href ="readLater.jsp"><button class ="btn">Read Later Books-----></button></a>
	</div>
	
	<%
}
%>

</body>
</html>
