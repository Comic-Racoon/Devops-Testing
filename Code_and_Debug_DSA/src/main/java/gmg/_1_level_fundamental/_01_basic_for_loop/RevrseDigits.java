package main.java.gmg._1_level_fundamental._01_basic_for_loop;

import java.util.*;
import java.io.*;

public class RevrseDigits {
//write a program to reverse the given Digits
    public static void main(String[] args) {


        Scanner ip = new Scanner(System.in);
        int num = ip.nextInt();
        // 123 ->> 321
        int revNumber=0;

        while(num!=0){
            int digit=num%10;

            revNumber = revNumber*10+digit;
            num=num/10;

        }

        System.out.println(revNumber);


    }
}
