package com.company;

import com.company.bus.Bus;
import com.company.line.Line;
import com.company.trip.Trip;

import javax.swing.JOptionPane;

public class Company {

	   private String nameOfCompany;
	    private Bus[] buses;
	    private Line[] lines;
	    private Trip[] trips;

	    private int maxNumOfBuses=100;
	    private int maxNumOfLines=50;
	    private int maxNumOfTrips=1000;


	    public Company(String nameOfCompany){

	        setNameOfCompany(nameOfCompany);
	        buses=new Bus[maxNumOfBuses];
	        lines=new Line[maxNumOfLines];
	        trips=new Trip[maxNumOfTrips];
	    }
	    public void setNameOfCompany(String name){

	        this.nameOfCompany=name;
	    }
	    public String getName(){

	    	return this.nameOfCompany;
		}
		public Bus[] getBuses(){

	    	return this.buses;
		}
		public Line[] getLines(){

	    	return this.lines;
		}
		public Trip[] getTrips(){

	    	return this.trips;
		}


		/////////// Buses
	    public void addBus(Bus newBus){

			int busCell =Integer.parseInt(newBus.getSerialNumber());

	    	for(int j=0;j<buses.length;j++) {

	    		//Error condition
	    		if(buses[j]!=null && buses[j].getSerialNumber().equals(newBus.getSerialNumber())){
					System.out.println("Error");
					JOptionPane.showMessageDialog(null,"The company already has the bus with the same serial number in system","", JOptionPane.ERROR_MESSAGE);
	    		   	return;
				}
	    		//Success
	    		else if(j==busCell && this.buses[busCell]==null  ){

	    		 	this.buses[busCell]=new Bus(newBus);
					JOptionPane.showMessageDialog(null,"The new bus was added to the company system successfully !");
					return;


				}

	       }
	    }
	    public void removeBus(String directionNumber,String serialNumber){ // needs to get string as normal bus

	        for(int i=0;i<buses.length;i++){

	            if (this.buses[i]!=null && this.buses[i].getDirectionNumber().equals(directionNumber) && this.buses[i].getSerialNumber().equals(serialNumber) ) {

	                this.buses[i]=null;
	                
	                JOptionPane.showMessageDialog(null, "The bus successfully removed from the system");
	                return;
	            }
	        }

			JOptionPane.showMessageDialog(null,"No such bus in the system");
	    }
//		public void printAllBuses() {
//
//			int busesAmount = 0;
////			System.out.print("\033[H\033[2J");
////			System.out.flush();
//
//			for (int i = 0; i < this.buses.length; i++) {
//
//				if(this.buses[i]!=null){
//					System.out.println((i + 1) + ". " + this.buses[i].toString());
//					busesAmount++;
//				}
//			}
//			System.out.println("Free Bus spots " + (this.buses.length-busesAmount));
//		}
	    /////////// Lines
	    public void addLine(Line line) {

			int lineCell = line.getLineID();

	    		if(line.getToCity()!=null && line.getFromCity()!=null && line.getLineNumber()!=0 && line.getLineID()>0){


					for(int i=0;i<this.lines.length;i++) {

						//Error condition. If the Company has it on the system
						if(lines[i]!=null &&
								//this.lines[i].getLineNumber()==line.getLineNumber() &&
								this.lines[i].getFromCity().equals(line.getFromCity()) &&
								this.lines[i].getToCity().equals(line.getToCity())) {

							JOptionPane.showMessageDialog(null, "System already has this line", "", JOptionPane.ERROR_MESSAGE);
							return;
						}
//						//Success condition
//						else if(i==lineCell && this.lines[lineCell]==null ){
//
//							this.lines[i]=new Line(line);
//							JOptionPane.showMessageDialog(null, "Successfully added to lines list of Company!");
//							return;
//						}
					}
				}

	    		else {

					JOptionPane.showMessageDialog(null, "Error ! One of inputs format is wrong !");
					return;
				}
				//Success condition
				if(this.lines[lineCell]==null ){

				this.lines[lineCell]=new Line(line);
				JOptionPane.showMessageDialog(null, "Successfully added to lines list of Company!");
				return;
			}
	    }
	    public void removeLine(int lineNumber, String from, String to) {
	    	
	    	for(int i=0;i<lines.length;i++) {
	    		
	         if( this.lines[i]!=null 
	        	    &&this.lines[i].getLineNumber()==lineNumber
	    			&&this.lines[i].getFromCity().equals(from)
	    			&&this.lines[i].getToCity().equals(to)) {
	    			
	        	 this.lines[i]=null;
	        	 JOptionPane.showMessageDialog(null,"The line has successfully removed");
	        	 return;
	    		}
	    	}
			JOptionPane.showMessageDialog(null,"Sorry but there's no such line in Company's database");

		}
//		public void printAllLines() {
//
//			int catchedCells = 0;
//
//			for(int i=0;i<lines.length;i++) {
//
//			if(lines[i]!=null) {
//				System.out.println((i)+". "+lines[i].toString());
//				catchedCells++;
//
//			}
//		}
//
//			System.out.println((100-catchedCells)+" empty cells for lines in Company");
//	}


