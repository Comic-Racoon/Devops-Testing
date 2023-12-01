package main.java.ARK.Recurssion._01_;

public class _03_sum_of_natural_no {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(sum_of_number(n));
    }

    static int sum_of_number(int n){
        if(n==0){
            return 0;
        }

        int sum = n + sum_of_number(n-1);
        return sum;
    }
}
