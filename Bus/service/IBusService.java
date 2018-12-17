package com.cg.Bus.service;

import java.sql.SQLException;

import com.cg.Bus.bean.BusBean;
import com.cg.Bus.exception.BusException;


public interface IBusService {
	
	public int bookTicket(BusBean bus) throws BusException;
	
	public BusBean  cancelTicket(int seatNo) throws BusException, ClassNotFoundException, SQLException, Exception;

	public BusBean viewTicketDetails(int seatNo) throws BusException, ClassNotFoundException, SQLException, Exception;

	public int checkAvailability(int seatAvail) throws ClassNotFoundException, SQLException, Exception;
	

}
