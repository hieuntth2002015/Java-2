package Lab6.North;
import java.sql.*;
public class Category {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind",
                        "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String strUpdate = "update categories set CategoryName = 'SeaFood' where CategoryID=8 ";
            System.out.println("The SQL statement is : " + strUpdate + "\n");
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records affected. \n");

            String strSelect = "select * from categories where CategoryID = 8";
            System.out.println("The SQL statement is : " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) {
                System.out.println(rset.getInt("CategoryID") + ","
                +rset.getString("CategoryName") + ","
                +rset.getString("Description") + ","
                +rset.getLong("Picture"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
