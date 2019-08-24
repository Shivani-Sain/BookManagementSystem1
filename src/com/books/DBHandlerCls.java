package com.books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBHandlerCls {
	DBHandlerCls(){
		try {
					} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean addBookInDB(String bookId, String bookName,String qty) {
		String query = "insert into book(bookid,bookname,quantity)values(?,?,?)";
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con = null;
		int insertionDone = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			pst = con.prepareStatement(query);
			pst.setInt(1, Integer.valueOf(bookId));
			pst.setString(2,bookName);
			pst.setInt(3,Integer.valueOf(qty));
			insertionDone = pst.executeUpdate();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(con != null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
			}
		if(insertionDone>0){
		return true;	
		}else{
			return false;
		}
}
	public List<BooksBean> retrieveBookfromDB(String bookName) {
		// TODO Auto-generated method stub
		String query = "select * from book where bookname=?";
		List<BooksBean> bookBean = new ArrayList<BooksBean>();
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con = null;
		BooksBean book = new BooksBean();
		boolean insertionDone = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			pst = con.prepareStatement(query);
			pst.setString(1,bookName);
			ResultSet resultSet = pst.executeQuery();
			while(resultSet.next()){
				book.setBookName(resultSet.getString("bookname"));
				book.setId(resultSet.getInt("bookid"));
				book.setQty(resultSet.getInt("quantity"));
				bookBean.add(book);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(con != null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
		return bookBean;
}
	public boolean deleteFromDb(String bookName) {
		int deleted = 0;
		String query="delete from book where bookname=?";
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con = null;
		BooksBean book = new BooksBean();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");

			pst = con.prepareStatement(query);
			pst.setString(1,bookName);
			deleted = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(con != null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
	}
		if(deleted>0)
			return true;
		else
			return false;
}
	public List<BooksBean> listOfBook() {
		List<BooksBean> bookBean = new ArrayList<BooksBean>();
		String query = "select bookname,bookid,quantity from book";
		Statement pst = null;
		ResultSet rst = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			pst = con.createStatement();	
			ResultSet resultSet = pst.executeQuery(query);
			while(resultSet.next()){
				BooksBean book = new BooksBean();
				book.setBookName(resultSet.getString(1));
				book.setId(resultSet.getInt(2));
				book.setQty(resultSet.getInt(3));
				bookBean.add(book);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(con != null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
	}
		return bookBean;
	}
	public boolean updateBook(String name, String updatedId, String updatedName, String updatedQty) {
		int rowAffected = 0;
		// TODO Auto-generated method stub
		String query = "update book set bookid=?,bookname=?,quantity=? where bookname =?";
		PreparedStatement pst = null;
		ResultSet rst = null;
		Connection con = null;
		BooksBean book = new BooksBean();
		boolean insertionDone = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			pst = con.prepareStatement(query);	
			pst.setInt(1,Integer.valueOf(updatedId));
			pst.setString(2,updatedName);
			pst.setInt(3,Integer.valueOf(updatedQty));
			pst.setString(4,name);
			rowAffected = pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(con != null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		if(rowAffected>0){
		return true;
		}else{
		return	false;
		}
	}
}
}
