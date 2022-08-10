package com.company.line;

import javax.swing.JOptionPane;
import java.util.Locale;

public class Line {
	
/// setCities,
	private int lineNumber;
	private int lineID;
    private String from;
    private String to;
    private String[] cities={ "afula", "akko", "arad", "ashdod", "ashqelon", "bat Yam", "beersheba", "bet shean",
            "bet shearim", "bnei brak", "caesarea", "dimona", "dor", "eilat", "en gedi", "givatayim", "hadera",
            "haifa", "herzliyya", "holon", "jerusalem", "karmiel", "kefar saba", "lod", "meron", "nahariyya",
            "nazareth", "netanya", "petah tiqwa", "qiryat shemona", "ramat gan", "ramla", "rehovot", "rishon le ziyyon",
            "sedom", "tel aviv–yafo", "tiberias", "zefat"};

    public Line(){

        this.lineNumber = 001;
        this.lineID = 01;
        this.from="akko";
        this.to="jerusalem";
    }

    public Line(int lineID, int lineNumber, String from, String to){

        setLineID(lineID);
    	setLineNumber(lineNumber);
    	setFromCity(from);
    	setToCity(to);

    	
    }
    ///////////
    public Line(Line other) {

        setLineID(other.getLineID());
        setLineNumber(other.getLineNumber());
        setFromCity(other.getFromCity());
        setToCity(other.getToCity());
    }
    //////////


    public void setLineNumber(int lineNumber){

	   if(lineNumber>99 && lineNumber<1000) {
        this.lineNumber=lineNumber;
        }
	   else {
		   JOptionPane.showMessageDialog(null,"The line number has to be 3-digit number","",JOptionPane.ERROR_MESSAGE);
	   }
		   
    }
    //////////
    public void setFromCity(String from){

        if(from.matches("[a-zA-Z]+")) {

            if (checkCity(from)) {

                this.from = from;
            }
        }
        else{

            JOptionPane.showMessageDialog(null,"Wrong format for city name input","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

    }
    //////////
    public void setToCity(String to){

        if(to.matches("[a-zA-Z]+")){

        if(checkCity(to) && !this.from.equals(to)){

            this.to=to;
        }}
        else{

            JOptionPane.showMessageDialog(null,"Wrong format for city name input","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }


    }
    //////////
    public void setLineID(int lineID) {

        if(lineID > 0 && lineID <= 50){

            this.lineID = lineID;
        }

    }


   /////////helper function
    public boolean checkCity(String city){


            for(int i=0;i<this.cities.length;i++){

                if(cities[i]!=null && city.equals(cities[i])){
                    return true;
                }
            }

        JOptionPane.showMessageDialog(null,"Sorry but this City is out of our Cities serving list!");
        return false;
    }


    public int getLineNumber(){

        return this.lineNumber;
    }
    /////////
    public String getFromCity(){

        return this.from;
    }
    /////////
    public String getToCity(){

        return this.to;
    }
    /////////
    public int getLineID() {
        return this.lineID;
    }

    ////////
    public String toString(){

        return "Line ID: "+this.lineID+ "\nLine number : "+ lineNumber+ "\n   The line is " + from.toUpperCase() + " -> "+to.toUpperCase()+"\n";
    }
}
	

