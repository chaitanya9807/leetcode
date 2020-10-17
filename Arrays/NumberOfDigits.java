package LeetCode.Explore.Arrays;

public class NumberOfDigits {
//  PROBLEM
//Given an array nums of integers, return how many of them contain an even number of digits.
//
//    Example 1:
//    Input: nums = [12,345,2,6,7896]
//    Output: 2
//    Explanation:
//            12 contains 2 digits (even number of digits).
//            345 contains 3 digits (odd number of digits).
//            2 contains 1 digit (odd number of digits).
//            6 contains 1 digit (odd number of digits).
//            7896 contains 4 digits (even number of digits).
//    Therefore only 12 and 7896 contain an even number of digits.
//
//    Example 2:
//    Input: nums = [555,901,482,1771]
//    Output: 1
//    Explanation:
//    Only 1771 contains an even number of digits.
    private static int numberOfDigits(int n){
        // function to count number of digits
        int count = 0;
        while(n != 0)
        {
            count++;
            n = n /10;
        }
        return count;
    }
    private static int evenDigitNumberCount(int[] nums){
        int count = 0;
        for (int a: nums) {
            if(numberOfDigits(a) % 2 == 0) // if digits in an element is even, increase count
                count++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(evenDigitNumberCount(new int[]{1011,1,2,232,232323,43433}));
    }
}
