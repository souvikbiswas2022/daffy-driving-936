package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.Data;
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

	@Override
	public String updatePrice(int itemid, Double newPrice) {
		String message="Failed to update price . . .";
		
		try(Connection connection=DBUtil.provideConnection()){
			
			PreparedStatement ps=connection.prepareStatement("Update items set baseprice=? where itemid=?;");
			
			ps.setDouble(1,newPrice );
			ps.setInt(2, itemid);
			
			int update=ps.executeUpdate();
			
			if(update>0) {
				message="Update successfull ...";
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public String updateQuantity(int itemid, int newQuantity) {
	

		String message="Failed to  update quantity successfully ...";
		
		try(Connection connection=DBUtil.provideConnection()){
			
			
	PreparedStatement ps=connection.prepareStatement("Update items set qn=? where itemid=?;");
			
			ps.setInt(1,newQuantity );
			ps.setInt(2, itemid);
			
			int update=ps.executeUpdate();
			
			if(update>0) {
				message="New quantity update successfull ...";
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return message;
	}

	@Override
	public String AddNewItem(int sellerId, Item item) {
		return null;
	

	}

	@Override
	public String removeItem(int itemid) {

String message="Sorry ... Failed to remove ...";

try(Connection connection = DBUtil.provideConnection()){

PreparedStatement ps=connection.prepareStatement("delete from items where itemid=?;");

ps.setInt(1, itemid);

int update = ps.executeUpdate();

if(update>0) {
	
	message = "Item removed successfully ...";
}

}catch(SQLException e) {
	e.printStackTrace();
	
	
}

		return message;
	}


	
	@Override
	public List<Item> getSoldItems(int sellerid) {
	
		ArrayList<Item> soldItems=new ArrayList<>();
		
		
		try(Connection connection = DBUtil.provideConnection()){
			
			
			PreparedStatement ps=connection.prepareStatement("select * from items where sid=? and itemstatus='SOLD';");
			
			ps.setInt(1, sellerid);
			
			ResultSet rs=ps.executeQuery();
			
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
				
	
		   soldItems.add(new Item(salerid,itemId,itemName,category,basePrice,quantity,itemStatus,soldDate,soldPrice,startDate,endDate,auctionStatus,buyerId));	
				
			}

		}catch(SQLException e) {
			e.printStackTrace();
		
		}

		return soldItems;
	}
	
	}


