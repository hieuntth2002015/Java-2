package Lab7;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class ProductDetails {
    public static void main(String[] args) {
        int bookID;
        String title;
        String author;
        BigDecimal price;
        int qty;
        int genre;
        int status;

        Scanner input = new Scanner(System.in);
        System.out.println("=== Add the book ===");
        System.out.println("Enter the bookID: ");
        bookID = input.nextInt();
        input.nextLine();
        System.out.println("Enter the title : ");
        title = input.nextLine();
        System.out.println("Enter the author: ");
        author = input.nextLine();
        System.out.println("Enter the genre: ");
        genre = input.nextInt();
        System.out.println("Enter the status: ");
        status = input.nextInt();
        System.out.println("Enter the qty: ");
        qty = input.nextInt();
        System.out.println("Enter the Price: ");
        price = input.nextBigDecimal();

        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookstore", "root", "");
                Statement stmt = conn.createStatement();
        ){
            String sqlInsert = "insert into books (bookID, title, author, genre, status,qty, price) values ("+bookID+", \" "+title+" \", \""+author+"\","+genre+", "+status+" ,"+qty+","+price+")";
            System.out.println("The SQL statemnet is: " + sqlInsert);
            stmt.executeUpdate(sqlInsert);
            System.out.println("records inserted. \n");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
