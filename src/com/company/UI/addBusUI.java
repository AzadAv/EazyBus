package com.company.UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addBusUI extends JFrame{
    //borders
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    //labels
    private JLabel info= new JLabel ("Add new Bus",  SwingConstants.CENTER );
    private JLabel directionNumber = new JLabel ("Direction Number : ( 3-digits )", SwingConstants.CENTER  );
    private JLabel serialNumber = new JLabel("Serial Number", SwingConstants.CENTER);
    private JLabel numberOfSeats = new JLabel("Number of Seats", SwingConstants.CENTER);
    //inputs
    private JTextField dirNumInput = new JTextField("",20);
    private JTextField serialNumInput = new JTextField("",20);
    private JTextField seatsInput  = new JTextField("",20);

    public addBusUI(){

        this.setBounds(420,90,900,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        //info text
        info.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        Color myBlue = new Color(73,85,137);
        info.setForeground(myBlue);//73. 85 137
        info.setSize(600,35);
        info.setLocation(150,30);
        //info.setBorder(border);
        container.add(info);

        //direction number
        directionNumber.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        directionNumber.setForeground(myBlue);
        directionNumber.setSize(320,35);
        directionNumber.setLocation(150,120);
        //directionNumber.setBorder(border);
        container.add(directionNumber);

        dirNumInput.setFont(new Font("Times New Roman", Font.PLAIN,25));
        dirNumInput.setSize(250, 35);
        dirNumInput.setLocation(490,120);
        container.add(dirNumInput);
    }

}
