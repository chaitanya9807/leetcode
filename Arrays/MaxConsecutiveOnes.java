package LeetCode.Explore.Arrays;

public class MaxConsecutiveOnes {
    // PROBLEM
//    Given a binary array, find the maximum number of consecutive 1s in this array.
//    Example :
//    Input: [1,1,0,1,1,1]
//    Output: 3
//    Explanation: The first two digits or the last three digits are consecutive 1s.
//    The maximum number of consecutive 1s is 3.
//    Note:
//    The input array will only contain 0 and 1.
//    The length of input array is a positive integer and will not exceed 10,000
    private static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0; // variable for maximum value of consecutiveOnes
        int count = 0; // variable for current number of consecutiveOnes while iterating
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){ // in case of element 1 increase count
                ++count;
            }
            else if(nums[i] == 0){ // in case of 0 element
                if(count > max){ // if current count > maximum count then replace max by count
                    max = count;
                }
                count = 0; // initialize count with 0 to denote the break in the current consecutiveOnes
            }
        }
        // to handle array with size 1 where element is also 1 where there is only one iteration and the current count is never assigned to max inside loop
        if(max >= count)
            return max;
        else
            return count;
    }
    public static void main(String[] args){
        int ans = findMaxConsecutiveOnes(new int[]{1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1,1,1,1,1,1}); // sample array
        System.out.println(ans);
    }
}
