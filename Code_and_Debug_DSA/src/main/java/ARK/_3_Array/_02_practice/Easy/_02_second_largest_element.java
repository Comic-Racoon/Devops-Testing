package main.java.ARK._3_Array._02_practice.Easy;


public class _02_second_largest_element {

    //link : https://www.codingninjas.com/studio/problems/second-largest-element-in-the-array_873375?leftPanelTab=0

    public static void main(String[] args) {
        int n = 5 ;
        int[] arr = {1,2,3,4,5};

        solution1_2 solution1_2 = new solution1_2();
        System.out.println(_02_second_largest_element.solution1_2.second_largest_ele(arr, n));
    }

    static class solution1_2{

        /*
        Space complexity : here we have variable largest_no and _2_largest_no
                           both size didn't  change through out code hence
                           s(const) + s(const) --> O(1)
        Time complexity : value of n in looped once fully
                          loop runs n times, and n is the size of the array
                           O(n)        --> O(n)
         */
        static int second_largest_ele (int[] arr, int n){
            int largest_no = 0;
            int _2_largest_no = -1;

            for(int i =0 ; i<n ; i++){
                if(arr[i] > arr[largest_no] ){
                    _2_largest_no = largest_no;
                    largest_no = i;
                }
                else if (arr[i] < arr[largest_no]) {
                    if (_2_largest_no == -1 || arr[_2_largest_no] < arr[i])
                        _2_largest_no = i;
                }
            }
            return arr[_2_largest_no];
        }
    }
}
