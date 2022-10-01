package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Admin;
import com.masai.bean.Buyer;
import com.masai.bean.Item;
import com.masai.bean.Seller;
import com.masai.utility.DBUtil;
import com.mysql.cj.xdevapi.Result;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String resisterAdmin(Admin a) {
	
		String message = "Resistration failed ...";
		
		try(Connection connection = DBUtil.provideConnection()){
			
	PreparedStatement ps=connection.prepareStatement("insert into admins values(?,?,?)");
			
			ps.setString(1, a.getName());
			ps.setString(2,a.getEmail());
			ps.setString(3, a.getPassword());
			
			int check = ps.executeUpdate();
			
			if(check>0) {
				
				message = "Resistration successfull...";
			}

		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		

		return message;
	}

	@Override
	public ArrayList<Buyer> getBuyers() {
	
		ArrayList<Buyer> buyers = new ArrayList<>();
		
		try(Connection connection = DBUtil.provideConnection()){
			
		PreparedStatement ps = connection.prepareStatement("select * from buyers");
		
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			int buyerId = rs.getInt("bid");
			String name = rs.getString("bname");
			String email = rs.getString("bemail");
			String panNo = rs.getString("bpan");
			String password = rs.getString("bpassword");
			
			buyers.add(new Buyer(buyerId,name,email,panNo,password));
		     }
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}

		return buyers;
	}

	@Override
	public ArrayList<Seller> getSellers() {
		
	ArrayList<Seller> sellers = new ArrayList<>();
		
		try(Connection connection = DBUtil.provideConnection()){
			
		PreparedStatement ps = connection.prepareStatement("select * from sellers");
		
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			
			String name = rs.getString("sname");
			String email = rs.getString("semail");
			String panNo = rs.getString("span");
			String password = rs.getString("spassword");
			
			sellers.add(new Seller(name,email,panNo,password));
		     }
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}

		return sellers;
	}

	@Override
	public ArrayList<Item> getAllItems() {

      ArrayList<Item>  allItems = new ArrayList<>();
		
		try(Connection connection = DBUtil.provideConnection()){
			
			PreparedStatement ps = connection.prepareStatement("select * from items ;");
			
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
			    int salerid = rs.getInt("sid");
				 int itemId = rs.getInt("itemid");
				 
				String itemName = rs.getString("itemname");
				String  category = rs.getString("itemcategory");
			    double basePrice = rs.getDouble("baseprice");
				int quantity = rs.getInt("qn");
				
				
				String itemStatus =rs.getString("itemstatus");
			    Date soldDate = rs.getDate("solddate");
			    double soldPrice = rs.getDouble("soldprice");
			   Date startDate = rs.getDate("startdate");
			   Date endDate = rs.getDate("enddate");
			   String auctionStatus = rs.getString("aucStatus");
			   int buyerId = rs.getInt("bid");
					
		
			   allItems.add(new Item(salerid,itemId,itemName,category,basePrice,quantity,itemStatus,soldDate,soldPrice,startDate,endDate,auctionStatus,buyerId));	

			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

		return allItems;

		
		
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		
		Admin admin = null;
		
		try(Connection connection = DBUtil.provideConnection()){
			
			PreparedStatement ps = connection.prepareStatement("select * from admins where aemail =? and apassword = ?;");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			String n = rs.getString("aname");
			String e = rs.getString("aemail");
			String p = rs.getString("apassword");
			
			admin = new Admin(n,e,p);
		}
		else {
			
			System.out.println(" -> through exception");
		}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}

		return admin;
	}

	}

