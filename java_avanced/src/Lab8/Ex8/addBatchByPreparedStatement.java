package Lab8.Ex8;

import java.sql.*;

public class addBatchByPreparedStatement {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop", "root", "");
                PreparedStatement pstmt = conn.prepareStatement(
                        "insert into books values(?,?,?,?,?)");
        ) {
            try {

                conn.setAutoCommit(false);

                pstmt.setInt(1, 8003);
                pstmt.setString(2, "java 123");
                pstmt.setString(3, "Kevin Jones");
                pstmt.setDouble(4, 12.34);
                pstmt.setInt(5, 88);
                pstmt.addBatch();

                pstmt.setInt(1, 8004);
                pstmt.setString(2, "Java 456");

                pstmt.addBatch();

                int[] returnCodes = pstmt.executeBatch();

                System.out.print("Return code are:");
                for (int code : returnCodes) System.out.printf(code + ",");
                System.out.println();
                conn.commit();
            } catch (SQLException ex) {
                System.out.println("--Rolling back changes--");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
