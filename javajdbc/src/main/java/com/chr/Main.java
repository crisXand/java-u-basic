package com.chr;

import com.chr.util.DbConnecction;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
         try (
                Connection conn = DbConnecction.getInstance();
                Statement stm = conn.createStatement();
                ResultSet result = stm.executeQuery("SELECT * FROM productos");
                ) {
            while(result.next()){
                System.out.print(result.getInt("id"));
                System.out.print(" | ");
                System.out.print(result.getString("product_name"));
                System.out.print(" | ");
                System.out.print(result.getDouble("price"));
                System.out.print(" | ");
                System.out.print(result.getDate("date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}