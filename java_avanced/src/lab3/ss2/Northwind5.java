package lab3.ss2;

import java.math.BigDecimal;
import java.sql.*;

public class Northwind5 {
    public static void main(String[] args) {
        try(
                Connection conn  = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root","");
                Statement stmt1 = conn.createStatement();
        ){
            String strSelect = "select ProductID, ProductName, UnitPrice from products where UnitPrice >= 18.000 and UnitPrice <=22.000";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset1 = stmt1.executeQuery(strSelect);

            System.out.println("The Record selected are: ");
            int rowCount =0;
            while(rset1.next()) {
                int ProductID = rset1.getInt("ProductID");
                String ProductName = rset1.getString("ProductName");
                BigDecimal UnitPrice = rset1.getBigDecimal("UnitPrice");

                System.out.println(ProductID + "-" + ProductName + "-" + UnitPrice );
                ++rowCount;
            }
            System.out.println("Total number of record = " + rowCount);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
