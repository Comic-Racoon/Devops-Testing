package main.java.gmg._1_level_fundamental._01_basic_for_loop;

import java.util.*;
import java.io.*;

public class PrintTables {

    public static void main(String[] args) {


        Scanner ip = new Scanner(System.in);
        int tableNumber = ip.nextInt();
        int i=1;
        while(i != 11){
            System.out.println( tableNumber + " " + " x " + i + " " + " = "+ " " + tableNumber*i );
            i++;
        }



    }
}
