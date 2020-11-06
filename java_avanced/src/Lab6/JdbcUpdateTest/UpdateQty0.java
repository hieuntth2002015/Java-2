package Lab6.JdbcUpdateTest;

import java.sql.*;

public class UpdateQty0 {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String strUpdate = "update books set qty= 0 where title ='A Teaspoon of Java'";
            System.out.println("The SQL statement is : " + strUpdate + "\n");
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records affected. \n");

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
