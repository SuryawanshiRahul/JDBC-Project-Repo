package com.infogalaxy;
import java.sql.*;
public class DBConn {
    public static  Driver d;
    public static Connection con;
    public static Statement stmt;

    static String URL ="jdbc:oracle:thin:@localhost:1521:xe";
    static String username = "system";
    static String password = "infogalaxy";

    public static void openCon() {
        try {
            d = new oracle.jdbc.driver.OracleDriver();
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
}
