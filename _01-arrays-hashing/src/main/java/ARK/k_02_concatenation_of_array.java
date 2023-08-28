package ARK;

import java.util.Arrays;

public class k_02_concatenation_of_array {
    /*
    Given an integer array nums of length n, you want to create an array
    ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

    link : https://leetcode.com/problems/concatenation-of-array/

     */
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        solution1 solution1 = new solution1();
        System.out.println(Arrays.toString(solution1.getConcatenation(nums)));

    }

    static class solution1{
        public int[] getConcatenation(int[] nums) {

            int[] arr = new int[nums.length * 2];
            int n = nums.length;

            for(int i=0;i<2*n;i++){
                arr[i]=nums[i%n];
            }

            return arr;
        }
    }
}
