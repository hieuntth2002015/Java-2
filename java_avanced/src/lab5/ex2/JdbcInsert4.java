package lab5.ex2;

import java.sql.*;

public class JdbcInsert4 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement()
                ){
            String sqlInsert = "insert into books (id, title, author) values (2002,'Java JDBC MySQL', 'ThiDK')";
            System.out.println("The SQL Statement is:" + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);

            String sqlDeleted = "delete from books where id = 2001";
            System.out.println("The SQL statement is :" + sqlDeleted + "\n");
            countInserted = stmt.executeUpdate(sqlDeleted);
            System.out.println(countInserted + "records deleted. \n");

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
