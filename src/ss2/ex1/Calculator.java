package ss2.ex1;

import javax.swing.text.Element;
import java.util.Scanner;

public class Calculator {
    public static int[] intArray(int size){
        int[] val = new int[size];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter "+size+" interger values:");
        for (int i=0;i<val.length;i++) {
            val[i] = input.nextInt();
        }
        for (int i=0;i<val.length;i++){
            System.out.println("Element "+i+" ,typed value was "+val[i]);
        }
        return val;
    }
    public static double getAverage(int[] array){
        float sum = 0;
        for(int i = 0;i<array.length;i++){
            sum+= array[i];
        }
        return sum/array.length;
    }
    public static void main(String[] args) {
        int[] abc = intArray(5);
        System.out.printf("Average is %.1f",getAverage(abc));
    }
}
