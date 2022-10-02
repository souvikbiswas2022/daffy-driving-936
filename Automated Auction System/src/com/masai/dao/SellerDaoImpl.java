package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.Data;

import com.masai.bean.Buyer;
import com.masai.bean.Item;
import com.masai.bean.Seller;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.ItemException;
import com.masai.exceptions.SellerException;
import com.masai.utility.DBUtil;

public class SellerDaoImpl implements SellerDao {

	
	
	@Override
	public String resisterSeller(Seller s) throws SellerException {
		
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
			
			throw new SellerException("Sorry duplicate email '"+s.getEmail()+"'");
			
		}

		return message;
	}

	
	
	
	@Override
	public String resisterItems(List<Item> i) {
	
	String message="Failed to add items ...";
		
	

	java.util.Date date=new java.util.Date();
	java.sql.Date sqlDate=new java.sql.Date(date.getTime());
	
	
	java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
	sqlTime.setSeconds(sqlTime.getSeconds()+360);

	
	
		try(	Connection connection=DBUtil.provideConnection()){
	
			for(Item item:i) {
				
				PreparedStatement ps=connection.prepareStatement("insert into items(sid,itemname,itemcategory,baseprice,qn,startdate,endtime) values(?,?,?,?,?,now(),addtime(now(),'59'));");
				
				ps.setInt(1, item.getSalerId());
				ps.setString(2,item.getItemName());
				ps.setString(3, item.getCategory());
				ps.setDouble(4, item.getBasePrice());
				ps.setInt(5, item.getQuantity());
				int check =ps.executeUpdate();
				
				if(check>0) {
					message="Items added successfully ...";
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
	public List<Item> getSoldItems(int sellerid) throws ItemException{
	
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
		   Time  endTime = rs.getTime("endtime");
		   String auctionStatus = rs.getString("aucStatus");
		   int buyerId = rs.getInt("bid");
				
	
		   soldItems.add(new Item(salerid,itemId,itemName,category,basePrice,quantity,itemStatus,soldDate,soldPrice,startDate,endTime,auctionStatus,buyerId));	
				
			}

		}catch(SQLException e) {
			throw new ItemException(e.getMessage());
		
		}

if(soldItems.size() == 0) {
	throw new ItemException("No item found . . .");
}
		
		return soldItems;
	}

	
	
	
	
	@Override
	public Seller loginSeller(String email, String password)  throws SellerException{
		
		Seller seller = null;
		
		try(Connection connection = DBUtil.provideConnection()){
			
			PreparedStatement ps = connection.prepareStatement("select * from sellers where semail =? and spassword = ?;");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int id = rs.getInt("sid");
			String nm = rs.getString("sname");
			String eml = rs.getString("semail");
			String pan = rs.getString("span");
			String pass = rs.getString("spassword");
			
			seller = new Seller(id,nm,eml,pan,pass);
		}
		else {
			
			throw new SellerException("invalid email or password ...");
		
		}
			
		}catch(SQLException e) {
			
			throw new SellerException(e.getMessage());
		}

		return seller;
		
	}




	@Override
	public ArrayList<Item> sellerOwnItems(int sellerId) throws ItemException{

		ArrayList<Item> ownItems = new ArrayList<>();
		
		
		try (Connection connection = DBUtil.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("select * from items where sid=?;");
			ps.setInt(1, sellerId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int salerid = rs.getInt("sid");
				int itemId = rs.getInt("itemid");
				String itemName = rs.getString("itemname");
				String category = rs.getString("itemcategory");
				double basePrice = rs.getDouble("baseprice");
				int quantity = rs.getInt("qn");
				String itemStatus = rs.getString("itemstatus");
				Date soldDate = rs.getDate("solddate");
				double soldPrice = rs.getDouble("soldprice");
				Date startDate = rs.getDate("startdate");
				Time endTime = rs.getTime("endtime");
				String auctionStatus = rs.getString("aucStatus");
				int buyerId = rs.getInt("bid");

				ownItems.add(new Item(salerid, itemId, itemName, category, basePrice, quantity, itemStatus, soldDate,
				soldPrice, startDate, endTime, auctionStatus, buyerId));

			}

		} catch (SQLException e) {
			throw new ItemException(e.getMessage());
		}

		
		if (ownItems.size() == 0) {
			throw new ItemException("No item found ...");
		}


		
		return ownItems;
		
	}
	
	}


