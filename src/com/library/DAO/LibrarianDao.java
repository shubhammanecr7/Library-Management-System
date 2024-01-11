package com.library.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.library.beans.Librarian;

public class LibrarianDao {
	//method to add new librarian
	public int addLibrarian(Librarian librarian) {
		int i=0;
		String sql="insert into librarian values (?,?,?,?,?)";
		try 
		{
			Connection connection=DataBase.getConnection();
			PreparedStatement ptmt=connection.prepareStatement(sql);
			ptmt.setInt(1, librarian.getId());
			ptmt.setString(2, librarian.getName());
			ptmt.setString(3, librarian.getEmail());
			ptmt.setString(4, librarian.getPassword());
			ptmt.setString(5, librarian.getMobile());
			i=ptmt.executeUpdate();
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//method to update details of librarian
	public int updateLibrarian(Librarian librarian)
	{
		int i=0;
		String sql="update librarian set name=?,email=?,password=?,mobile=? where id=?";
		try 
		{
			Connection connection=DataBase.getConnection();
			PreparedStatement ptmt=connection.prepareStatement(sql);
			ptmt.setString(1, librarian.getName());
			ptmt.setString(2, librarian.getEmail());
			ptmt.setString(3, librarian.getPassword());
			ptmt.setString(4, librarian.getMobile());
			ptmt.setInt(5, librarian.getId());
			i=ptmt.executeUpdate();
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//method to delete a librarian
	public int deleteLibrarian(int id) 
	{
		int i=0;
		String sql="delete from librarian where id=?";
		try 
		{
			Connection connection = DataBase.getConnection();
			PreparedStatement ptmt=connection.prepareStatement(sql);
			ptmt.setInt(1, id);
			i=ptmt.executeUpdate();
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	//method to validate login credentials
	public boolean validateLogin(String name,String password) 
	{
		boolean mylogin=false;
		String sql="select * from librarian where name=? and password=?";
		try 
		{
			Connection connection=DataBase.getConnection();
			PreparedStatement ptmt=connection.prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.setString(2, password);
			ResultSet rs=ptmt.executeQuery();
			if(rs.next())
			{
				mylogin=true;
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return mylogin;
	}
	//method to view the list of all librarians
	public List<Librarian> viewLibrarians() 
	{
		List<Librarian> list = new ArrayList<Librarian>();
		String sql = "select * from librarian";
		try 
		{
			Connection connection = DataBase.getConnection();
			PreparedStatement ptmt= connection.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) 
			{
				Librarian l = new Librarian();
				l.setId(rs.getInt(1));
				l.setName(rs.getString(2));
				l.setEmail(rs.getString(3));
				l.setPassword(rs.getString(4));
				l.setMobile(rs.getString(5));
				list.add(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//method to update the password of librarian
	public int updatePassword(String name,String password) {
		String sql= "update librarian set password=? where name=?";
		int i=0;
		try 
		{
			Connection connection = DataBase.getConnection();
			PreparedStatement ptmt=connection.prepareStatement(sql);
			ptmt.setString(1, password);			
			ptmt.setString(2, name);			
			i = ptmt.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}