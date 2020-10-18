package LeetCode.Problems;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {
//    Given a string s, find the length of the longest substring without repeating characters.
//
//    Example 1:
//    Input: s = "abcabcbb"
//    Output: 3
//    Explanation: The answer is "abc", with the length of 3.
//
//    Example 2:
//    Input: s = "bbbbb"
//    Output: 1
//    Explanation: The answer is "b", with the length of 1.
//
//    Example 3:
//    Input: s = "pwwkew"
//    Output: 3
//    Explanation: The answer is "wke", with the length of 3.
//    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//            Example 4:
//
//    Input: s = ""
//    Output: 0
//
//    Constraints:
//
//            0 <= s.length <= 5 * 10^4
//    s consists of English letters, digits, symbols and spaces.

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s.length();
        HashMap<Character,Integer> map = new HashMap<>(); // to search the element in the traversed substring fast
        int max = 0, count = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(count > max)
                    max = count;
                i = map.get(s.charAt(i)); // to start over from the point where the repeated character was found
                map.clear(); // to create a new substring
                count = 0;
            }else{
                map.put(s.charAt(i),i);
                count++;
            }
        }
        if(count > max)
            return count;
        return max;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}
