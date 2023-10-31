package main.java.ARK._3_Array._02_practice.Easy;

public class _04_find_min_and_max_ele_of_array {

    // link : https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

    public static void main(String[] args) {
        int [] arr = {10,69,82,57,929,21,7,54};

        solution1_4 solution1_4 = new solution1_4();
        System.out.println(solution1_4.max_ele_of_arr(arr));
        System.out.println(solution1_4.min_ele_of_arr(arr));
    }
    static class solution1_4{
        static int min_ele_of_arr(int[] arr){

            int max_no = arr[0];

            for(int i=1; i<arr.length; i++){
                if (max_no < arr[i]){
                    max_no = arr[i];
                }
            }
            return max_no;
        }

        static int max_ele_of_arr(int[] arr){
            int min_no = arr[0];
            for (int i =1; i< arr.length; i++){
                if (min_no > arr[i]){
                    min_no = arr[i];
                }
            }
            return min_no;
        }
    }
}
