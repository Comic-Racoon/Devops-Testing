package main.java.ARK.Recurssion._01_;

public class _01_Tower_Of_Hanoi {
    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, "start", "end", "helper");
    }

    static void towerOfHanoi(int n, String start, String end, String helper) {
        if (n == 1) {
            System.out.println("Move disk " + n +" from rod " + start + " to rod " + end);
            return;
        }

        towerOfHanoi(n - 1, start, helper, end);

        System.out.println("Move disc " + n + " from rod " + start + " to rod " + end);

        towerOfHanoi(n - 1, helper, end, start);
    }
}
