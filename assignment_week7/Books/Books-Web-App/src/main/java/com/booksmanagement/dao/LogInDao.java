package com.booksmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.booksmanagement.bean.LogIn;
import com.booksmanagement.resource.DbResource;

public class LogInDao {
	
	//to create a new account
	public int createNewAccount(LogIn user) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement psmt= con.prepareStatement("insert into login value(?,?,?,?)");
			
			psmt.setLong(1, user.getPhoneNumber());
			psmt.setString(2, user.getEmailId());
			psmt.setString(3, user.getName());
			psmt.setString(4, user.getPassword());
 
			return psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("createNewAccoun"+ e);
			return 0;
		}
	}
	
	
	//to verify password
	public boolean verifyPassword(Long phNumber, String pass) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement psmt= con.prepareStatement("select password from login where phonenumber = ?");
		
			psmt.setLong(1,phNumber);
			ResultSet rs= psmt.executeQuery();
			
				if(rs.next()) {
					String password = rs.getString(1);
					if (pass.equals(password)) {
						return true;
					}
				}
			}catch (Exception e) {
				System.out.println("verifyPasswordn"+ e);
		}
		return false;
		
	}
	
	
	//to get name from database using phone number
	public String getName(long phNum) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement psmt= con.prepareStatement("select name from login where phonenumber = ?");
			psmt.setLong(1,phNum);
			ResultSet rs= psmt.executeQuery();
		
			if(rs.next()) {
				String name = rs.getString(1);
				return name;			
				}
			
		}catch (Exception e) {
			System.out.println("getNam"+e);
		}
		return null;
	}
	
	//to store the details of user and books id under Read later books session
	public int storeReadLaterBook(long phNum, int bookId) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement psmt= con.prepareStatement("insert into readlater value(?,?)");
			psmt.setLong(1, phNum);
			psmt.setInt(2, bookId);
			int res= psmt.executeUpdate();
			return res;
			
		} catch (Exception e) {
			System.out.println("storeReadLaterBook");
			return 0;
		}
	}
	
	//to store the details of user and books id under Liked books session
	public int storeLikedBook(long phNumber, int bookId) {
		try {
				Connection con = DbResource.getDbConnection();
				PreparedStatement psmt= con.prepareStatement("insert into likedBooks value(?,?)");
				psmt.setLong(1, phNumber);
				psmt.setInt(2, bookId);
				int res= psmt.executeUpdate();
				return res;
			} catch (Exception e) {
				System.out.println("storeLikedBook");
				return 0;
				
			}
			
		}
	
	//to retrieve all the book ids from database of a user stored in Liked session 
	public List<Integer> getLikedBookIds(long phNumber) {
		List<Integer> storedBookIds= new ArrayList<>();
		Connection con = DbResource.getDbConnection();
		try {
			PreparedStatement psmt= con.prepareStatement("select bookid from likedBooks where phonenumber=?");
			psmt.setLong(1, phNumber);
			ResultSet rs= psmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				storedBookIds.add(id);			
				}	
		} catch (SQLException e) {
			System.out.println("getLikedBookIds"+e);
		}
		return storedBookIds;
	}
	
	//to retrieve all the book ids from database of a user stored in Read later session 
	public List<Integer> getReadLaterBookIds(long phNumber) {
		List<Integer> storedBookIds= new ArrayList<>();
		Connection con = DbResource.getDbConnection();
		try {
			PreparedStatement psmt= con.prepareStatement("select bookid from readlater where phonenumber=?");
			psmt.setLong(1, phNumber);
			ResultSet rs= psmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				storedBookIds.add(id);			
				}
			
			return storedBookIds;
		} catch (SQLException e) {
			System.out.println("getReadLaterBookIds"+ e);
		}
		return null;
	}

}
