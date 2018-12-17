package com.cg.Bus.dao;

public interface QueryMapper {
	public static final String CANCEL_TICKET="delete from Customer_Details  where seatno=?";
	public static final String DELETED_TICKET="insert into Deleted_seatno values(?)";
	public static final String CHECK_AVAILABILITY="select count(seatno) from Customer_Details";
    public static final String DELETED_SEATNO="select * from Deleted_seatno";
    public static final String INSERT_CUSTOMER="insert into Customer_Details values(Seat_sequence.nextval,?,?,?,?,?,?)";
    public static final String SEAT_SEQUENCE="select Seat_sequence.currval from Customer_Details";
    public static final String INSERT_CUSTOMER1="insert into Customer_Details values(?,?,?,?,?,?,?)";
    public static final String VIEW_TICKET_DETAILS="select * from Customer_Details where seatno=?";
}
