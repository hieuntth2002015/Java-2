package lab3.ss2;

import java.sql.*;

public class Northwind2 {
    public static void main(String[] args) {
        try(
                Connection conn  = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root","");
                Statement stmt1 = conn.createStatement();
        ){
            String strSelect = "select CustomerId, CompanyName, Address, Phone from customers where CompanyName = 'Alfreds Futterkiste'";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset1 = stmt1.executeQuery(strSelect);

            System.out.println("The Record selected are: ");
            int rowCount =0;
            while(rset1.next()) {
                String CustomerID = rset1.getString("CustomerID");
                String CompanyName = rset1.getString("CompanyName");
                String Address = rset1.getString("Address");
                String Phone = rset1.getString("Phone");
                System.out.println(CustomerID + "," + CompanyName + "," + Address + "," + Phone);
                ++rowCount;
            }
            System.out.println("Total number of record = " + rowCount);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
