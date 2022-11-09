package com.jdbc;
import java.sql.*;
public class DataAccess {
    public static void main(String[] args) {
        try {
            //Step 1 Register the Driver
            Driver d = new com.mysql.jdbc.Driver();

            //Step 2 Get Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igcdb","root","");

            //Step 3 Create Statement Object
            Statement stmt = con.createStatement();

            //Step 4 Execute The Query
            ResultSet rs = stmt.executeQuery("Select * from courseinfo");

            while(rs.next()) {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
            }

//            if(rs.next()) {
//                System.out.println("Data Available");
//                System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
//            } else {
//                System.out.println("Data Not Available");
//            }

            //Step 5 Close Connection
            con.close();
        } catch (SQLException se) {
            System.out.println("Error in Database Connection - "+se.getMessage());
        }
    }
}
