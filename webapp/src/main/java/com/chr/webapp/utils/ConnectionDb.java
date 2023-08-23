package com.chr.webapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
	private static  String url = "jdbc:mysql://localhost:3306/javajdbc?serverTimeZone=America/El_Salvador";
    private static String username = "root";
    private static String pass = "";
    private static Connection conn = null;

    public static Connection getInstance() throws SQLException {
        
        return DriverManager.getConnection(url, username, pass);
        
    }
}
