package Lab8.ex4;

import java.sql.*;

public class jdbcCommitCatchTest {
    public static void main(String[] args) throws SQLException {

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            try {
                conn.setAutoCommit(false);

                stmt.executeUpdate("insert into books values(4001, 'Paul Chan', 'Mahjong 101',4.4,4)");
                stmt.executeUpdate("insert into books values(4001, 'Peter Chan', 'Mahjong 102', 4.4,4)");
                conn.commit();
            } catch (SQLException ex) {
                System.out.println("--Rolling back changes--");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
