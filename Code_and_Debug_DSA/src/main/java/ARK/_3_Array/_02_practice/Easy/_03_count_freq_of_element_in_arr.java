package main.java.ARK._3_Array._02_practice.Easy;

import java.util.HashMap;

public class _03_count_freq_of_element_in_arr {

    // link : https://www.geeksforgeeks.org/counting-frequencies-of-array-elements/
    public static void main(String[] args) {
    /*
    Input :  arr[] = {10, 20, 20, 10, 10, 20, 5, 20}
    Output : 10 3
         20 4
         5  1

     */

        int[] arr = {10, 20, 20, 10, 10, 20, 5, 20};

        solution1_3 solution1_3 = new solution1_3();
        System.out.println(solution1_3.freq_of_ele( arr));
    }

    static class solution1_3 {
        /*
        Space complexity : The primary space used in this function is for the HashMap data structure.
                           The space required for the HashMap is proportional to the number of distinct
                           elements in the input array arr. In the worst case, if all elements are distinct,
                           the space complexity would be O(n), where 'n' is the length of the input array.
                           Therefore, the space complexity of this code is O(n) in the worst case when all elements are distinct.
                           space complexity :  as hashmap --> O(n)

        Time Complexity : 1 for loop complexity O(n)
                          HASH MAP  complexity for get and put is O(1)
                          hence Time complexity : --> O(n) + O(1) + O(1) --> [[  O(n)  ]]
         */
        public static HashMap<Integer, Integer> freq_of_ele( int[]arr ){
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i=0; i< arr.length; i++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
                else{
                    map.put(arr[i], 1);
                }
            }
            return map;
        }
    }
}
