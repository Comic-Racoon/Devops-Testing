package main.java.gmg._1_level_fundamental._01_basic_for_loop;
import java.util.*;
import java.io.*;
public class Factoiral {
    public static void main(String []args) {
// Write a program to find the factorial value of any number
        Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        int fact=1;
        for(int i=1 ; i<=n ;i++){
            fact = fact*i;
           
        }
        
        System.out.println(fact); 
 
    }
}