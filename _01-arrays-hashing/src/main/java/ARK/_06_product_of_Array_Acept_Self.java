package ARK;

import java.util.Arrays;

public class _06_product_of_Array_Acept_Self {
    public static void main(String[] args) {
/*Given an integer array nums, return an array answer such that answer[i] is equal to the
product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operatio
link : https://leetcode.com/problems/product-of-array-except-self/description/
 */
        int[] nums = {1,2,3,4};

        solution1 solution1 = new solution1();
        System.out.println(Arrays.toString(solution1.productExceptSelf(nums)));
    }

    static class solution1{
        public int[] productExceptSelf(int[] nums) {
        /*
            space complexity : O(1) as no extra space is taken
            time complexity : O(n) + O(n) --> O(n)
         */
            int n = nums.length;
            int[] output = new int[n];

            if(n<1) return output;
            int product = 1;
            for(int i=0;i<n;i++) {

                product*=nums[i];
                output[i] = product;
            }

            product =1;
            for(int i=n-1;i>0;i--) {
                output[i] = output[i-1] * product;
                product*=nums[i];
            }
            output[0] = product;
            return output;
        }
    }
}
