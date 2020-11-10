package Lab7;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class UpdateProduct {
    public static void main(String[] args) {
        int ID;
        BigDecimal price1;
        int qty1;

        Scanner input = new Scanner(System.in);
        System.out.println("=== Update The books ===");
        System.out.println("Enter the BookID: ");
        ID = input.nextInt();
        System.out.println("Update the Price: ");
        price1 = input.nextBigDecimal();
        System.out.println("Update the qty: ");
        qty1 = input.nextInt();

        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookstore", "root", "");
                Statement stmt = conn.createStatement();
        ){
            String sqlUpdate = "update books set price = price and qty = qty where bookID = ID ";

            stmt.executeUpdate(sqlUpdate);
            System.out.println("records affected. \n");
            ResultSet rs = stmt.executeQuery(sqlUpdate);
            if(rs.next() ) {
                System.out.println("The correct id");
            }else {
                System.out.println("The Failed id");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
