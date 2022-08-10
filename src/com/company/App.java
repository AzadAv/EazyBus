package com.company;

import com.company.UI.addBusUI;
import com.company.UI.addTripUI;
import com.company.bus.Bus;
import com.company.line.Line;
import com.company.trip.Trip;
import jdk.nashorn.internal.scripts.JO;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class App {
/*
***To Do List :
***1. Main Menu UI
***2. Add Bus UI
***3. Add Line UI
***4. Add Trip UI
***5.


 */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Company Company = new Company("EazyBus");
        UImenu(Company);
//        addTripUI UI = new addTripUI();
//        UI.setVisible(true);
//        addBusUI addBus = new addBusUI();
//            addBus.setVisible(true);
    }

    public static void UImenu(Company company){

        String answer="";

        do {

            answer =JOptionPane.showInputDialog
                    (
                                    "Welcome to "+company.getName()+" !"
                                    + "\n1 -- Add new bus to Company system "
                                    + "\n2 -- Remove the bus from Company system "
                                    + "\n3 -- See Company's Buses list"
                                    + "\n4 -- Add line to the Company system "
                                    + "\n5 -- Remove line from the Company system "
                                    + "\n6 -- See Company's Lines list"
                                    + "\n7 -- Add Trip"
                                    + "\n8 -- Remove Trip"
                                    + "\n9 -- See Company's Trips list"
                                    + "\n10 -- See Company Info"
                                    + "\n0 -- Exit ","w");



            switch (answer) {

                case "1" :
                    addBus(company);
                    break;
                case "2":
                    removeBus(company);
                    break;
                case "3":
                    company.printArrays(company.getBuses());
                    break;
                case "4":
                    addLine(company);
                    break;
                case "5":
                    removeLine(company);
                    break;
                case "6":
                    company.printArrays(company.getLines());
                    break;
                case "7":
                    // I stopped here
                    addTrip(company);
                    break;
                case "8":
                    removeTrip(company);
                    break;
                case "9":
                    company.printArrays(company.getTrips());
                    break;
                case "10":
                    JOptionPane.showMessageDialog(null,company.toString());
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Good bye!");
                    break;
                case "":
                    answer="0";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please choose the right option");
                    break;
            }
        }while(!answer.equals("0"));

    }

    public static Bus addBus(Company company){

        Bus newBus = new Bus();

        try{

            String busNumber=JOptionPane.showInputDialog("Please enter the direction number of bus:");
            String serialNumber=JOptionPane.showInputDialog("Please enter the serial number for bus :");
            String seats=JOptionPane.showInputDialog("Please enter the number of seats");
            int seatsNumber=Integer.parseInt(seats);

            newBus = new Bus(busNumber,seatsNumber, serialNumber);
            company.addBus(newBus);

            return newBus;
        }catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Wrong input format for the number of seats input");
        }
        catch (NullPointerException e){

            JOptionPane.showMessageDialog(null,e);

        }
        return newBus;
    }

    public static void removeBus(Company company){

        String busNumber=JOptionPane.showInputDialog("Please enter the Direction number ");
        String serialNumber=JOptionPane.showInputDialog("Please enter the Serial number ");

        company.removeBus(busNumber, serialNumber);


    }

    public static Line addLine(Company company){

        Line myLine = new Line();
        try{

            String IDnum = JOptionPane.showInputDialog("Please enter line ID : ( 1-50 )");
            int lineID = Integer.parseInt(IDnum)-1;

            String Lnum = JOptionPane.showInputDialog("Please enter the line number : ( 3-digit number )");
            int lineNumber = Integer.parseInt(Lnum);
            String fromCity= JOptionPane.showInputDialog("Please enter the City that Bus leaves from :").toLowerCase();
            String toCity = JOptionPane.showInputDialog("Please enter the City that Bus goes to :").toLowerCase();

            myLine = new Line(lineID,lineNumber,fromCity,toCity);
            company.addLine(myLine);
        }catch(NumberFormatException e){

            JOptionPane.showMessageDialog(null, "Wrong input format for the line number");

        }catch(NullPointerException e){


            JOptionPane.showMessageDialog(null,"Please enter a City value with right format");

        }
        return myLine;
    }

    public static void removeLine(Company company){

        try {
            String LNumber = JOptionPane.showInputDialog("Please enter the Line number ");
            int lineNumber = Integer.parseInt(LNumber);
            String from = JOptionPane.showInputDialog("Please enter the 'From' city ");
            String to = JOptionPane.showInputDialog("Please enter the 'To' city ");

            company.removeLine(lineNumber, from, to);
        }catch (NumberFormatException e){

            JOptionPane.showMessageDialog(null, "Wrong input format for the line number input");

        }catch(NullPointerException e){


            JOptionPane.showMessageDialog(null,"Please enter a City value with right format");

        }

    }

    public static void addTrip(Company company){

        Trip newTrip = new Trip();
        Bus newBus =new Bus();
        Line newLine=new Line();

        try {

                //String date, String leaving hour, Line line, Bus bus
//            addTripUI UI = new addTripUI();
//            UI.setVisible(true);

            String trip = JOptionPane.showInputDialog("Please enter the Trip ID :  ( 1-1000 )");
            int tripID = Integer.parseInt(trip);
            String date =JOptionPane.showInputDialog(null,"Please the date : ( dd/mm/yyyy )" );

            String hour = JOptionPane.showInputDialog("Please enter the leaving hour : ( hh:mm )");
//            Bus newBus = addBus(company);
//            Line newLine = addLine(company);

            newTrip=new Trip(tripID,date,hour,newLine,newBus);

            company.addTrip(newTrip);

        }catch(NumberFormatException e){

            JOptionPane.showMessageDialog(null,"Wrong format for one of Inputs ", "Wrong Input",JOptionPane.ERROR_MESSAGE);
        }
        catch (NullPointerException e){}

    }

    public static void removeTrip(Company company){


        try {
            String trip = JOptionPane.showInputDialog("Please enter the Trip ID ");
            int tripID = Integer.parseInt(trip);

            company.removeTrip(tripID);


        }catch(NumberFormatException e){}
        catch (NullPointerException e){}

    }


    }
