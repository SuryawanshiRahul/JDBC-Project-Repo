package com.infogalaxy;
import java.sql.*;
public class DBConn {
    public static  Driver d;
    public static Connection con;
    public static Statement stmt;

    //ORACLE DB Connectivity
//    static String URL ="jdbc:oracle:thin:@localhost:1521:xe";
//    static String username = "system";
//    static String password = "infogalaxy";

    //MYSQL DB Connectivity
    static String URL ="jdbc:mysql://localhost:3306/igcdb";
    static String username = "root";
    static String password = "";

    public static void openCon() {
        try {
            //d = new oracle.jdbc.driver.OracleDriver();
            d = new com.mysql.jdbc.Driver();
            con = DriverManager.getConnection(URL, username, password);
            stmt = con.createStatement();
        } catch (SQLException se) {
            System.out.println("Error in Database Connection");
        }
    }
    public static void nonSelect(String query) {
        try {
            stmt.executeUpdate(query);
            con.close();
        } catch (SQLException se) {
            System.out.println("Query Execution Failed");
        }
    }
    public static ResultSet select(String query) {
        ResultSet rs=null;
        try {
            rs = stmt.executeQuery(query);
            //con.close();
        } catch (SQLException se) {
            System.out.println("Data Access Failed"+se.getMessage());
        }
        return rs;
    }

}
