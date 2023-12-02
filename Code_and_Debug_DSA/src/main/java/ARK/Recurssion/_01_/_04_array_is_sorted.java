package main.java.ARK.Recurssion._01_;

public class _04_array_is_sorted {
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        System.out.println(sorted_array(arr, arr.length));
    }

    static boolean sorted_array(int[] arr, int n){
        if( n == 1){
            return true;
        }
        return (arr[n-1] < arr[n-2])?false:sorted_array(arr, n-1);
    }
}
