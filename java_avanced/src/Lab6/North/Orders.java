package Lab6.North;

import java.sql.*;

public class Orders {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind",
                        "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String strUpdate = "update orders set ShipVia = 3 where OrderID = 10313";
            System.out.println("The SQL statement is : " + strUpdate + "\n");
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records affected. \n");

            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
