package Java2.Lab4;

import java.sql.*;
import java.util.Scanner;

public class books {
    Scanner scanner = new Scanner(System.in);
    public static String slt;
    public static ResultSet rst;

    public static void main(String[] args) {
        System.out.println("Welcome to E-bookstore!!!");
        System.out.println("============================================================");
        menu();
    }

    public static void top10newest() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127:0.0.1:3306/ebookstore", "root", "");
             Statement stmt = conn.createStatement()) {
            slt = "SELECT * FROM books order by years limit 10";
            rst = stmt.executeQuery(slt);
            System.out.println("THE 10 NEWEST BOOKS:");
            System.out.println("=============================================================================================================");
            System.out.println("bookID\t\t\ttitle\t\t\t\t\t\tauthor\t\t\t\t\t\tyears\t\t\tgenre\t\tstatus\t\tqty\t\tprice");
            while (rst.next()) {
                int id = rst.getInt("bookID");
                String title = rst.getString("title");
                String author = rst.getString("author");
                String years = rst.getString("years");
                int genre = rst.getInt("genre");
                int status = rst.getInt("status");
                int qty = rst.getInt("qty");
                double price = rst.getDouble("price");
                System.out.printf("%-8d\t\t%-20s\t\t%-20s\t\t%-10s\t\t%-6d\t\t%-6d\t\t%-6d\t%-6.1f\n",id,title,author,years,genre,status,qty,price);
            }
            System.out.println("**Status: 1-Out of stock, 2-available, 3-available soon**");
            System.out.println("=============================================================================================================");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void topSeller(){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
             Statement stmt = conn.createStatement()) {
            slt = "select books.bookID,books.title,author,years,genre,books.status,qty,books.price,sum(orderdetail.amount) as soldamount from books inner join orderdetail on books.bookID = orderdetail.bookID inner join orders on orders.orderID = orderdetail.orderID" +
                    " where orders.status != 0 group by books.bookID,books.title,author,years,genre,books.status,qty,books.price order by soldamount DESC limit 10";
            rst = stmt.executeQuery(slt);
            System.out.println("TOP 10 SELLER:\n" +
                    "====================================================================================================================================");
            System.out.println("bookID\t\t\ttitle\t\t\t\t\t\tauthor\t\t\t\t\t\tyears\t\t\tgenre\t\tstatus\t\tqty\t\tprice\tsoldamount");
            while(rst.next()){
                int id = rst.getInt("bookID");
                String title = rst.getString("title");
                String author = rst.getString("author");
                String year = rst.getString("years");
                int genre = rst.getInt("genre");
                int status = rst.getInt("status");
                int qty = rst.getInt("qty");
                double price = rst.getDouble("price");
                int soldamount = rst.getInt("soldamount");
                System.out.printf("%-8d\t\t%-20s\t\t%-20s\t\t%-10s\t\t%-6d\t\t%-6d\t\t%-6d\t%-6.1f\t\t%-6d\n",id,title,author,year,genre,status,qty,price,soldamount);
            }
            System.out.println("**Status: 1-Out of stock, 2-available, 3-available soon**\n" +
                    "====================================================================================================================================");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Display book detail\n" +
                    "2.Display order detail\n" +
                    "3. Exit");
            System.out.println("Your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookdetail();
                    break;
                case 2:
                    orderdetail();
                    break;
                case 3:
                    System.out.println("Goodbye. See you later");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 3);
    }
    public static void bookdetail() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Display the 10 newest books\n" +
                    "2. Top 10 seller\n" +
                    "3. Display books by category\n" +
                    "4. Display books by author\n" +
                    "5. Display books by ID\n" +
                    "6. Exit");
            System.out.println("Your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    top10newest();
                    break;
                case 2:
                    topSeller();
                    break;
                case 3:
                    findBookByCategory();
                    break;
                case 4:
                    findBookByAuthor();
                    break;
                case 5:
                    findBookByID();
                    break;
                case 6:
                    System.out.println("Back to menu. Please wait...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(choice!=6);
    }
    public static void orderdetail() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. New confirmed order\n" +
                    "2. Display order by Customer ID\n" +
                    "3. Display order by order ID\n" +
                    "4. Display order detail by order ID\n" +
                    "5. Display pending order\n" +
                    "6. Display ready order\n" +
                    "7. Display delivering order\n" +
                    "8. Display delivered order\n" +
                    "9. Display canceled order\n" +
                    "0. Exit");
            System.out.println("Your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Back to menu. Please wait...");
                    break;
                case 1:
                    displayOrderByStatus(1);
                    break;
                case 2:
                    displayOrderByCustomerID();
                    break;
                case 3:
                    displayOrderByOrderID();
                    break;
                case 4:
                    OrderDetailByOrderID();
                    break;
                case 5:
                    displayOrderByStatus(2);
                    break;
                case 6:
                    displayOrderByStatus(3);
                    break;
                case 7:
                    displayOrderByStatus(4);
                    break;
                case 8:
                    displayOrderByStatus(5);
                    break;
                case 9:
                    displayOrderByStatus(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(choice!=0);
    }
    public static void findBookByCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the category: (1-Fiction,2-Science,3-Literature)");
        int cat = scanner.nextInt();
        System.out.println("===========================================================================================================================");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
             Statement stmt = conn.createStatement()) {
            slt = "SELECT bookID,title,author,years,books.genre,status,qty,price FROM books inner join category on category.genre = books.genre where books.genre =" + cat;
            rst = stmt.executeQuery(slt);
            System.out.println("bookID\t\t\ttitle\t\t\t\t\t\tauthor\t\t\t\t\t\tyears\t\t\tgenre\t\tstatus\t\tqty\t\tprice");
            while (rst.next()) {
                int id = rst.getInt("bookID");
                String title = rst.getString("title");
                String author = rst.getString("author");
                String years = rst.getString("years");
                int genre = rst.getInt("genre");
                int status = rst.getInt("status");
                int qty = rst.getInt("qty");
                double price = rst.getDouble("price");
                System.out.printf("%-8d\t\t%-20s\t\t%-20s\t\t%-10s\t\t%-6d\t\t%-6d\t\t%-6d\t%-6.1f\n",id,title,author,years,genre,status,qty,price);
            }
            System.out.println("**Status: 1-Out of stock, 2-available, 3-available soon**");
            System.out.println("===========================================================================================================================");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void findBookByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter author's name:");
        String authors = scanner.nextLine();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
             Statement stmt = conn.createStatement()) {
            slt = "SELECT bookID,title,author,years,books.genre,status,qty,price FROM books where author like \'%" + authors + "%\'";
            rst = stmt.executeQuery(slt);
            System.out.println("===============================================================================================================================");
            System.out.println("bookID\t\t\ttitle\t\t\t\t\t\tauthor\t\t\t\t\t\tyears\t\t\tgenre\t\tstatus\t\tqty\t\tprice");
            while (rst.next()) {
                int id = rst.getInt("bookID");
                String title = rst.getString("title");
                String author = rst.getString("author");
                String years = rst.getString("years");
                int genre = rst.getInt("genre");
                int status = rst.getInt("status");
                int qty = rst.getInt("qty");
                double price = rst.getDouble("price");
                System.out.printf("%-8d\t\t%-20s\t\t%-20s\t\t%-10s\t\t%-6d\t\t%-6d\t\t%-6d\t%-6.1f\n",id,title,author,years,genre,status,qty,price);
            }
            System.out.println("**Status: 1-Out of stock, 2-available, 3-available soon**\n" +
                    "===============================================================================================================================");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void findBookByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book's ID:");
        int bookid = scanner.nextInt();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
             Statement stmt = conn.createStatement()) {
            slt = "SELECT bookID,title,author,years,books.genre,status,qty,price FROM books where bookID = " + bookid;
            rst = stmt.executeQuery(slt);
            System.out.println("====================================================================================================================================");
            System.out.println("bookID\t\t\ttitle\t\t\t\t\t\tauthor\t\t\t\t\t\tyears\t\t\tgenre\t\tstatus\t\tqty\t\tprice");
            while (rst.next()) {
                int id = rst.getInt("bookID");
                String title = rst.getString("title");
                String author = rst.getString("author");
                String years = rst.getString("years");
                int genre = rst.getInt("genre");
                int status = rst.getInt("status");
                int qty = rst.getInt("qty");
                double price = rst.getDouble("price");
                System.out.printf("%-8d\t\t%-20s\t\t%-20s\t\t%-10s\t\t%-6d\t\t%-6d\t\t%-6d\t%-6.1f\n",id,title,author,years,genre,status,qty,price);
            }
            System.out.println("**Status: 1-Out of stock, 2-available, 3-available soon**\n" +
                    "====================================================================================================================================");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void displayOrderByStatus(int stt) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
             Statement stmt = conn.createStatement()) {
            switch (stt) {
                case 0:
                    System.out.println("Canceled Order(s)\n" +
                            "===========================================================================================================================");
                    break;
                case 1:
                    System.out.println("Confirmed Order(s)\n" +
                            "===========================================================================================================================");
                    break;
                case 2:
                    System.out.println("Pending Order(s)\n" +
                            "===========================================================================================================================");
                    break;
                case 3:
                    System.out.println("Ready Order(s) \n" +
                            "===========================================================================================================================");
                    break;
                case 4:
                    System.out.println("Delivering Order(s)\n" +
                            "===========================================================================================================================");
                    break;
                case 5:
                    System.out.println("Delivered Order(s)\n" +
                            "===========================================================================================================================");
                    break;
                default:
                    break;
            }
            System.out.println("orderID\t\tcustomerID\t\tdiscount\t\ttotal\t\torderdate\t\tstatus");
            slt = "Select orderID,customerID,discount,total,orderdate,status from orders where status = " + stt;
            rst = stmt.executeQuery(slt);
            while (rst.next()) {
                int id = rst.getInt("orderID");
                int cusID = rst.getInt("customerID");
                int discount = rst.getInt("discount");
                double total = rst.getDouble("total");
                String orderdate = rst.getString("orderdate");
                int status = rst.getInt("status");
                System.out.printf("%-6d\t\t%-8d\t\t%-8d\t\t%-6.1f\t\t%-12s\t%-6d\n",id,cusID,discount,total,orderdate,status);
            }
            System.out.println("===========================================================================================================================");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void displayOrderByCustomerID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer ID: ");
        int cusid = scanner.nextInt();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
             Statement stmt = conn.createStatement()) {
            System.out.println("==================================================================================================");
            System.out.println("orderID\t\tcustomerID\t\tdiscount\t\ttotal\t\torderdate\t\tstatus");
            slt = "Select orderID,customerID,discount,total,orderdate,status from orders where customerID =" + cusid;
            rst = stmt.executeQuery(slt);
            while (rst.next()) {
                int id = rst.getInt("orderID");
                int cusID = rst.getInt("customerID");
                int discount = rst.getInt("discount");
                double total = rst.getDouble("total");
                String orderdate = rst.getString("orderdate");
                int status = rst.getInt("status");
                System.out.printf("%-6d\t\t%-8d\t\t%-8d\t\t%-6.1f\t\t%-12s\t%-6d\n",id,cusID,discount,total,orderdate,status);
            }
            System.out.println("**Status: 0-Canceled, 1-Confirmed, 2-Pending,3-Ready,4-Delivering,5-Delivered");
            System.out.println("==================================================================================================");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void displayOrderByOrderID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order ID: ");
        int orid = scanner.nextInt();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
             Statement stmt = conn.createStatement()) {
            System.out.println("=========================================================================================================");
            System.out.println("orderID\t\tcustomerID\t\tdiscount\t\ttotal\t\torderdate\t\tstatus");
            slt = "Select * from orders where orderID =" + orid;
            rst = stmt.executeQuery(slt);
            while (rst.next()) {
                int id = rst.getInt("orderID");
                int cusID = rst.getInt("customerID");
                int discount = rst.getInt("discount");
                double total = rst.getDouble("total");
                String orderdate = rst.getString("orderdate");
                int status = rst.getInt("status");
                System.out.printf("%-6d\t\t%-8d\t\t%-8d\t\t%-6.1f\t\t%-12s\t%-6d\n",id,cusID,discount,total,orderdate,status);
                switch (status) {
                    case 0:
                        System.out.println("Canceled Order(s)");
                        System.out.println("=========================================================================================================");
                        break;
                    case 1:
                        System.out.println("Confirmed Order(s)");
                        System.out.println("=========================================================================================================");
                        break;
                    case 2:
                        System.out.println("Pending Order(s)");
                        System.out.println("=========================================================================================================");
                        break;
                    case 3:
                        System.out.println("Ready Order(s)");
                        System.out.println("=========================================================================================================");
                        break;
                    case 4:
                        System.out.println("Delivering Order(s)");
                        System.out.println("=========================================================================================================");
                        break;
                    case 5:
                        System.out.println("Delivered Order(s)");
                        System.out.println("=========================================================================================================");
                        break;
                    default:
                        break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void OrderDetailByOrderID() {
        System.out.println("Enter Order ID: ");
        Scanner scanner = new Scanner(System.in);
        int orid = scanner.nextInt();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
             Statement stmt = conn.createStatement()) {
            System.out.println("===========================================================================================================================");
            System.out.println("orderID\t\toderdate\t\tbookID\t\ttitle\t\t\t\tprice\t\tamount");
            slt = "Select orders.orderID,orderdate,bookID,title,price,amount from orders inner join orderdetail on orders.orderID = orderdetail.orderID where orders.orderID =" + orid;
            rst = stmt.executeQuery(slt);
            while (rst.next()) {
                int id = rst.getInt("orderID");
                String date = rst.getString("orderdate");
                int bookid = rst.getInt("bookID");
                String title = rst.getString("title");
                double price = rst.getDouble("price");
                int amount = rst.getInt("amount");
                System.out.printf("%-6d\t\t%-12s\t%-8d\t%-12s\t\t%-6.1f\t\t%-6d\n",id,date,bookid,title,price,amount);
            }
            System.out.println("===========================================================================================================================");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}