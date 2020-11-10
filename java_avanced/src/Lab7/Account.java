package Lab7;

import java.sql.*;
import java.util.Scanner;

public class Account {
    public static void main(String[] args ) {
        Scanner sc = new Scanner(System.in);

        System.out.print("userName: ");
        String user = sc.nextLine();
        System.out.print("password: ");
        String pass = sc.nextLine();

        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ebookstore", "root", "");
            Statement stmt = conn.createStatement()
        ){
            if(user.equals("") || pass.equals("")) {
                System.out.println("Please Enter the UserName and Password");
            }else {


                String sql = "select userName, password from users where userName='" + user+"' and password='"+pass+"'";
//                PreparedStatement stm = conn.prepareStatement(sql);
//                stm.setString(1,user);
//                stm.setString(2,pass);
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()) {
                    System.out.println("Logged in successfully");
                }else {
                    System.out.println("Login failed");
                }

            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
