package main.java.ARK.Recurssion._01_;

public class _02_Sum_of_Digit {
    public static void main(String[] args) {
        // Given a number, we need to find sum of its digits using recursion
        int n = 123;
        System.out.println(sum_of_digit(n));
    }
    static int  sum_of_digit(int n){
        if( n == 0){
            return n;
        }

        int sum = (n%10) + sum_of_digit(n/10);

        return sum;
    }
}
