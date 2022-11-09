package com.infogalaxy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseMenu {

    JFrame frame = new JFrame("CourseMenu");
    JPanel panel = new JPanel();
    JPanel panelHead = new JPanel();
    JPanel panelMenu = new JPanel();
    Font lblFont = new Font("Algerian",Font.BOLD,20);
    JButton btnAdd = new JButton("ADD COURSE");
    JButton btnCancel = new JButton("VIEW COURSE");
    JButton btnDelete = new JButton("DELETE COURSE");
    JButton btnUpdate = new JButton("UPDATE COURSE");
    CourseMenu()
    {
        panel.setLayout(null);
        panelHead.setLayout(null);
        panelMenu.setLayout(null);

//        panelHead.setBounds(1,1,800,100);
//        panelHead.setBackground(Color.RED);
//        frame.add(panelHead);
//        panelMenu.setBounds(1,100,200,700);
//        panelMenu.setBackground(Color.YELLOW);
//        frame.add(panelMenu);
        panel.setBounds(200,100,600,700);
        panel.setBackground(Color.CYAN);
        frame.add(panel);

        btnAdd.setBounds(50,200,180,30);
        btnAdd.setFont(lblFont);
        panel.add(btnAdd);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new CourseManage("ADD");
                frame.hide();
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
                new CourseManage("DELETE");
            }
        });

        btnUpdate.setBounds(260,240,180,30);
        btnUpdate.setFont(lblFont);
        panel.add(btnUpdate);

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.setSize(800,800);
        frame.setLocation(100,100);
        frame.show();
    }

    public static void main(String atgs[])
    {
        new CourseMenu();
    }
}
