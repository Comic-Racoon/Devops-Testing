package main.java.gmg._1_level_fundamental._01_basic_for_loop;
import java.util.*;
import java.io.*;
public class SumOfEvenOdd {
    public static void main(String [] args) {
 //Write a program to find sum of all natural numbers between 1 to n    
 //Write a program to find sum of all even numbers between 1 to n
 //Write a program to find sum of all odd numbers between 1 to n
        Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        int sum=0;
        // for(int i=1 ; i<=n ; i++){
        //     sum=sum+i;
        // }
        // System.out.println("Sum of the n natural number is " + sum);
        
        // for(int i=1 ; i<=n ; i++){
        //     if(i%2==0){
        //         sum=sum+i;
        //     }
        // }
        // System.out.println("Sum of the n even number is " + sum);
        
        
        for(int i=1 ; i<=n ; i++){
            if(i%2!=0){
                sum=sum+i;
            }
        }
        System.out.println("Sum of the n odd number is " + sum);
        
    }
}