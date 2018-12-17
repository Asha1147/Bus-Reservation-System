package com.cg.Bus.pl;

import java.util.Scanner;

import com.cg.Bus.bean.BusBean;
import com.cg.Bus.exception.BusException;
import com.cg.Bus.service.BusServiceImpl;
import com.cg.Bus.service.IBusService;


public class BusMain {
	static Scanner sc=new Scanner(System.in);
	static IBusService busService=null;
	static BusServiceImpl busServiceImpl=null;
	static int lastSeat;
	public static void main(String[] args) {
		
		BusBean busBean=null;
		
		int seatNo=0;
		int option=0;
		while(true)
		{
			System.out.println();
			System.out.println();
			System.out.println(" BUS RESERVATION SYSTEM ");
            System.out.println("----------------------");
            System.out.println("1.Book Ticket");
            System.out.println("2.Cancel Ticket");
            System.out.println("3.Search Ticket Details");
            System.out.println("4.Check Availability of Seats");
            System.out.println("5.Exit");
            System.out.println("-------------------");
            System.out.println("select an option:");
            
            try {
            	option=sc.nextInt();
            	switch (option) {
				case 1:  while(busBean==null) {
					busBean=populateBusBean();
				}
				try {
					busService=new BusServiceImpl();
					for(int i=0;i<busBean.getNoOfSeats();i++) {
					seatNo=busService.bookTicket(busBean);
					
					System.out.println("Your ticket has been successfully booked");
					System.out.println("Seat no is:" +seatNo);
					
					}
				}
				catch(BusException busException) {
					System.err.println("error" +busException.getMessage());
				}
				
				finally {
					seatNo=0;
					busService=null;
					busBean=null;
				}
					
					break;
					
				case 2:System.out.println("enter seatno to cancel ticket");
				       int seatNo1=sc.nextInt();
				       try {
				    	   busBean=new BusBean();
				    	   busService=new BusServiceImpl();
				    	   busServiceImpl=new BusServiceImpl();
				    	   
				    	   busBean=busService.cancelTicket(seatNo1);
				    	   System.out.println("your ticket has been cancelled");
				    	   
				       }catch(Exception e) {
				    	   System.err.println("error:"+e.getMessage());
				    	   
				       }
					break;
				case 3:
					System.out.println("enter seatno for the  details");
                      seatNo=sc.nextInt();
                        try {
                	        busBean=new BusBean();
                	        busService=new BusServiceImpl();
                	        busServiceImpl=new BusServiceImpl();
                	
                	        
                		    
                		    System.out.println(busService.viewTicketDetails(seatNo));
                		   // lastSeat++;
                	        }
                catch(Exception e) {
                	System.err.println("error:"+e.getMessage());
                	
                }
					break;
				case 4:
				
					
					
					int seatAvail=0;
                     try {
                    	 
             	        busBean=new BusBean();
             	        busService=new BusServiceImpl();
             	        busServiceImpl=new BusServiceImpl();
             	
             	        
             		    
             		    seatAvail=busService.checkAvailability(seatAvail);
             		    lastSeat=seatAvail;
             		    int seats=30-lastSeat;
             		   System.out.println("Available seats are:"+seats);
             		   
             	        }
             catch(Exception e) {
             	System.err.println("error:"+e.getMessage());
             	
             }
					
					
					
					break;
					
			    case 5:
					System.out.print("Exit Trust Application");
					System.exit(0);
					break;
					
				default:
					break;
				}
            }
            catch(Exception e) 
            {
            	System.out.println(e);
            }
		
		}
		
	}

	private static BusBean populateBusBean() {
		
		

		BusBean busBean=new BusBean();
		System.out.println("\n Enter Details");
		
		System.out.println("enter your name");
		busBean.setName(sc.next());
		
		System.out.println("enter your email");
		busBean.setEmail(sc.next());
		
		System.out.println("enter your contact");
		busBean.setPhoneno(sc.next());
		
		System.out.println("enter your age");
		busBean.setAge(sc.nextInt());
		
		System.out.println("enter your gender");
		busBean.setGender(sc.next());
		
		System.out.println("enter no of seats to book");
		busBean.setNoOfSeats(sc.nextInt());
		
		
		
		
		busServiceImpl=new BusServiceImpl();
		try 
		{
			busServiceImpl.validateBus(busBean);
			return busBean;
		}
		catch(BusException busException) 
		{
			System.err.println("invalid data");
			System.err.println(busException.getMessage() + "Try again");
			System.exit(0);
		}
		return null;
		
		
		
		
		
		
		
	
	}
}
	


