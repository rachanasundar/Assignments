<%@page import="com.booksmanagement.service.BooksService"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.booksmanagement.bean.Books"%>
<%@page import="java.util.List"%>
<%@page import="com.booksmanagement.service.LogInService"%>
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
   		text-align: center;
        }
 
 .btn {
    white-space: normal !important;
     border-radius: 5px;
    background-color:rgb(69, 128, 238);
    padding :5px;
}      
        
</style>
</head>
<body>

<%
		Object objName= session.getAttribute("objectName");
		Object objNumber = session.getAttribute("objNumber");
		
		if(objName!=null){
%>
		<div align="right"><a href ="logout.jsp"><button class ="btn">LOG OUT</button></a> </div>
		<hr size="5px" color="black">
		<h1 >BOOKS COLLECTIONS</h1>
		<hr size="5px" color="black">
<% 
		out.print("<h3>Hey "+objName+ ", these are your LOVED BOOKS </h3>");
		 
		Long phNumber = new Long(objNumber.toString());
		LogInService user = new LogInService();
				
			List<Integer> likedBookList =user.getlikedbooks(phNumber);
				
				if(!likedBookList.isEmpty()){
					Object obj = session.getAttribute("objBooks");
					//List<Books> listOfBooks = (List<Books>)obj;
						BooksService books= new BooksService();
	
			List<Books> listOfBooks = books.getAllBooks();
					Iterator<Books> ii = listOfBooks.iterator();
			
%>
		<table>
					<tr>
						<th>Book Image</th>
						<th>Book Information</th>
					</tr>
<%
				while(ii.hasNext()){
					Books book = ii.next();
				
					if(likedBookList.contains(book.getBookId())){
%>
					<tr>
						<td> <img src="<%= book.getBookImageUrl() %>" alt="book_image" align="middle" border="px" width="150px" height="200px" ></td>
						<td>
								<p align="left">	Book ID     	: <%=   book.getBookId() %><br/>
									Book Title  	:<%= book.getBookName()%><br/>
									Authour     	: <%=book.getAuthor() %><br/>
									Genre       	: <%=book.getBookGenre() %><br/>
									Rating      	: <%=book.getBookRating() %>/5<br/>
									Publisher   	:<%=book.getBookPublisher()%><br/></p>
						</tr>

<%			}
		}  
%>	
		
				</table>	
<% 
				 }
				else{
					out.print("<h4>Sorry Your Collection Of Books Is EMPTY! <h4><br/>");
				}
		}
%>

<a href ="readLater.jsp"><button class ="btn">Read Later Books-----></button></a><br/><br>
<a href ="index.jsp"><button class ="btn">Home page-----></button></a>
</body>
</html>