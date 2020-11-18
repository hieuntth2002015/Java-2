package ExamDevFunII.ex1;

import java.sql.*;
import java.util.Scanner;

public class StudentClass {
    public void insertStudent(Student student) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root","");
                //Step2
                Statement stmt = conn.createStatement()
        ) {
            String sqlInsert = "insert into Students values (" + " '" + student.getStudentID() + "', '"  + student.getStudentName() + "', '"  + student.getAddress() + "', '"+ student.getPhone()+ "'" +")";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void selectStudent() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root","");
                //Step2
                Statement stmt = conn.createStatement()
        ){
            System.out.println("============================================================================");
            ResultSet rset = stmt.executeQuery("select * from Students");
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColumns = rsetMD.getColumnCount();

            //Print column names - Column Index begins at 1 (instead of 0)
            for ( int i = 1; i <= numColumns; i++){
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            System.out.println();

            for (int i = 1 ; i <= numColumns; i++){
                System.out.printf("%-30s",
                        "(" + rsetMD.getColumnName(i) + ")");
            }
            System.out.println();

            while (rset.next()) {
                for (int i = 1; i <= numColumns; ++i) {
                    //getString() can be used for all column types
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}