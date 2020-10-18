package LeetCode.Problems;

public class LongestPalindrome {
    //    Given a string s, return the longest palindromic substring in s.
//
//    Example 1:
//    Input: s = "babad"
//    Output: "bab"
//    Note: "aba" is also a valid answer.
//
//    Example 2:
//    Input: s = "cbbd"
//    Output: "bb"
//
//    Example 3:
//    Input: s = "a"
//    Output: "a"
//
//    Example 4:
//    Input: s = "ac"
//    Output: "a"
//
//    Constraints:
//    1 <= s.length <= 1000
//    s consist of only digits and English letters (lower-case and/or upper-case),
    
    public static String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s;
        int start = 0, right = 0;
        for(int i = 0; i< s.length();i++){
            int case1Length = increaseSubstringFromMiddle(s,i,i);
            int case2Length = increaseSubstringFromMiddle(s,i,i+1);
            int length = Math.max(case1Length, case2Length);
            if(length > right - start){
                start = i - ((length - 1)/2);
                right = i + (length/2);
            }
        }
        return s.substring(start,right + 1);

    }
    public static int increaseSubstringFromMiddle(String s, int left, int right){
        if(s == null || left > right) return 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++;
        }
        return right - left - 1;
    }
}
