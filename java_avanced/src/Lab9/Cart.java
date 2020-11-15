package Lab9;

import java.sql.*;
import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Chose N to stop and Y to continue");
        System.out.print("N: ");
        int n = sc.nextInt();
        System.out.print("Y: ");
        int y = sc.nextInt();

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
                ){
            String sqlSelect = "bookID, title, price, qty form books where bookID = '" + "
        }
    }
}