		//I stopped here
		/////////// Trips
	    public void addTrip(Trip trip) {

	    	int tripCell = trip.getTripID();

	    	if(trip.getTripID() > 0 &&
			trip.getDate()!=null &&
			trip.getLeavingHour()!=null &&
			trip.getLine()!=null && trip.getBus()!=null){

	    		for(int i=0;i<this.trips.length;i++){

	    			if(trips[i]!=null &&
					   trips[i].getTripID() == trip.getTripID() &&
					   trips[i].getBus()==trip.getBus() &&
						trips[i].getLine()==trip.getLine() &&
						trips[i].getLeavingHour().equals(trip.getLeavingHour()) &&
						trips[i].getDate().equals(trip.getDate())){

						JOptionPane.showMessageDialog(null, "System already has this Trip", "", JOptionPane.ERROR_MESSAGE);
						return;
					}

				}
			}
	    	else {

				JOptionPane.showMessageDialog(null, "Error ! One of inputs format is wrong !");
				return;
			}
			if(trips[tripCell]==null){

				trips[tripCell]=new Trip(trip);
				JOptionPane.showMessageDialog(null, "Successfully added to trips list of Company!");
				return;
			}

		};
	    public void removeTrip(int tripID) {

	    	for(int i=0;i<trips.length;i++){

	    		if(trips[i]!=null &&trips[i].getTripID()==tripID){

	    			trips[i]=null;
	    			JOptionPane.showMessageDialog(null,"The trip successfully removed from Company's DB");
	    			return;
				}
			}

	    	JOptionPane.showMessageDialog(null, "There's no such trip in Company's database ");


		};

//	    public <T> int getEmptyCell(T[] array){
//
//			int emptyCell=0;
//
//			for(int j=0;j<array.length;j++) {
//
//				if(array[j]==null) {
//
//					emptyCell=j;
//					break;
//				}
//			}
//	    	return emptyCell;
//		}
		public <T> int countFullCells(T[] array){
			int count=0;
			for(int i=0;i< array.length;i++){
				if(array[i]!=null){

					count++;
				}

			}

			return count;
		}
		public <T> void printArrays(T[] array){

			int catchedCells = 0;

			for(int i=0;i<array.length;i++) {

				if(array[i]!=null) {
					System.out.println((i)+". "+array[i].toString());
					catchedCells++;

				}
			}

			System.out.println((100-catchedCells)+" empty cells for lines in Company");
		}

		public String toString(){

			int busesNum=countFullCells(this.buses);
			int linesNum=countFullCells(this.lines);
			int tripsNum=countFullCells(this.trips);

			return "Welcome to EazyBus !\nThere is :\n"+busesNum+" Buses\n"+linesNum+" Lines\n"+tripsNum+" Trips\nIn company database!";
		}
	    
	 
	    

 
 
 
}


