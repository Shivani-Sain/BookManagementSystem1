package com.books;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		DBHandlerCls db = new DBHandlerCls();
		if(action.equals("addBook")){
			addBook(request,response,db);
		}
		else if(action.equals("updateBook")){
			updateBook(request,response,db);
		}
		else if(action.equals("deleteBook")){
			deleteBook(request,response,db);
		}
		else if(action.equals("listOfBook")){
			listOfBook(request,response,db);
		}
		else if(action.equals("retrieveBook")){
			retrieveBook(request,response,db);
		}
	}

	private void retrieveBook(HttpServletRequest request, HttpServletResponse response,DBHandlerCls db) {
		// TODO Auto-generated method stub
	String bookName=request.getParameter("bookName");
	List<BooksBean> bookBean = db.retrieveBookfromDB(bookName);
	if(bookBean != null && !bookBean.isEmpty()){
	request.setAttribute("bookBean",bookBean);
	RequestDispatcher rd =  request.getRequestDispatcher("booksInfo.jsp");
	try {
		rd.forward(request, response);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}else{
		try {
			response.sendRedirect("DoesNotExist.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

	private void listOfBook(HttpServletRequest request, HttpServletResponse response,DBHandlerCls db) {
		List<BooksBean> bookBean = db.listOfBook();
		if(bookBean != null && !bookBean.isEmpty()){
			request.setAttribute("bookBean", bookBean);
			RequestDispatcher rd = request.getRequestDispatcher("booksInfo.jsp");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			try {
				response.sendRedirect("DoesNotExist.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response,DBHandlerCls db) {
		// TODO Auto-generated method stub
		String bookName =request.getParameter("bookName");
		boolean deleted = db.deleteFromDb(bookName);
		if(deleted){
			try {
				response.sendRedirect("successDeleted.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				response.sendRedirect("failureDeleted.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response,DBHandlerCls db) {
		// TODO Auto-generated method stub
		String name = request.getParameter("bookName");
		String updatedId = request.getParameter("updatedBookId");
		String updatedName = request.getParameter("updatedBookName");
		String updatedQty = request.getParameter("updatedQuantity");
		boolean updated = db.updateBook(name,updatedId,updatedName,updatedQty);
		try{
		if(updated){
			response.sendRedirect("successUpdate.jsp");
		}
		else{
			response.sendRedirect("failureUpdate.jsp");
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response,DBHandlerCls db) {
		// TODO Auto-generated method stub
		String bookId = request.getParameter("bookId");
		String bookName = request.getParameter("bookName");
		String qty = request.getParameter("quantity");
		boolean done = db.addBookInDB(bookId,bookName,qty);
		try {
			if(done){
				response.sendRedirect("successAdd.jsp");
			}
			else{
				response.sendRedirect("failureAdd.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
