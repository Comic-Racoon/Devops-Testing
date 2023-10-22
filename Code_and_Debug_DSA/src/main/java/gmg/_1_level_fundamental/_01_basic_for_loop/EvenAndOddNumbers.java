package main.java.gmg._1_level_fundamental._01_basic_for_loop;
import java.util.*;
import java.io.*;
public class EvenAndOddNumbers {
    public static void main(String [] args) {
//Write a program to print all even numbers between 1 to 100
////Write a program to print all odd numbers between 1 to 100
        Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        // for(int i=1 ; i<=n ; i++){
        //     if(i%2 == 0){
        //         System.out.println(i);
        //     }
        // }
        for(int i=1 ; i<=n ; i++){
            if(i%2 != 0){
                System.out.println(i);
            }
        }
 
    }
}