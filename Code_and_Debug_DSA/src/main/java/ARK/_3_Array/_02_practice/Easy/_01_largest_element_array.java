package main.java.ARK._3_Array._02_practice.Easy;

public class _01_largest_element_array {
//    link : https://www.codingninjas.com/studio/problems/largest-element-in-the-array-largest-element-in-the-array_5026279

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int arr_len=5;

        solution1 solution1 = new solution1();
        System.out.println(solution1.greatest_int(arr, arr_len));
    }

    private static class solution1 {
        /*
        Space Complexity :
            The space complexity is determined by the space taken by two integer variables, greatest and i.
            These variables occupy a constant amount of space, so they contribute O(1) to the space complexity.
            Additionally, there is an input array arr, but this is not counted in the space complexity as it is part of
            the input and not additional space used by the algorithm itself.
            Therefore, the overall space complexity is O(1), indicating a constant amount of space used.

            space complex -> O(1)

        Time Complexity :
            The time complexity is primarily determined by the loop that iterates over the elements of the array.
            The loop runs 'n' times, where 'n' is the length of the input array arr.
            Inside the loop, there's a comparison operation (if statement), which is a constant-time operation.
            The time complexity is proportional to the number of iterations of the loop, which is 'n'.
            Therefore, the time complexity of this code is O(n), indicating a linear time complexity.

            time complex --> O(n)

         */
        public int greatest_int (int[] arr, int n) {
            int greatest = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > greatest) {
                    greatest = arr[i];
                }
            }
            return greatest;
        }
    }
}
