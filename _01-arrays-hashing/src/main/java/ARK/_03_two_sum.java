package ARK;

import java.util.Arrays;
import java.util.HashMap;

public class _03_two_sum {
    public static void main(String[] args) {
/*
Two sum :
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
link : https://leetcode.com/problems/two-sum/
 */

        int[] nums   = {2,7,11,15};
        int   target = 9;
        solution1 solution1 = new solution1();
        System.out.println(Arrays.toString(solution1.twoSum(nums, target)));
    }

    static class solution1{
/*
    Space complexity =
        The function uses a HashMap to store the numbers and their indices. In the worst case, if all elements in
        nums are unique, the HashMap can store up to nums.length key-value pairs.
        Therefore, the space complexity of the function is O(n), where n is the size of the nums array.

        spca comp = O (n)


    Time Complexity =
        Hash Map loop =  n
        searching     =  n
        look up for hash map is o(1)

        so = (n + n * 1) = 2n = n
        time complex = o(n)
 */
        public int[] twoSum(int[] nums, int target){
            HashMap<Integer, Integer> map = new HashMap<>();

        // fill the hash map
        for ( int i = 0; i<= nums.length -1 ; i++){
            map.put(nums[i], i);
        }

        // searching
        for(int i = 0; i <= nums.length -1; i++){
            int num = nums[i];
            int rem = target - num;

            if (map.containsKey(rem)){
                int index = map.get(rem);
                if (index == i) continue;
                return new int[] {i, index};
            }
        }
        return new int[] {};
        }
    }
}
