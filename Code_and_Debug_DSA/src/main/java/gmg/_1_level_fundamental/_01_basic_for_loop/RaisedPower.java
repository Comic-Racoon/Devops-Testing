package main.java.gmg._1_level_fundamental._01_basic_for_loop;
import java.util.*;
import java.io.*;
public class RaisedPower {
    public static void main(String []args) {
//Write a program to find the value of one number raised to the power of another
        Scanner ip = new Scanner(System.in);
        int num = ip.nextInt();
        int raisedToPower = ip.nextInt();
        int ans=1;
        for(int i=1 ; i<= raisedToPower ; i++ ){
            ans*=num;
        }
        System.out.println(ans);
 
    }
}