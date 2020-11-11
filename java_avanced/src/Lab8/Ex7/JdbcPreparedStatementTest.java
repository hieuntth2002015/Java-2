package Lab8.Ex7;

import java.sql.*;

public class JdbcPreparedStatementTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop", "root", "");
                PreparedStatement pstmt = conn.prepareStatement(
                        "insert into books value(?, ?, ?, ?, ?)");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from books ");
                ) {
            pstmt.setInt(1, 7001);
            pstmt.setString(2, "Mahjong 101");
            pstmt.setString(3, "kumar");
            pstmt.setDouble(4, 88.88);
            pstmt.setInt(5,88);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "rows affected");

            pstmt.setInt(1,7002);
            pstmt.setString(2, "Mahjong 102");
            rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "rows affected.");

            ResultSet rset = pstmtSelect.executeQuery();
            while(rset.next()) {
                System.out.println(rset.getInt("id") + ","
                +rset.getString("author") + ","
                +rset.getString("title") + ","
                +rset.getDouble("price") + ","
                +rset.getInt("qty"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
