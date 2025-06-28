package resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import pojo.AddBooking;

public class BuildTestBooking {
	
	public AddBooking bookingPayload() {
		
		AddBooking b = new AddBooking();
		b.setFirstname("Jennie");
		b.setLastname("Lara");
		b.setTotalprice(200);
		b.setDepositpaid(false);
		b.setAdditionalneeds("Lunch");
		return b;
		
	}

}
