package main.java.gmg._1_level_fundamental._01_basic_for_loop;

import java.util.*;
import java.io.*;

public class PrimeOrNot {
// write a program to Check Whether a Given Number is Prime or Not
    public static void main(String[] args) {


        Scanner ip = new Scanner(System.in);
        int num = ip.nextInt();
        int flag=0;
        for(int i=2 ; i<num ; i++){
            if(num%i==0){
                flag++;
                break;
            }
        }

        if(flag==0){
            System.out.println(num + " number is  prime");
        }
        else{
            System.out.println(num + " number is  not prime");
        }

    }
}
