package main.java.gmg._1_level_fundamental._01_basic_for_loop;

import java.util.*;
import java.io.*;

public class SumOfDigits {
//write a program to sum of its Digits

    public static void main(String[] args) {


        Scanner ip = new Scanner(System.in);
        int num = ip.nextInt();


        int sumNumber=0;

        while(num!=0) {
            int digit = num % 10;

            sumNumber = sumNumber + digit;
            num = num / 10;
        }
        System.out.println(sumNumber);

    }
}
