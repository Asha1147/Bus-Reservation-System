package com.cg.Bus.dao;

import java.sql.SQLException;

import com.cg.Bus.bean.BusBean;
import com.cg.Bus.exception.BusException;

public interface IBusDAO {
	
	public int bookTicket(BusBean donor) throws BusException;
	
	public BusBean  cancelTicket(int seatNo) throws BusException, ClassNotFoundException, SQLException, Exception;

	public BusBean viewTicketDetails(int seatno) throws ClassNotFoundException, SQLException, Exception;

	public int checkAvailability(int seatAvail) throws ClassNotFoundException, SQLException, Exception;

}
