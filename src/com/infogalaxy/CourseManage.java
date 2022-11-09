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
    JComboBox cmbCID = new JComboBox();
    JLabel lblCName = new JLabel("Enter the Course Name:");
    JTextField txtCName = new JTextField();
    JLabel lblCFees = new JLabel("Enter the Course Fees:");
    JTextField txtCFees = new JTextField();

    JButton btnSubmit ;
    JButton btnCancel = new JButton("CANCEL");
//    JButton btnDelete = new JButton("DELETE");
//    JButton btnUpdate = new JButton("UPDATE");

    CourseManage(String operation)
    {
        btnSubmit = new JButton(operation);
        panel.setLayout(null);

        lblCID.setBounds(50,50,200,30);
        lblCID.setFont(lblFont);
        panel.add(lblCID);

        txtCID.setBounds(260,50,200,30);
        txtCID.setFont(lblFont);
        panel.add(txtCID);

        cmbCID.setBounds(260,50,200,30);
        cmbCID.setFont(lblFont);
        panel.add(cmbCID);

        cmbCID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    DBConn.openCon();
                    ResultSet rs = DBConn.select("select * from courseinfo where CID='" + cmbCID.getSelectedItem() + "'");
                    rs.next();
                    txtCName.setText(rs.getString(3));
                    txtCFees.setText(rs.getString(4));
                    rs.close();
                    //DBConn.con.close();
                } catch (SQLException se){
                    System.out.println("Error in Combobox:"+se.getMessage());
                }
            }
        });

        if(operation.equalsIgnoreCase("ADD")) {
            txtCID.setVisible(true);
            cmbCID.setVisible(false);
        }
        if(operation.equalsIgnoreCase("DELETE")) {
            txtCID.setVisible(false);
            cmbCID.setVisible(true);
            DBConn.openCon();
            ResultSet rs = DBConn.select("Select * from courseinfo");
            try {
                while (rs.next()) {
                    cmbCID.addItem(rs.getString(2).toString());
                    System.out.println(rs.getString(1).toString());
                }
                rs.close();
                //DBConn.con.close();
            } catch (SQLException se) {
                System.out.println("Error in Data Access:"+se.getMessage());
            }

        }

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
                if(operation.equalsIgnoreCase("ADD")) {
                    System.out.println("Click");
                    if(txtCID.getText().toString().isEmpty()) {
                        JOptionPane.showMessageDialog(frame,"Please Enter the Course ID.");
                    } else if(txtCName.getText().toString().isEmpty()) {
                        JOptionPane.showMessageDialog(frame,"Please Enter the Course Name.");
                    } else if(txtCFees.getText().toString().isEmpty()) {
                        JOptionPane.showMessageDialog(frame,"Please Enter the Course Fees.");
                    } else {
                        DBConn.openCon();
                        DBConn.nonSelect("insert into courseinfo(CID,CName,CFees) values('"+txtCID.getText()+"','"+txtCName.getText()+"',"+txtCFees.getText()+")");
//                        JOptionPane.showMessageDialog(frame,"Course Info Added Successfully !!!");
//                        txtCID.setText("");
//                        txtCName.setText("");
//                        txtCFees.setText("");
//                        txtCID.requestFocus();
                        clearComponent();
                    }
                }
                if(operation.equalsIgnoreCase("DELETE")) {
                    DBConn.openCon();
                    DBConn.nonSelect("delete from courseinfo where CID='"+txtCID.getText()+"'");
                    clearComponent();
                }

            }
        });

        btnCancel.setBounds(260,200,180,30);
        btnCancel.setFont(lblFont);
        panel.add(btnCancel);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CourseMenu();
                frame.hide();
            }
        });

//        btnDelete.setBounds(50,240,180,30);
//        btnDelete.setFont(lblFont);
//        panel.add(btnDelete);
//
//        btnDelete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                    DBConn.openCon();
//                    DBConn.nonSelect("delete from courseinfo where CID='"+txtCID.getText()+"'");
//                    clearComponent();
//            }
//        });

//        btnUpdate.setBounds(260,240,180,30);
//        btnUpdate.setFont(lblFont);
//        panel.add(btnUpdate);
//
//        btnUpdate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                    DBConn.openCon();
//                    DBConn.nonSelect("update courseinfo set CName='"+txtCName.getText()+"',CFees="+txtCFees.getText()+" where CID='"+txtCID.getText()+"'");
//                    clearComponent();
//            }
//        });

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
        //new CourseManage();
    }
}
