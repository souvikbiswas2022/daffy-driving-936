package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.masai.bean.Item;
import com.masai.bean.Seller;
import com.masai.utility.DBUtil;

public class SellerDaoImpl implements SellerDao {

	@Override
	public String resisterSeller(Seller s) {
		
		String message="Resistration failed";
		
		
		try(	Connection connection=DBUtil.provideConnection()){
			
			PreparedStatement ps=connection.prepareStatement("insert into sellers(sname,semail,span,spassword) values(?,?,?,?)");
			
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPanNo());
			ps.setString(4, s.getPassword());
			
			int check =ps.executeUpdate();
			
			if(check>0) {
				message="Resistration Successfull ...";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	

		
		return message;
	}

	@Override
	public String resisterItems(List<Item> i) {
	
		
	String message="Failed to add items ...";
		
		
		try(	Connection connection=DBUtil.provideConnection()){
			
			
			
			for(Item item:i) {
				
				PreparedStatement ps=connection.prepareStatement("insert into items(sid,itemname,itemcategory,baseprice,qn) values(?,?,?,?,?);");
				
				ps.setInt(1, item.getSalerId());
				ps.setString(2,item.getItemName());
				ps.setString(3, item.getCategory());
				ps.setDouble(4, item.getBasePrice());
				ps.setInt(5, item.getQuantity());
				
				
				int check =ps.executeUpdate();
				
				if(check>0) {
					message="Items added successfull ...";
				}
			}
			
			
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	

		return message;
		

	}

}
