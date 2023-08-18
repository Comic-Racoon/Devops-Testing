package ARK;

import java.util.HashMap;

public class _01_contains_duplicate {
    public static void main(String[] args) {

//        Given an integer array nums, return true if any value appears at least twice in the
//        array, and return false if every element is distinct
//        link : https://leetcode.com/problems/contains-duplicate/

        int[] nums = {1,2,3,4};

        solution1 solution1 = new solution1();
        System.out.println(solution1.containsDuplicate(nums));
    }

    static class solution1 {
        /* space complex : For hashmap to store n.length of elements in worst case if all are unique will be O(n)
                           If there are duplicate elements, the space complexity would be less than O(n)
                  ans -> space complexity = O(n)

           time complex  : here time complexity determined by the loop that iterates through the nums as n elements
                           n for the loop
                           - Inside loop :
                             map.containsKey(nums[i]) : it takes O(1) on avg
                             map.put(nums[i], i)      : it also takes O(1) on avg
                  ans -> n x ( O(1) + O(1) ) -> O(n)

         */
        public boolean containsDuplicate(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i=0; i<nums.length; i++){
                if(map.containsKey(nums[i])){
                    return true;
                }
                map.put(nums[i],i);
            }
            return false;
        }
    }
}

