package Lab6.North;

import java.sql.*;

public class Products {
    public static void main(String[]args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind",
                        "root", "");
                Statement stmt = conn.createStatement();
                ) {
            String strUpdate  = "update products set UnitPrice = UnitPrice*1.1 where CategoryID = 5 and 7 and 8";
            System.out.println("The SQL statement is : " + strUpdate + "\n");
            int countUpdate = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdate + "records affected. \n");

            String strSelect = "selecet * from products where CategoryID = 5 and 7 and 8";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) {
                System.out.println(rset.getInt("ProductID") + ","
                        +rset.getString("ProductName") + ","
                        +rset.getInt("CategoryID") + ","
                        +rset.getBigDecimal("UnitPrice"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
