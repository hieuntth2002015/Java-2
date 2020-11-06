package Lab6.North;

import java.sql.*;
import java.sql.*;
public class Customer {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind",
                        "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String strUpdate = "update customers set Address = '1A Yet Kieu - Ha Noi' where CustomerID= 'FRANK' ";
            System.out.println("The SQL statement is : " + strUpdate + "\n");
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records affected. \n");

            String strSelect = "select * from customers where CustomerID = 'FRANK' ";
            System.out.println("The SQL statement is : " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) {
                System.out.println(rset.getString("CustomerID") + ","
                        +rset.getString("CompanyName") + ","
                        +rset.getString("Address") + ","
                        +rset.getString("Phone"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
