package com.company.bus;

import javax.swing.JOptionPane;
public class Bus {

	  private String directionNumber;
	  private String serialNumber;
	  private int numOfSeats;


	  	public Bus(){

	  		this.directionNumber="001";
	  		this.serialNumber="01";
	  		this.numOfSeats=1;


		}
	    public Bus(String directionNumber,int numOfSeats, String serialNumber){


				setDirectionNumber(directionNumber);
				setSerialNumber(serialNumber);
				setNumOfSeats(numOfSeats);


	    }
	    //////////
	    public Bus(Bus other ){

	        setDirectionNumber(other.getDirectionNumber());
	        setSerialNumber(other.getSerialNumber());
	        setNumOfSeats(other.getNumOfSeats());

	    }
	    //////////


	    public void setDirectionNumber(String newDirectionNumber){

			if (newDirectionNumber.matches("[0-9]+")) {


				if (newDirectionNumber.length() < 8 && newDirectionNumber.length() > 1) {
					this.directionNumber = newDirectionNumber;
				} else {

					JOptionPane.showMessageDialog(
							null, "Bus number cannot be more than 7 digits ", "Failure", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(
						null, "Wrong input format for direction number ", "Failure", JOptionPane.ERROR_MESSAGE);
					return;
			}

	    }
	    //////////
	    public void setNumOfSeats(int newNumOfSeats) {


	        if (newNumOfSeats > 0) {
	            this.numOfSeats = newNumOfSeats;
	        }
	        else{
	            JOptionPane.showMessageDialog(null, "The number of seats cannot be less than 1 ", "",JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	    }
	    //////////
		public void setSerialNumber(String serialNumber) {

			if (serialNumber.matches("[0-9]+")) {

				if(serialNumber.length()> 1 && serialNumber.length()<3){
					this.serialNumber = serialNumber;}
				else{

					JOptionPane.showMessageDialog(
							null, "The serial number cannot be less than 1 and more than 2 digits ", "Failure", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}else{

				JOptionPane.showMessageDialog(
						null, "Wrong input format for serial number ", "Failure", JOptionPane.ERROR_MESSAGE);
					return;
			}

		}


	    public String getDirectionNumber(){

	        return this.directionNumber;
	    }
	    //////////
	    public int getNumOfSeats(){

	        return this.numOfSeats;
	    }
	    //////////
		public String getSerialNumber() {
			return this.serialNumber;
		}


	public String toString(){

	        return "Direction Number of Bus -> " + directionNumber+ "\n   Serial number of bus -> "+serialNumber+ "\n   Number of seats in Bus -> "+ numOfSeats+"\n";
	    }
	   
	    
}
