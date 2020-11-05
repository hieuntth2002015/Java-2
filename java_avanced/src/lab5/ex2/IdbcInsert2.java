package lab5.ex2;

import java.sql.*;

public class IdbcInsert2 {
    public static void main(String[] args) {
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", ""); // for MySQL only

                // Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement()
        ) {
            // Step 3 & 4: Execute a SQL INSERT|DELETE statement via executeUpdate(),
            //   which returns an int indicating the number of rows affected.

            // DELETE records with id>=3000 and id<4000
            String sqlDelete = "delete from books where id >8000";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");  // Echo for debugging
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");


        } catch(SQLException ex) {
            ex.printStackTrace();
        }  // Step 5: Close conn and stmt - Done automatically by try-with-resources
    }
}
