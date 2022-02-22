<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.booksmanagement.bean.Books"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liked Books</title>
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
<%
		Object objName= session.getAttribute("objectName");
		Object objNumber = session.getAttribute("objNumber");


%><div align="right">
		<a href ="logout.jsp"><button class ="btn" >LOG OUT</button></a>  </div>
		
		<div align="center">
<hr size="5px" color="black">
		<h1 >BOOKS COLLECTIONS</h1>
		<hr size="5px" color="black">		
<%				
		//to display user name 
		if(objName!=null){
			
			out.print("<h3>Hey "+objName+ ", these are your LOVED BOOKS </h3>");

		}

//to get list of liked books from controller 
Object objLikedBook= session.getAttribute("objLikedBookList");
List<Books> listOfLikedBooks = (List<Books>)objLikedBook;

//to check if the list if liked books is empty 
if(listOfLikedBooks.isEmpty()){
	out.print("<h4>Sorry Your Collection Of Books Is EMPTY! <h4><br/>");
	
}else{
	
	%>
	<table>
				<tr>
					<th>Book Image</th>
					<th>Book Information</th>
				</tr>
<%

//to avoid display of repated liked books 
List<Integer> bookIds = new ArrayList<>();
Iterator<Books> ii = listOfLikedBooks.iterator();
			while(ii.hasNext()){
				Books book = ii.next();
				
				//to avoid display of repated liked books 
				if(!bookIds.contains(book.getBookId())){
					bookIds.add(book.getBookId());
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
					
					
					<%
				
			}
}
}		
%>
</table>
<div> 
	<a href ="readlater.spring"><button class ="btn">Read Later Books-----></button></a><br/><br>
	<a href ="home.spring"><button class ="btn">Home -----></button></a><br/><br/>
	<a href="books.spring"><button class = "btn">View All Books----></button> </a>	</div>
</div>	
</body>
</html>