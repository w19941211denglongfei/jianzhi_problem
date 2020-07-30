package day1;

import java.util.Scanner;

public class NumberOf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numberOf1(n));
    }
    public static int  numberOf1(int n){
        int count = 0;
        while (n != 0){
            n = (n - 1) & n;
            count++;
        }
        return count;
    }
}
