package com.cg.Bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.Bus.bean.BusBean;
import com.cg.Bus.bean.DeletedTicket;
import com.cg.Bus.exception.BusException;
import com.cg.Bus.util.DBConnection;

public class BusDaoImpl implements IBusDAO{

	

	
	@Override
	public BusBean cancelTicket(int seatNo) throws ClassNotFoundException, SQLException, Exception {
		int a=seatNo;

		Connection connection=DBConnection.getConnection();
		Statement st=connection.createStatement();
		//st.setInt(1, a);
		//st.executeUpdate();
		DeletedTicket delete=new DeletedTicket();
				BusBean bean=new BusBean();
		
		
		try
		{
			delete.setSeatno(a);
		deletedticket(delete);
		
	 st.executeUpdate("delete from Customer_Details  where seatno='"+a+"'");
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return bean;
		
	}
    public void deletedticket(DeletedTicket delete) throws ClassNotFoundException, SQLException, Exception {
    	Connection connection=DBConnection.getConnection();
		Statement st=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int i=0;
		preparedStatement=connection.prepareStatement(QueryMapper.DELETED_TICKET);
		preparedStatement.setInt(1, delete.getSeatno());
       i= preparedStatement.executeUpdate();
       if(i!=0) {
    	   System.out.println("*added");
       }
    }


	@Override
	public int bookTicket(BusBean bus) throws BusException {
		
		int seatNo=0;
		try {
			Connection connection=DBConnection.getConnection();
			Statement st=null;
			Statement st1=null;
			PreparedStatement preparedStatement=null;
			PreparedStatement ps=null;
			ResultSet resultSet=null;
			ResultSet rs=null;
			st1=connection.createStatement();
	        rs= st1.executeQuery(QueryMapper.DELETED_SEATNO);
			
			for(int i=0;i<bus.getNoOfSeats();i++) {
				if(!rs.next()) {
				preparedStatement=connection.prepareStatement(QueryMapper.INSERT_CUSTOMER);
				preparedStatement.setString(1,bus.getName());
				preparedStatement.setString(2,bus.getEmail());
				preparedStatement.setString(3,bus.getPhoneno());
				preparedStatement.setInt(4,bus.getAge());
				preparedStatement.setString(5,bus.getGender());
				preparedStatement.setInt(6,bus.getNoOfSeats());
				preparedStatement.executeUpdate();
			
				st=connection.createStatement();
				resultSet=st.executeQuery(QueryMapper.SEAT_SEQUENCE);
				while(resultSet.next()) {
					seatNo =	(resultSet.getInt(1));
						
				
			}
				return seatNo;
			}
				else {
					
					DeletedTicket dt=new DeletedTicket();
					dt.setSeatno(rs.getInt(1));
					int val=dt.getSeatno();
					preparedStatement=connection.prepareStatement(QueryMapper.INSERT_CUSTOMER1);
					preparedStatement.setInt(1,dt.getSeatno());
					preparedStatement.setString(2,bus.getName());
					preparedStatement.setString(3,bus.getEmail());
					preparedStatement.setString(4,bus.getPhoneno());
					preparedStatement.setInt(5,bus.getAge());
					preparedStatement.setString(6,bus.getGender());
					preparedStatement.setInt(7,bus.getNoOfSeats());
					preparedStatement.executeUpdate();
					st=connection.createStatement();
				
					 st.executeUpdate("delete from Deleted_seatno  where seatno='"+val+"'");
					String str=bus.getPhoneno();
					resultSet=st.executeQuery("select seatno from Customer_Details where phoneno='"+str+"'");
					while(resultSet.next()) {
						seatNo =	(resultSet.getInt(1));
							
					
				}
					return seatNo;
				}
					
				}
		}
			catch(Exception e) {
				System.out.println(e);
			}
			
			
		
	
	return (Integer) null;
}
	@Override
	public BusBean viewTicketDetails(int seatNo) throws ClassNotFoundException, SQLException, Exception {
		int b=seatNo;
		Connection connection=DBConnection.getConnection();
		PreparedStatement pst=connection.prepareStatement(QueryMapper.VIEW_TICKET_DETAILS);
		pst.setInt(1, b); 
		//pst.executeUpdate();
		
		BusBean bean=new BusBean();
		try
		{
		
		
		ResultSet resultSet = pst.executeQuery();
			while(resultSet.next())
			{
			bean.setSeatno(resultSet.getInt(1));
			bean.setName(resultSet.getString(2));
			bean.setEmail(resultSet.getString(3));
			bean.setPhoneno(resultSet.getString(4));
			bean.setAge(resultSet.getInt(5));
			bean.setGender(resultSet.getString(6));
			bean.setNoOfSeats(resultSet.getInt(7));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return bean;
	}
	@Override
	public int checkAvailability(int seatAvail) throws ClassNotFoundException, SQLException, Exception {
		Connection connection=DBConnection.getConnection();
		Statement st=connection.createStatement();
		try 
		{
			ResultSet resultSet = st.executeQuery(QueryMapper.CHECK_AVAILABILITY);
			while(resultSet.next()) {
				seatAvail =(resultSet.getInt(1));
					
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return seatAvail;
	}
}
