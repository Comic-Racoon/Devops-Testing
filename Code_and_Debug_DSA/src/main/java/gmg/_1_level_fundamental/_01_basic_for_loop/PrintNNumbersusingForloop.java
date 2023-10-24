package main.java.gmg._1_level_fundamental._01_basic_for_loop;
import java.util.*;


public class PrintNNumbersusingForloop {
    public static void main(String [] args) {
        //Write a program to print numbers from 1 to 10.
      Scanner ip = new Scanner(System.in);
      int n = ip.nextInt();
      
      for(int i=1 ; i<=n ; i++){
          System.out.println(i);
      }
    }
}