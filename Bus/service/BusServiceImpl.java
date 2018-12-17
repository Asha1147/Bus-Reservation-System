package com.cg.Bus.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.Bus.bean.BusBean;
import com.cg.Bus.dao.BusDaoImpl;
import com.cg.Bus.dao.IBusDAO;
import com.cg.Bus.exception.BusException;

public class BusServiceImpl implements IBusService {

	
	@Override
	public int checkAvailability(int seatAvail) throws ClassNotFoundException, SQLException, Exception {
		int busAvail;
		busAvail=busdao.checkAvailability(seatAvail);
		
		return busAvail;
		
	}


	@Override
	public BusBean cancelTicket(int seatNo) throws ClassNotFoundException, SQLException, Exception {
		
		BusBean bean;
		bean=busdao.cancelTicket(seatNo);
		return bean;
		
		}
	@Override
	public BusBean viewTicketDetails(int seatNo) throws ClassNotFoundException, SQLException, Exception {
		BusBean bean;
		int seatno=seatNo;
		bean=busdao.viewTicketDetails(seatno);
		return bean;
		
	}
	

    IBusDAO busdao=new BusDaoImpl();

	@Override
	public int bookTicket(BusBean bus) throws BusException {
		
		int busSeq;
		busSeq=busdao.bookTicket(bus);
		
		return busSeq;
	}



	public void validateBus(BusBean bean)throws BusException {
		
        List<String> validationErrors=new ArrayList<String>();
		
		if(!(isValidName(bean.getName()))) {
			validationErrors.add(" name should be in alphabets and minimun 3 chars long");
		}
		
		if(!(isValidPhoneNumber(bean.getPhoneno()))) {
			validationErrors.add("Phone no should be in 10 digit");
		}
		
		if(!(isValidEmail(bean.getEmail()))) {
			validationErrors.add("Email should match");
		}
		
		/*if(!(isValidAge(bean.getAge()))) {
			validationErrors.add("Age should be greater than 15");
		}*/
		
	
		
		
		if(!validationErrors.isEmpty())
			throw new BusException(validationErrors +"");
		
		
	}
		
		
	
        


	/*private boolean isValidAge(int age) {
		Pattern agePattern=Pattern.compile("[a-z0-9._+]+@[a-z]+.[a-z]{2,3}");
		Matcher ageMatcher=agePattern.matcher(age);
		return ageMatcher.matches();
	}*/



	private boolean isValidEmail(String email) {
		Pattern emailPattern=Pattern.compile("[a-z0-9._+]+@[a-z]+.[a-z]{2,3}");
		Matcher emailMatcher=emailPattern.matcher(email);
		return emailMatcher.matches();
	}



	private boolean isValidPhoneNumber(String phoneno) {
		Pattern phonePattern=Pattern.compile("^[6-9]{1}[0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(phoneno);
		return phoneMatcher.matches();
	}



	private boolean isValidName(String name) {
		Pattern namePattern=Pattern.compile("[A-z][a-z]{3,}");
		Matcher nameMatcher=namePattern.matcher(name);
		return nameMatcher.matches();
	}
	
	
     public boolean validateBusSeatNo(String seatNo) {
		
		Pattern noPattern=Pattern.compile("[0-9]{1,2}");
		Matcher noMatcher=noPattern.matcher(seatNo);
		
		if(noMatcher.matches())
		
		return true;
		
		else
			return false;
		
	}
	


	

}
