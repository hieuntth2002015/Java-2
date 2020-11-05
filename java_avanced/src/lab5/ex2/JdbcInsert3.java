package lab5.ex2;

import java.sql.*;

public class JdbcInsert3 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement()
        ){
            String sqlInsert = "insert into books values"
                    + "(8001, 'Java Code','Dang Kim Thi', 15.55,55),"
                    + "(8002, 'java advanted', 'james Gosling', 25.55,55)";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
            int countDeleted = stmt.executeUpdate(sqlInsert);
            System.out.println(countDeleted + " records deleted.\n");
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
