package main.java.gmg._1_level_fundamental._01_basic_for_loop;
import java.util.*;
import java.io.*;
//    Write a program to print all natural numbers from 1 to n
public class printNnumbers {
    public static void main(String[] args) {


        Scanner ip = new Scanner(System.in);
        int num = ip.nextInt();
        int i = 1 ;
        while ( i <= num){
            System.out.println(i);
            i++;
        }

    }

}
