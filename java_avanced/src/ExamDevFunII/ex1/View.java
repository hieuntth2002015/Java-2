package ExamDevFunII.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class View {
    int n;
    final int SENTINEL = 4;
    Scanner sc = new Scanner(System.in);
    StudentClass uc = new StudentClass();
    ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        View views = new View();
        views.view();
    }
    public static void showMenu() {
        System.out.println("1. Add student records\n" +
                "2.Display student records\n" +
                "3.Save\n" +
                "4.Exit");
        System.out.print("Please choose: ");
    }
    public void view(){

        showMenu();
        while (true) {
            View views = new View();
            views.showMenu();

            n = sc.nextInt();
            while (n != SENTINEL) {
                switch (n) {
                    case 1:
                        views.add();
                        break;
                    case 2:
                        views.show();
                        break;
                    case 3:
                        views.save();
                }
                views.showMenu();
                n = sc.nextInt();
            }
            System.out.println("Exit");
            }

    }

    public void add() {
        String studentID;
        String studentName;
        String address;
        String phone;

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Add Student Record ===");
        System.out.println("Enter the StudentID: ");
        studentID = sc.nextLine();
        System.out.println("Enter the StudentName: ");
        studentName = sc.nextLine();
        System.out.println("Enter the Address: ");
        address = sc.nextLine();
        System.out.println("Enter the Phone:");
        phone = sc.nextLine();
    }
    public void show() {
        System.out.println("================ List Students ===============");
        Iterator<Student> StudentsIterator =  studentList.iterator();
        while (StudentsIterator.hasNext()){
            Student st1 = StudentsIterator.next();
            System.out.println(st1);
        }
    }
    public void save() {
        Iterator<Student> StudentsIterator = studentList.iterator();
        while (StudentsIterator.hasNext()) {
            Student st1 = StudentsIterator.next();
            uc.insertStudent(st1);
        } uc.selectStudent();
    }


}
