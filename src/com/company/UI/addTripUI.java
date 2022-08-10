package com.company.UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class addTripUI extends JFrame {

    //String date, String leaving hour, Line line, Bus bus

    //border
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    //labels
    private JLabel info= new JLabel ("Add new Trip",  SwingConstants.CENTER );


    private JLabel date= new JLabel("Date :");
    private JLabel leavingHour = new JLabel("Hour :");

    private JLabel line = new JLabel("Please choose the Line from the list or create a new one ");
    private JLabel bus = new JLabel("Please choose the Bus from the list or create a new one ");

    //inputs

    private String[] timeOptions = {"06:00 AM", "06:30 AM", "07:00 AM", "07:30 AM", "08:00 AM"};
    JComboBox<String> jTimeBox = new JComboBox<>(timeOptions);






    //buttons

    public static void main(String[] args) {
//        String[] optionsToChoose = {"Apple", "Orange", "Banana", "Pineapple", "None of the listed"};
//
//        JFrame jFrame = new JFrame();
//
//        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
//        jComboBox.setBounds(80, 50, 140, 20);
//
//        JButton jButton = new JButton("Done");
//        jButton.setBounds(100, 100, 90, 20);
//
//        JLabel jLabel = new JLabel();
//        jLabel.setBounds(90, 100, 400, 100);
//
//        jFrame.add(jButton);
//        jFrame.add(jComboBox);
//        jFrame.add(jLabel);
//
//        jFrame.setLayout(null);
//        jFrame.setSize(350, 250);
//        jFrame.setVisible(true);
//
//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String selectedFruit = "You selected " + jComboBox.getItemAt(jComboBox.getSelectedIndex());
//                jLabel.setText(selectedFruit);
//            }
//        });

    }

    public addTripUI(){

        super("Welcome to Eazybus ");
        this.setBounds(420,90,1100,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        //Info text
        info.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        Color myBlue = new Color(73,85,137);
        info.setForeground(myBlue);//73. 85 137
        info.setSize(600,35);
        info.setLocation(250,30);
        info.setBorder(border);
        container.add(info);
        //Labels
        //

//        jTimeBox.setBounds(80, 50, 140, 20);
//        container.add(jComboBox);




    }

}
