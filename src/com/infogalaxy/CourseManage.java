package com.infogalaxy;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class CourseManage
{
    //DBConn DB = new DBConn();
    JFrame frame = new JFrame("CourseInfo");
    JPanel panel = new JPanel();
    Font lblFont = new Font("Algerian",Font.BOLD,20);
    JLabel lblCID = new JLabel("Enter the Course ID:");
    JTextField txtCID = new JTextField();
    JLabel lblCName = new JLabel("Enter the Course Name:");
    JTextField txtCName = new JTextField();
    JLabel lblCFees = new JLabel("Enter the Course Fees:");
    JTextField txtCFees = new JTextField();

    JButton btnSubmit = new JButton("SUBMIT");
    JButton btnCancel = new JButton("CANCEL");
    JButton btnDelete = new JButton("DELETE");
    JButton btnUpdate = new JButton("UPDATE");

    CourseManage()
    {
        panel.setLayout(null);

        lblCID.setBounds(50,50,200,30);
        lblCID.setFont(lblFont);
        panel.add(lblCID);

        txtCID.setBounds(260,50,200,30);
        txtCID.setFont(lblFont);
        panel.add(txtCID);

        lblCName.setBounds(50,90,230,30);
        lblCName.setFont(lblFont);
        panel.add(lblCName);

        txtCName.setBounds(290,90,200,30);
        txtCName.setFont(lblFont);
        panel.add(txtCName);

        lblCFees.setBounds(50,130,230,30);
        lblCFees.setFont(lblFont);
        panel.add(lblCFees);

        txtCFees.setBounds(290,130,200,30);
        txtCFees.setFont(lblFont);
        panel.add(txtCFees);

        btnSubmit.setBounds(50,200,180,30);
        btnSubmit.setFont(lblFont);
        panel.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                System.out.println("Click");
                if(txtCID.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(frame,"Please Enter the Course ID.");
                } else if(txtCName.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(frame,"Please Enter the Course Name.");
                } else if(txtCFees.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(frame,"Please Enter the Course Fees.");
                } else {
                        DBConn.openCon();
                        DBConn.nonSelect("insert into courseinfo values('"+txtCID.getText()+"','"+txtCName.getText()+"',"+txtCFees.getText()+")");
//                        JOptionPane.showMessageDialog(frame,"Course Info Added Successfully !!!");
//                        txtCID.setText("");
//                        txtCName.setText("");
//                        txtCFees.setText("");
//                        txtCID.requestFocus();
                    clearComponent();
                }
            }
        });

        btnCancel.setBounds(260,200,180,30);
        btnCancel.setFont(lblFont);
        panel.add(btnCancel);

        btnDelete.setBounds(50,240,180,30);
        btnDelete.setFont(lblFont);
        panel.add(btnDelete);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    DBConn.openCon();
                    DBConn.nonSelect("delete from courseinfo where CID='"+txtCID.getText()+"'");
                    clearComponent();
            }
        });

        btnUpdate.setBounds(260,240,180,30);
        btnUpdate.setFont(lblFont);
        panel.add(btnUpdate);

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    DBConn.openCon();
                    DBConn.nonSelect("update courseinfo set CName='"+txtCName.getText()+"',CFees="+txtCFees.getText()+" where CID='"+txtCID.getText()+"'");
                    clearComponent();
            }
        });

        frame.add(panel);
        frame.setSize(600,600);
        frame.setLocation(100,100);
        frame.show();
    }

    public void clearComponent() {
        JOptionPane.showMessageDialog(frame,"Course Info Added Successfully !!!");
        txtCID.setText("");
        txtCName.setText("");
        txtCFees.setText("");
        txtCID.requestFocus();
    }

    public static void main(String atgs[])
    {
        new CourseManage();
    }
}
