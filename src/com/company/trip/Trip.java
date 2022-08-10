package com.company.trip;


import com.company.bus.Bus;
import com.company.line.Line;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Trip {

	private int tripID;
	private String date;
	private String leavingHour;
	private Line line;
	private Bus bus;

	public Trip(){


	}

	public Trip(int ID,String date,String leavingHour,Line line, Bus bus) {

		setTripID(ID);
		setDate(date);
		setLeavingHour(leavingHour);
		setLine(line);
		setBus(bus);
		
	}
	public Trip(Trip other){

		setTripID(other.getTripID());
		setDate(other.getDate());
		setLeavingHour(other.getLeavingHour());
		setLine(other.getLine());
		setBus(other.getBus());
	}

	//setters
	public void setTripID(int tripID) {

		if(tripID> 99 && tripID < 1000){

			this.tripID = tripID;
		}
	}
	//////
	public void setDate(String date) {

		if(validDate(date)){
			this.date=date;
		}
	}
	//////
	public void setLeavingHour(String leavingHour) {

		if(validTime(leavingHour)){

			this.leavingHour=leavingHour;
		}

	}
	//////
	public void setLine(Line line ) {
		
		this.line=line;
	}
	//////
	public void setBus(Bus bus) {
		
		this.bus=bus;
	}


	//getters
	public String getDate() {
		return date;
	}
	//////
	public String getLeavingHour() {
		return leavingHour;
	}
	//////
	public Line getLine() {
		return line;
	}
	//////
	public Bus getBus() {


		return bus;
	}
	//////
	public int getTripID() {
		return this.tripID;
	}

	//////Helpers
	//////Date validator
	public boolean validDate(String date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		try {

			dateFormat.parse(date);
			return true;
		}catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"Please enter right ( dd/mm/yyyy ) format for Leaving date","Wrong date format !", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	//////Time validator
	public boolean validTime(String time){

		try {
			LocalTime.parse(time);
			return true;
		} catch (DateTimeParseException | NullPointerException e) {
//			System.out.println("Invalid time string: ");
			JOptionPane.showMessageDialog(null,"Please enter a valid ( hh:mm ) time input", "Invalid time input",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public String toString() {
		
		return "Bus leaves on : "+ date+" at "+ leavingHour + "\n" +this.line.toString()+"\n" +this.bus;
	}
}
