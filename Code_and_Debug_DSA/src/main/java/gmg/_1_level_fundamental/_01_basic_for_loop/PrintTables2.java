package main.java.gmg._1_level_fundamental._01_basic_for_loop;
import java.util.*;
import java.io.*;
public class PrintTables2 {
    public static void main(String [] args) {
//Write a program to print tables
        Scanner ip = new Scanner(System.in);
        int num = ip.nextInt();
        
        for(int i=1 ; i<=10 ; i++){
           System.out.println(num + " " + " x " + " "+ i + " = " + num*i ); 
        }
        
 
    }
}