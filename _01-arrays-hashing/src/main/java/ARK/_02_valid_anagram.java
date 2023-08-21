package ARK;

import java.util.Arrays;

public class _02_valid_anagram {
    public static void main(String[] args) {
/*
        Given two strings s and t, return true if t is an anagram of s, and false otherwise.
        An Anagram is a word or phrase formed by rearranging the letters of a different word or
        phrase, typically using all the original letters exactly once.
        link : https://leetcode.com/problems/valid-anagram/
 */
        String s = "anagram";
        String t = "nagaram";

        soluton1 soluton1 = new soluton1();
        System.out.println(soluton1.isAnagram(s,t));

        solution2 solution2 = new solution2();
        System.out.println(solution2.isAnagram(s,t));
    }

    static class soluton1{

        /*
        space complexity : It is determined by space take by 2 char arrays schar adn tchar
                           The space required by these arrays is proportional to the length
                           of the input strings, so it's O(n)
                           Arrays.sort is generally O(log n), where n is the length of the array being sorted

                           so over all space complex -> O(n)

         time complexity : It is primarily determined by Arrays.sort
                           The sorting operation takes O(n log n) time complexity
                           Arrays.equals operation takes linear time, O(n)

                           O(n log n)+ O(n) --> O(n log n )
         */
        public boolean isAnagram(String s, String t) {
            // sorting

            char[] schar = s.toCharArray();
            char[] tchar = t.toCharArray();

            Arrays.sort(schar);
            Arrays.sort(tchar);

            return Arrays.equals(schar, tchar);
        }
    }

    static class solution2{
        public boolean isAnagram(String s , String t) {

            /*
            Space complex : count [] --> n (fix length) : O(1)

            time complex : 3 loops
                           n(s) + n(t) + n(n)(t) --> n : O(t + s)
             */
            int[] count = new int[26];
            // Count the frequency of characters in string s
            for (char x : s.toCharArray()) {
                count[x - 'a']++;
            }

            // Decrement the frequency of characters in string t
            for (char x : t.toCharArray()) {
                count[x - 'a']--;
            }

            // Check if any character has non-zero frequency
            for (int val : count) {
                if (val != 0) {
                    return false;
                }
            }

            return true;
        }
    }

}
