package ss2.ex1;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        int days;
        int sum = 0;
        float average;
        System.out.print("How many days' temperatures? ");
        Scanner input = new Scanner(System.in);
        days = input.nextInt();
        int[] temp = new int[days];
        for(int i=1;i<=temp.length;i++) {
            System.out.print("Day " + i + "\'s high temp: ");
            temp[i-1] = input.nextInt();
            sum += temp[i-1];
        }
        average = (float)sum/days;
        int j = 0;
        System.out.println("\nAverage = "+average);
        for(int i = 0;i<temp.length;i++){
            if(temp[i]>average){
                j+=1;
            }
        }
        System.out.println(j+" days above average");
    }
}
