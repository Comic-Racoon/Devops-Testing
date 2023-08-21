package ARK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _04_group_anagram {
    public static void main(String[] args) {
/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
link : https://leetcode.com/problems/group-anagrams/
*/
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        solution1 solution1 = new solution1();
        System.out.println(solution1.groupAnagrams(strs));
    }

    static class solution1{
        public List<List<String>> groupAnagrams(String[] strs){
/*
    spce complexity: HashMap stores at most N key-value pairs, where N is the number of strings in the input array.
                     O(N)
                     additional space is used to store the sorted characters (chars) for each string. Since
                     this space is reused for each string, it's still proportional to the total number of characters,
                     which is O(N).
        space complexity :  O(N)

    Time complexity:
        outer most loop      O(N)  *The loop iterates through each string*
        Arrays.sort(chars)  O(K * log(K)) K is the average length of the strings.
        HashMap operations (containsKey, put, get) O(1)
        creating the list of lists from the values of the map also takes O(N) time.

        O(N) * O(K * log(K)) --> O(N * K * log(K))

 */
            HashMap<String, List<String>> map = new HashMap<>();

            for ( String word : strs ){
                char[] chars = word.toCharArray();

                Arrays.sort(chars);

                String sortedWord = new String(chars);

                if (!map.containsKey(sortedWord)){
                    map.put(sortedWord, new ArrayList<>());
                }

                map.get(sortedWord).add(word);
            }

            return new ArrayList<>(map.values());
        }
    }
}
