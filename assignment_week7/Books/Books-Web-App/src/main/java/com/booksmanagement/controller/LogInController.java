package com.booksmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booksmanagement.bean.LogIn;
import com.booksmanagement.service.LogInService;
import com.mysql.cj.Session;

/**
 * Servlet implementation class LogInController
 */
@WebServlet("/LogInController")
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession hs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		LogInService service= new LogInService();
		int bookId = 0;
		long phoneNumber=0;
		
		hs =request.getSession();
		RequestDispatcher rd1= request.getRequestDispatcher("index.jsp");
		response.setContentType("text/html");
		
		//Login
		if(request.getParameter("phoneNumber")!= null) {
		long userNumber= Long.parseLong(request.getParameter("phoneNumber"));
		String pass= request.getParameter("pass");
		String loginResult = service.checkPassword(userNumber, pass);
		String userName=service.getUserName(userNumber);
		
		hs.setAttribute("objectName", userName);
		hs.setAttribute("objNumber", userNumber);
		hs.setAttribute("objLogInResult", loginResult);
		rd1.include(request, response);
		}
		
		//Sign in
		else if(request.getParameter("phone_number") != null) {
			long phoneNumb= Long.parseLong(request.getParameter("phone_number"));
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String password= request.getParameter("password");
			String signinResult = service.createAccount(new LogIn(phoneNumb, email, name, password));
			
			hs.setAttribute("objectName", name);
			hs.setAttribute("objNumber", phoneNumb);
			hs.setAttribute("objLogInResult",signinResult);
			rd1.include(request, response);
		}
		
		
		//when Like button is clicked 
		else if(request.getParameter("likedBookId")!=null) {
			bookId= Integer.parseInt(request.getParameter("likedBookId"));
			phoneNumber=Long.parseLong(request.getParameter("userNumber"));
			String likedBookResult = service.storeLikedBook(phoneNumber, bookId);
			//hs.setAttribute("objLikedBookResult", likedBookResult);
			pw.print(likedBookResult);
			rd1.include(request, response);
		}
		
		//When read later button is clicked 
		else if(request.getParameter("readLaterBookId")!=null) {
			bookId=Integer.parseInt(request.getParameter("readLaterBookId"));
			phoneNumber=Long.parseLong(request.getParameter("userNumber"));
			String readLaterBookResult = service.storeReadLaterBook(phoneNumber, bookId);
			//hs.setAttribute("objReadLaterBookResult ", readLaterBookResult );
			pw.print(readLaterBookResult);
			rd1.include(request, response);
		}
		
		
		
		
		
		
		
		
	}

}
