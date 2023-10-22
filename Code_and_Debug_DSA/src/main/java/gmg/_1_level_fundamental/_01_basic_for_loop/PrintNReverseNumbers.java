package main.java.gmg._1_level_fundamental._01_basic_for_loop;
import java.util.*;
import java.io.*;
public class PrintNReverseNumbers{
    public static void main(String [] args) {
      
        
      Scanner ip = new Scanner(System.in);
      int n = ip.nextInt();
      
      for(int i=0 ; i<n ; i++){
          
	  System.out.println(n-i);
	  
      }
	  
    }
}